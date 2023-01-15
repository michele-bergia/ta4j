package org.ta4j.core.indicators.qqe;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.num.Num;

public class FastAtrRsiIndicator extends CachedIndicator<Num> {

    private final LongBandIndicator longBandIndicator;
    private final ShortBandIndicator shortBandIndicator;

    private final TrendIndicator trendIndicator;

    FastAtrRsiIndicator(BarSeries series, EMAIndicator rsiMaIndicator, DarIndicator darIndicator) {
        super(series);

        longBandIndicator = new LongBandIndicator(series, rsiMaIndicator, darIndicator);
        shortBandIndicator = new ShortBandIndicator(series, rsiMaIndicator, darIndicator);

        trendIndicator = new TrendIndicator(series, rsiMaIndicator, longBandIndicator, shortBandIndicator);
    }


    @Override
    protected Num calculate(int index) {
        return trendIndicator.getValue(index)
                ? longBandIndicator.getValue(index)
                : shortBandIndicator.getValue(index);
    }
}
