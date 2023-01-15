package org.ta4j.core.indicators.qqe;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.indicators.RecursiveCachedIndicator;
import org.ta4j.core.num.NaN;
import org.ta4j.core.num.Num;

abstract class BandIndicator extends RecursiveCachedIndicator<Num> {

    protected final EMAIndicator rsiMaIndicator;
    protected final DarIndicator darIndicator;

    BandIndicator(BarSeries series, EMAIndicator rsiMaIndicator, DarIndicator darIndicator) {
        super(series);
        this.rsiMaIndicator = rsiMaIndicator;
        this.darIndicator = darIndicator;
    }

    protected abstract Num calculate(Num rsiIndex, Num prevRsiIndex, Num prevBand, Num deltaFastAtrRsi);

    @Override
    protected Num calculate(int index) {
        if (index == getBarSeries().getBeginIndex()) {
            return NaN.NaN;
        }

        Num rsiIndex = rsiMaIndicator.getValue(index);
        Num prevRsiIndex = rsiMaIndicator.getValue(index - 1);
        Num prevBand = getValue(index - 1);

        Num deltaFastAtrRsi = darIndicator.getValue(index);

        return calculate(rsiIndex, prevRsiIndex, prevBand, deltaFastAtrRsi);

    }

}
