package org.ta4j.core.indicators.vortex;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.helpers.SumIndicator;
import org.ta4j.core.num.Num;

abstract class AbstractIndicator extends CachedIndicator<Num> {

    private final SumIndicator sumIndicator;

    AbstractIndicator(BarSeries series, SumIndicator sumIndicator) {
        super(series);
        this.sumIndicator = sumIndicator;
    }

    @Override
    protected Num calculate(int index) {
        return sumIndicator.getValue(index);
    }

}
