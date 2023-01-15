package org.ta4j.core.indicators.vortex;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.num.Num;

/**
 * Vortex Indicator
 * Confirmation Indicator:
 *  - Long: when the VIM indicator crosses up the VIP indicator, then enter the trade, opposite for sell.
 *  - Short: when the VIP indicator crosses up the VIM indicator, then enter the trade, opposite for sell.
 */
public class VortexIndicator extends CachedIndicator<Num> {

    private final VIPIndicator vipIndicator;
    private final VIMIndicator vimIndicator;

    public VortexIndicator(BarSeries series, int period) {
        super(series);
        vimIndicator = new VIMIndicator(series, period);
        vipIndicator = new VIPIndicator(series, period);
    }

    public VIPIndicator getVipIndicator() {
        return vipIndicator;
    }

    public VIMIndicator getVimIndicator() {
        return vimIndicator;
    }

    @Override
    protected Num calculate(int index) {
        return vipIndicator.getValue(index);
    }

}
