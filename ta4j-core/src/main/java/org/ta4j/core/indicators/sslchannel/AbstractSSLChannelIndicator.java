package org.ta4j.core.indicators.sslchannel;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.AbstractIndicator;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.HighPriceIndicator;
import org.ta4j.core.indicators.helpers.LowPriceIndicator;
import org.ta4j.core.num.Num;

abstract class AbstractSSLChannelIndicator extends CachedIndicator<Num> {

    protected final HlvValue hlvValue;

    protected final SMAIndicator smaHighIndicator;
    protected final SMAIndicator smaLowIndicator;

    /**
     * Constructor.
     *
     * @param series the related bar series
     */
    protected AbstractSSLChannelIndicator(BarSeries series, int period) {
        super(series);

        this.smaHighIndicator = new SMAIndicator(new HighPriceIndicator(series), period);
        this.smaLowIndicator = new SMAIndicator(new LowPriceIndicator(series), period);

        this.hlvValue = new HlvValue(series, smaHighIndicator, smaLowIndicator);
    }
}
