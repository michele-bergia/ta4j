package org.ta4j.core.indicators.vortex;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.helpers.HighPriceIndicator;
import org.ta4j.core.indicators.helpers.LowPriceIndicator;
import org.ta4j.core.num.Num;

class VMPIndicatorHelper extends CachedIndicator<Num> {

    private final HighPriceIndicator highPriceIndicator;
    private final LowPriceIndicator lowPriceIndicator;

    VMPIndicatorHelper(BarSeries series) {
        super(series);
        highPriceIndicator = new HighPriceIndicator(series);
        lowPriceIndicator = new LowPriceIndicator(series);
    }

    @Override
    protected Num calculate(int index) {
        if (index <= 0) {
            return numOf(0);
        }
        return highPriceIndicator.getValue(index).minus(lowPriceIndicator.getValue(index - 1)).abs();
    }
}
