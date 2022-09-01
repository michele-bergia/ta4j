package org.ta4j.core.indicators.qqe;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.RecursiveCachedIndicator;
import org.ta4j.core.num.Num;

public class PrevLongBandIndicator extends CachedIndicator<Num> {

    private final LongBandIndicator longBandIndicator;

    protected PrevLongBandIndicator(BarSeries series, LongBandIndicator longBandIndicator) {
        super(series);
        this.longBandIndicator = longBandIndicator;
    }

    @Override
    protected Num calculate(int index) {
        return longBandIndicator.getValue(index - 1);
    }
}
