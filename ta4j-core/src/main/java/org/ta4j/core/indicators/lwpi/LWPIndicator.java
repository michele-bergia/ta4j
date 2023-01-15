package org.ta4j.core.indicators.lwpi;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.ATRIndicator;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.num.Num;

public class LWPIndicator extends CachedIndicator<Num> {

    final SMAIndicator smaIndicator;
    final ATRIndicator atrIndicator;

    public LWPIndicator(BarSeries barSeries, int length) {
        super(barSeries);


        smaIndicator = new SMAIndicator(new OpenCloseIndicator(barSeries), length);
        atrIndicator = new ATRIndicator(barSeries, length);

    }

    @Override
    protected Num calculate(int index) {
        return numOf(50).multipliedBy(smaIndicator.getValue(index)).dividedBy(atrIndicator.getValue(index)).plus(numOf(50));
    }
}
