package org.ta4j.core.indicators.vortex;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.helpers.SumIndicator;
import org.ta4j.core.num.Num;

class VMMIndicator extends AbstractIndicator {

    VMMIndicator(BarSeries series, int period) {
        super(series, new SumIndicator(new VMMIndicatorHelper(series), period));
    }

}
