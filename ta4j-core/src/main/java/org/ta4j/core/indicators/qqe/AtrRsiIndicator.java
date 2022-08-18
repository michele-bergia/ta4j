package org.ta4j.core.indicators.qqe;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.num.Num;

class AtrRsiIndicator extends CachedIndicator<Num> {

    private final EMAIndicator rsiMaIndicator;

    AtrRsiIndicator(BarSeries series, EMAIndicator rsiMaIndicator) {
        super(series);
        this.rsiMaIndicator = rsiMaIndicator;
    }

    @Override
    protected Num calculate(int index) {
        return rsiMaIndicator.getValue(index - 1).minus(rsiMaIndicator.getValue(index)).abs();
    }
}
