package org.ta4j.core.indicators.ash;

import org.ta4j.core.BarSeries;
import org.ta4j.core.Indicator;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.num.Num;

public class SmoothBearsASHIndicator extends CachedIndicator<Num> {

    private final Indicator<Num> maIndicator;

    protected SmoothBearsASHIndicator(BarSeries series, MAType maType, int length, int smooth) {
        super(series);
        maIndicator = maType.init(new AverageBearsASHIndicator(getBarSeries(), maType, length), smooth);
    }

    @Override
    protected Num calculate(int index) {
        return maIndicator.getValue(index);
    }
}
