package org.ta4j.core.indicators.didi;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.num.Num;

abstract class GenericDidiIndicator extends CachedIndicator<Num> {

    protected final SMAIndicator smaMidIndicator;
    protected final ClosePriceIndicator closeIndicator;

    GenericDidiIndicator(BarSeries series, int mid) {
        super(series);
        closeIndicator = new ClosePriceIndicator(series);
        smaMidIndicator = new SMAIndicator(closeIndicator, mid);
    }
}
