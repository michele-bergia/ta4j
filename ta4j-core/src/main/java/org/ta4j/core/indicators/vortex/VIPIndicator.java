package org.ta4j.core.indicators.vortex;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.num.Num;

public class VIPIndicator extends CachedIndicator<Num> {

    private final VMPIndicator vmpIndicator;
    private final STRIndicator strIndicator;

    VIPIndicator(BarSeries series, int period) {
        super(series);
        vmpIndicator = new VMPIndicator(series, period);
        strIndicator = new STRIndicator(series, period);
    }

    @Override
    protected Num calculate(int index) {
        return vmpIndicator.getValue(index).dividedBy(strIndicator.getValue(index));
    }
}
