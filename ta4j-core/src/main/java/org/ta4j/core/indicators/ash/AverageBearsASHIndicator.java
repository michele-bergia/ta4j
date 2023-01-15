package org.ta4j.core.indicators.ash;

import org.ta4j.core.BarSeries;
import org.ta4j.core.Indicator;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.num.Num;

class AverageBearsASHIndicator extends CachedIndicator<Num> {

    private final Indicator<Num> maIndicator;

    AverageBearsASHIndicator(BarSeries series, MAType maType, int length) {
        super(series);
        maIndicator = maType.init(new BearASHIndicator(getBarSeries()), length);
    }

    @Override
    protected Num calculate(int index) {
        return maIndicator.getValue(index);
    }
}
