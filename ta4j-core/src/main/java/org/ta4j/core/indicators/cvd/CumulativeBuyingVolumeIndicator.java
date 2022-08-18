package org.ta4j.core.indicators.cvd;

import org.ta4j.core.BarSeries;

public class CumulativeBuyingVolumeIndicator extends AbstractCumulativeVolumeIndicator {

    public CumulativeBuyingVolumeIndicator(BarSeries series, int cumulationLength) {
        super(series, cumulationLength, new BuyingVolumeIndicator(series));
    }

}
