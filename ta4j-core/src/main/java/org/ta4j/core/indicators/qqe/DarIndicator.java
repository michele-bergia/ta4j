package org.ta4j.core.indicators.qqe;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.num.Num;

class DarIndicator extends CachedIndicator<Num> {

    private final double qqe;

    private final EMAIndicator dar;

    DarIndicator(BarSeries series, EMAIndicator maAtrRsiIndicator, int wildersPeriod, double qqe) {
        super(series);
        this.qqe = qqe;
        dar = new EMAIndicator(maAtrRsiIndicator, wildersPeriod);
    }

    @Override
    protected Num calculate(int index) {
        return dar.getValue(index).multipliedBy(numOf(qqe));
    }
}
