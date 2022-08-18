package org.ta4j.core.indicators.qqe;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.num.Num;

class LongBandIndicator extends BandIndicator {

    LongBandIndicator(BarSeries series, EMAIndicator rsiMaIndicator, DarIndicator darIndicator) {
        super(series, rsiMaIndicator, darIndicator);
    }

    @Override
    protected Num calculate(Num rsiIndex, Num prevRsiIndex, Num prevBand, Num deltaFastAtrRsi) {
        Num newLongBand = rsiIndex.minus(deltaFastAtrRsi);

        return prevRsiIndex.isGreaterThan(prevBand) && rsiIndex.isGreaterThan(prevBand)
                ? prevBand.max(newLongBand)
                : newLongBand;
    }
}
