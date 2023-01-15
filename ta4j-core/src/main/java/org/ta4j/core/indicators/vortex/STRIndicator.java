package org.ta4j.core.indicators.vortex;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.ATRIndicator;
import org.ta4j.core.indicators.helpers.SumIndicator;

class STRIndicator extends AbstractIndicator {

    STRIndicator(BarSeries series, int period) {
        super(series, new SumIndicator(new ATRIndicator(series, 1), period));
    }
}
