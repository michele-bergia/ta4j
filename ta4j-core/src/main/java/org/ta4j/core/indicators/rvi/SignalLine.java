package org.ta4j.core.indicators.rvi;

import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.num.Num;

public class SignalLine extends CachedIndicator<Num> {

    private final RVIndicator rvIndicator;

    public SignalLine(RVIndicator rvIndicator) {
        super(rvIndicator);
        this.rvIndicator = rvIndicator;
    }

    @Override
    protected Num calculate(int index) {
        final Num currentRVI = rvIndicator.getValue(index);
        final Num oneRVIBefore = rvIndicator.getValue(index - 1);
        final Num twoRVIBefore = rvIndicator.getValue(index - 2);
        final Num threeRVIBefore = rvIndicator.getValue(index - 3);

        return currentRVI
                .plus(oneRVIBefore.multipliedBy(numOf(2)))
                .plus(twoRVIBefore.multipliedBy(numOf(2)))
                .plus(threeRVIBefore)
                .dividedBy(numOf(6));
    }
}
