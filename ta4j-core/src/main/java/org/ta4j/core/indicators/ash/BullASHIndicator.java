package org.ta4j.core.indicators.ash;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.num.DecimalNum;
import org.ta4j.core.num.Num;

class BullASHIndicator extends CachedIndicator<Num> {

    private final SMAIndicator smaIndicator;

    BullASHIndicator(BarSeries series) {
        super(series);
        smaIndicator = new SMAIndicator(new ClosePriceIndicator(getBarSeries()), 1);
    }

    @Override
    protected Num calculate(int index) {

        Num price1 = smaIndicator.getValue(index);
        Num price2 = smaIndicator.getValue(index - 1);

        return DecimalNum.valueOf(0.5).multipliedBy(price1.minus(price2).abs().plus(price1.minus(price2)));
    }
}
