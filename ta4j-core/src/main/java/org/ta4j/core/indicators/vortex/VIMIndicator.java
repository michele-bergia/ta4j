package org.ta4j.core.indicators.vortex;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.num.Num;

public class VIMIndicator extends CachedIndicator<Num> {

    private final VMMIndicator vmmIndicator;
    private final STRIndicator strIndicator;

    VIMIndicator(BarSeries series, int period) {
        super(series);
        vmmIndicator = new VMMIndicator(series, period);
        strIndicator = new STRIndicator(series, period);
    }

    @Override
    protected Num calculate(int index) {
        return vmmIndicator.getValue(index).dividedBy(strIndicator.getValue(index));
    }
}
