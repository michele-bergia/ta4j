package org.ta4j.core.indicators.qqe;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.RecursiveCachedIndicator;
import org.ta4j.core.num.Num;

public class PrevShortBandIndicator extends CachedIndicator<Num> {

    private final ShortBandIndicator shortBandIndicator;

    protected PrevShortBandIndicator(BarSeries series, ShortBandIndicator shortBandIndicator) {
        super(series);
        this.shortBandIndicator = shortBandIndicator;
    }

    @Override
    protected Num calculate(int index) {
        return shortBandIndicator.getValue(index - 1);
    }
}
