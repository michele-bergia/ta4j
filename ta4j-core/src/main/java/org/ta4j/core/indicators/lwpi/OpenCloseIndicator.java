package org.ta4j.core.indicators.lwpi;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.indicators.helpers.OpenPriceIndicator;
import org.ta4j.core.num.Num;

class OpenCloseIndicator extends CachedIndicator<Num> {

    private final ClosePriceIndicator closePriceIndicator;
    private final OpenPriceIndicator openPriceIndicator;

    OpenCloseIndicator(BarSeries series) {
        super(series);
        closePriceIndicator = new ClosePriceIndicator(series);
        openPriceIndicator = new OpenPriceIndicator(series);
    }

    @Override
    protected Num calculate(int index) {
        return openPriceIndicator.getValue(index).minus(closePriceIndicator.getValue(index));
    }
}
