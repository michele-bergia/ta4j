package org.ta4j.core.indicators.vortex;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.helpers.SumIndicator;

class VMPIndicator extends AbstractIndicator {

    VMPIndicator(BarSeries series, int period) {
        super(series, new SumIndicator(new VMPIndicatorHelper(series), period));
    }

}
