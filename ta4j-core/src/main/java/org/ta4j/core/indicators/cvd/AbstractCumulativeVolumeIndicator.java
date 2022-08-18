package org.ta4j.core.indicators.cvd;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.num.Num;

abstract class AbstractCumulativeVolumeIndicator extends CachedIndicator<Num> {

    private final EMAIndicator cumulativeVolumeIndicator;

    AbstractCumulativeVolumeIndicator(BarSeries series, int cumulationLength, AbstractVolumeIndicator abstractVolumeIndicator) {
        super(series);
        this.cumulativeVolumeIndicator = new EMAIndicator(abstractVolumeIndicator, cumulationLength);
    }

    @Override
    protected Num calculate(int index) {
        return cumulativeVolumeIndicator.getValue(index);
    }
}
