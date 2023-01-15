package org.ta4j.core.indicators.sslchannel;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.AbstractIndicator;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.num.DecimalNum;
import org.ta4j.core.num.Num;

class HlvValue extends AbstractIndicator<Num> {

    private final ClosePriceIndicator closePriceIndicator;

    private final SMAIndicator smaHighIndicator;
    private final SMAIndicator smaLowIndicator;

    /**
     * Constructor.
     *
     * @param series the related bar series
     */
    protected HlvValue(BarSeries series, SMAIndicator smaHighIndicator, SMAIndicator smaLowIndicator) {
        super(series);
        this.closePriceIndicator = new ClosePriceIndicator(series);
        this.smaHighIndicator = smaHighIndicator;
        this.smaLowIndicator = smaLowIndicator;
    }

    @Override
    public Num getValue(int index) {
        if (getBarSeries().getBeginIndex() > index - 1) {
            return DecimalNum.valueOf(0);
        }

        return closePriceIndicator.getValue(index).isGreaterThan(smaHighIndicator.getValue(index))
                ? DecimalNum.valueOf(1)
                : closePriceIndicator.getValue(index).isLessThan(smaLowIndicator.getValue(index))
                ? DecimalNum.valueOf(-1)
                : getValue(index - 1);
    }
}
