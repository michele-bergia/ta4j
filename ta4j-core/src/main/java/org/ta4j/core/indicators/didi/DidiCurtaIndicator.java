package org.ta4j.core.indicators.didi;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.num.Num;

public class DidiCurtaIndicator extends GenericDidiIndicator {

    private final SMAIndicator smaSmallIndicator;

    DidiCurtaIndicator(BarSeries series, int mid, int small) {
        super(series, mid);
        smaSmallIndicator = new SMAIndicator(closeIndicator, small);
    }

    @Override
    protected Num calculate(int index) {
        return smaSmallIndicator.getValue(index).minus(smaMidIndicator.getValue(index));
    }
}
