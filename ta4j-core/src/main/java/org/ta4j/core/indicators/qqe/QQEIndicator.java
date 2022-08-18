package org.ta4j.core.indicators.qqe;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.indicators.RSIIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.num.Num;

/**
 * QQE Indicator
 * Confirmation Indicator:
 *  - Long: when the RSI-MA indicator crosses up the Fast ATR RSI indicator, then enter the trade, opposite for sell.
 *  - Short: when the Fast ATR RSI indicator crosses up the RSI-MA indicator, then enter the trade, opposite for sell.
 */
public class QQEIndicator extends CachedIndicator<Num> {

    private final EMAIndicator rsiMaIndicator;
    private final FastAtrRsiIndicator fastAtrRsiIndicator;

    public QQEIndicator(BarSeries series, int rsi, int slowFactor, double qqe) {
        super(series);

        RSIIndicator rsiIndicator = new RSIIndicator(new ClosePriceIndicator(series), rsi);

        rsiMaIndicator = new EMAIndicator(rsiIndicator, slowFactor);


        final int wildersPeriod = rsi * 2 - 1;
        AtrRsiIndicator atrRsiIndicator = new AtrRsiIndicator(series, rsiMaIndicator);
        EMAIndicator maAtrRsiIndicator = new EMAIndicator(atrRsiIndicator, wildersPeriod);
        DarIndicator darIndicator = new DarIndicator(series, maAtrRsiIndicator, wildersPeriod, qqe);

        fastAtrRsiIndicator = new FastAtrRsiIndicator(getBarSeries(), rsiMaIndicator, darIndicator);

    }

    public QQEIndicator(BarSeries series, int rsi, int slowFactor) {
        this(series, rsi, slowFactor, 4.236);
    }

    public EMAIndicator getRsiMaIndicator() {
        return rsiMaIndicator;
    }

    public FastAtrRsiIndicator getFastAtrRsiIndicator() {
        return fastAtrRsiIndicator;
    }

    @Override
    protected Num calculate(int index) {
        return fastAtrRsiIndicator.getValue(index);
    }

}
