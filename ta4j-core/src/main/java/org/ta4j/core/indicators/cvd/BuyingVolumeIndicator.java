package org.ta4j.core.indicators.cvd;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.indicators.helpers.ConstantIndicator;
import org.ta4j.core.num.Num;

 class BuyingVolumeIndicator extends AbstractVolumeIndicator {

     BuyingVolumeIndicator(BarSeries series) {
        super(series);
    }

    @Override
    protected Num calculate(int index) {
        return calculateVolume(index, ()->close.isGreaterThan(open));
    }
}
