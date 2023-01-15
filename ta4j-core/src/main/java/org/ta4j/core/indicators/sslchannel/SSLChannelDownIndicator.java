package org.ta4j.core.indicators.sslchannel;

import org.ta4j.core.BarSeries;
import org.ta4j.core.num.DecimalNum;
import org.ta4j.core.num.Num;

public class SSLChannelDownIndicator extends AbstractSSLChannelIndicator {

    /**
     * Constructor.
     *
     * @param series the related bar series
     * @param period
     */
    public SSLChannelDownIndicator(BarSeries series, int period) {
        super(series, period);
    }

    @Override
    protected Num calculate(int index) {
        return hlvValue.getValue(index).isLessThan(DecimalNum.valueOf(0))
                ? smaHighIndicator.getValue(index)
                : smaLowIndicator.getValue(index);
    }
}
