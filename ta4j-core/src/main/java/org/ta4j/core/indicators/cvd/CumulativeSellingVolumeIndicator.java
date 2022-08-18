package org.ta4j.core.indicators.cvd;

import org.ta4j.core.BarSeries;

public class CumulativeSellingVolumeIndicator extends AbstractCumulativeVolumeIndicator {

    public CumulativeSellingVolumeIndicator(BarSeries series, int cumulationLength) {
        super(series, cumulationLength, new SellingVolumeIndicator(series));
    }
}
