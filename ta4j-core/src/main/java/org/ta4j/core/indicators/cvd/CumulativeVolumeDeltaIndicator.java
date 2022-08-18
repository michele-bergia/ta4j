package org.ta4j.core.indicators.cvd;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.sslchannel.SSLChannelDownIndicator;
import org.ta4j.core.indicators.sslchannel.SSLChannelUpIndicator;
import org.ta4j.core.num.Num;

public class CumulativeVolumeDeltaIndicator extends CachedIndicator<Num> {

    private final CumulativeBuyingVolumeIndicator cumulativeBuyingVolumeIndicator;
    private final CumulativeSellingVolumeIndicator cumulativeSellingVolumeIndicator;

    public CumulativeVolumeDeltaIndicator(BarSeries series, int cumulationLength) {
        super(series);
        this.cumulativeBuyingVolumeIndicator = new CumulativeBuyingVolumeIndicator(series, cumulationLength);
        this.cumulativeSellingVolumeIndicator = new CumulativeSellingVolumeIndicator(series, cumulationLength);
    }

    public CumulativeBuyingVolumeIndicator getCumulativeBuyingVolumeIndicator() {
        return cumulativeBuyingVolumeIndicator;
    }

    public CumulativeSellingVolumeIndicator getCumulativeSellingVolumeIndicator() {
        return cumulativeSellingVolumeIndicator;
    }


    @Override
    protected Num calculate(int index) {
        return cumulativeBuyingVolumeIndicator.getValue(index).minus(cumulativeSellingVolumeIndicator.getValue(index));
    }
}
