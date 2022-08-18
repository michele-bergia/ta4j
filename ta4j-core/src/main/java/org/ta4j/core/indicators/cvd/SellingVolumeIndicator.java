package org.ta4j.core.indicators.cvd;

import org.ta4j.core.BarSeries;
import org.ta4j.core.num.Num;

class SellingVolumeIndicator extends AbstractVolumeIndicator {

    SellingVolumeIndicator(BarSeries series) {
        super(series);
    }

    @Override
    protected Num calculate(int index) {
        return calculateVolume(index, () -> close.isLessThan(open));
    }
}
