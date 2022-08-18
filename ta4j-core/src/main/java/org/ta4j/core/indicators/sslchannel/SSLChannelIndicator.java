package org.ta4j.core.indicators.sslchannel;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.num.Num;

public class SSLChannelIndicator extends CachedIndicator<Num> {

    private final SSLChannelUpIndicator sslChannelUpIndicator;
    private final SSLChannelDownIndicator sslChannelDownIndicator;

    public SSLChannelIndicator(BarSeries series, int period) {
        super(series);
        this.sslChannelUpIndicator = new SSLChannelUpIndicator(series, period);
        this.sslChannelDownIndicator = new SSLChannelDownIndicator(series, period);
    }

    public SSLChannelUpIndicator getSSLChannelUpIndicator() {
        return sslChannelUpIndicator;
    }

    public SSLChannelDownIndicator getSSLChannelDownIndicator() {
        return sslChannelDownIndicator;
    }

    @Override
    protected Num calculate(int index) {
        return sslChannelUpIndicator.getValue(index).minus(sslChannelDownIndicator.getValue(index));
    }
}
