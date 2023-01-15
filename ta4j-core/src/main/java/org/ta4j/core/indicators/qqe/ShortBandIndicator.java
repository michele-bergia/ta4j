package org.ta4j.core.indicators.qqe;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.num.Num;

class ShortBandIndicator extends BandIndicator {

    ShortBandIndicator(BarSeries series, EMAIndicator rsiMaIndicator, DarIndicator darIndicator) {
        super(series, rsiMaIndicator, darIndicator);
    }

    @Override
    protected Num calculate(Num rsiIndex, Num prevRsiIndex, Num prevBand, Num deltaFastAtrRsi) {
        Num newShortBand = rsiIndex.plus(deltaFastAtrRsi);

        return prevRsiIndex.isLessThan(prevBand) && rsiIndex.isLessThan(prevBand)
                ? prevBand.min(newShortBand)
                : newShortBand;
    }

}
