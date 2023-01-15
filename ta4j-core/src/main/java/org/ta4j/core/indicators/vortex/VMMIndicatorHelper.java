package org.ta4j.core.indicators.vortex;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.helpers.HighPriceIndicator;
import org.ta4j.core.indicators.helpers.LowPriceIndicator;
import org.ta4j.core.num.Num;

class VMMIndicatorHelper extends CachedIndicator<Num> {

    private final HighPriceIndicator highPriceIndicator;
    private final LowPriceIndicator lowPriceIndicator;

    VMMIndicatorHelper(BarSeries series) {
        super(series);
        highPriceIndicator = new HighPriceIndicator(series);
        lowPriceIndicator = new LowPriceIndicator(series);
    }

    @Override
    protected Num calculate(int index) {
        if (index <= 0) {
            return numOf(0);
        }
        return lowPriceIndicator.getValue(index).minus(highPriceIndicator.getValue(index - 1)).abs();
    }
}
