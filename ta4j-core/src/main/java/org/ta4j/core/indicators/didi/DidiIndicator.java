package org.ta4j.core.indicators.didi;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.num.Num;

/**
 * DiDi Indicator
 * Confirmation Indicator:
 * - Long: when the DiDi Curta indicator crosses up the DiDi Longa indicator, then enter the trade, opposite for sell.
 * - Short: when the DiDi Longa indicator crosses up the DiDi Curta indicator, then enter the trade, opposite for sell.
 */
public class DidiIndicator extends CachedIndicator<Num> {

    private final DidiLongaIndicator didiLongaIndicator;
    private final DidiCurtaIndicator didiCurtaIndicator;

    public DidiIndicator(BarSeries series, int big, int mid, int small) {
        super(series);
        didiLongaIndicator = new DidiLongaIndicator(series, mid, big);
        didiCurtaIndicator = new DidiCurtaIndicator(series, mid, small);
    }

    public DidiIndicator(BarSeries series, int big, int small) {
        this(series, big, 8, small);
    }

    public DidiLongaIndicator getDidiLongaIndicator() {
        return didiLongaIndicator;
    }

    public DidiCurtaIndicator getDidiCurtaIndicator() {
        return didiCurtaIndicator;
    }

    @Override
    protected Num calculate(int index) {
        return didiLongaIndicator.getValue(index);
    }
}
