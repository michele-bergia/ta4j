package org.ta4j.core.indicators.cvd;

import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.num.DecimalNum;
import org.ta4j.core.num.Num;

import java.util.function.Supplier;

abstract class AbstractVolumeIndicator extends CachedIndicator<Num> {
    protected Num close;
    protected Num high;
    protected Num open;
    protected Num low;
    protected Num volume;

    protected Num upperWick;
    protected Num lowerWick;
    protected Num spread;
    protected Num bodyLength;

    protected Num percentUpperWick;
    protected Num percentLowerWick;
    protected Num percentBodyLengthWick;

    AbstractVolumeIndicator(BarSeries series) {
        super(series);
    }

   Num calculateVolume(int index, Supplier<Boolean> volumeCondition) {
        final Bar bar = getBarSeries().getBar(index);

        close = bar.getClosePrice();
        high = bar.getHighPrice();
        open = bar.getOpenPrice();
        low = bar.getLowPrice();
        volume = bar.getVolume();

        boolean isCloseGreaterThenOpen = close.isGreaterThan(open);

        upperWick = isCloseGreaterThenOpen ? high.minus(close) : high.minus(open);
        lowerWick = isCloseGreaterThenOpen ? open.minus(low) : close.minus(low);
        spread = high.minus(low);
        bodyLength = spread.minus(upperWick.plus(lowerWick));

        percentUpperWick = upperWick.dividedBy(spread);
        percentLowerWick = lowerWick.dividedBy(spread);
        percentBodyLengthWick = bodyLength.dividedBy(spread);

       return volumeCondition.get()
               ? percentBodyLengthWick.plus(percentUpperWick.plus(percentLowerWick).dividedBy(DecimalNum.valueOf(2))).multipliedBy(volume)
               : percentUpperWick.plus(percentLowerWick).dividedBy(DecimalNum.valueOf(2)).multipliedBy(volume);

    }


}
