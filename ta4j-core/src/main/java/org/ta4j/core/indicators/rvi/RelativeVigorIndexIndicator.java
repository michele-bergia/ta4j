package org.ta4j.core.indicators.rvi;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.num.Num;

public class RelativeVigorIndexIndicator extends CachedIndicator<Num> {

    private final RVIndicator rvIndicator;
    private final SignalLine signalLine;

    public RelativeVigorIndexIndicator(BarSeries barSeries, int barCount) {
        super(barSeries);
        this.rvIndicator = new RVIndicator(barSeries, barCount);
        this.signalLine = new SignalLine(rvIndicator);
    }

    public RVIndicator getRvIndicator() {
        return rvIndicator;
    }

    public SignalLine getSignalLine() {
        return signalLine;
    }

    @Override
    protected Num calculate(int index) {
        return this.rvIndicator.getValue(index);
    }
}
