package org.ta4j.core.indicators.ash;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.num.Num;

public class ASHIndicator extends CachedIndicator<Num> {

    private final SmoothBullsASHIndicator smoothBullsASHIndicator;
    private final SmoothBearsASHIndicator smoothBearsASHIndicator;

    public ASHIndicator(BarSeries series, MAType maType, int length, int smooth) {
        super(series);
        this.smoothBullsASHIndicator = new SmoothBullsASHIndicator(series, maType, length, smooth);
        this.smoothBearsASHIndicator = new SmoothBearsASHIndicator(series, maType, length, smooth);
    }

    public SmoothBullsASHIndicator getSmoothBullsASHIndicator() {
        return smoothBullsASHIndicator;
    }

    public SmoothBearsASHIndicator getSmoothBearsASHIndicator() {
        return smoothBearsASHIndicator;
    }

    @Override
    protected Num calculate(int index) {
        return smoothBullsASHIndicator.getValue(index);
    }
}
