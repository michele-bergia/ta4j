package org.ta4j.core.indicators.didi;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.num.Num;

public class DidiLongaIndicator extends GenericDidiIndicator {

    private final SMAIndicator smaBigIndicator;

    DidiLongaIndicator(BarSeries series, int mid, int big) {
        super(series, mid);
        smaBigIndicator = new SMAIndicator(closeIndicator, big);
    }

    @Override
    protected Num calculate(int index) {
        return smaBigIndicator.getValue(index).minus(smaMidIndicator.getValue(index));
    }
}
