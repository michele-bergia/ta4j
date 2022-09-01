package org.ta4j.core.indicators.qqe;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.indicators.RecursiveCachedIndicator;
import org.ta4j.core.rules.CrossedDownIndicatorRule;
import org.ta4j.core.rules.CrossedUpIndicatorRule;

class TrendIndicator extends RecursiveCachedIndicator<Boolean> {

    private final CrossedUpIndicatorRule shortBandCrossedUp;
    private final CrossedDownIndicatorRule shortBandCrossedDown;

    private final CrossedUpIndicatorRule longBandCrossedUp;
    private final CrossedDownIndicatorRule longBandCrossedDown;


    TrendIndicator(BarSeries series, EMAIndicator rsiMaIndicator, LongBandIndicator longBandIndicator, ShortBandIndicator shortBandIndicator) {
        super(series);

        final PrevLongBandIndicator prevLongBandIndicator = new PrevLongBandIndicator(series, longBandIndicator);
        final PrevShortBandIndicator prevShortBandIndicator = new PrevShortBandIndicator(series, shortBandIndicator);

        shortBandCrossedUp = new CrossedUpIndicatorRule(rsiMaIndicator, prevShortBandIndicator);
        shortBandCrossedDown = new CrossedDownIndicatorRule(rsiMaIndicator, prevShortBandIndicator);

        longBandCrossedUp = new CrossedUpIndicatorRule(prevLongBandIndicator, rsiMaIndicator);
        longBandCrossedDown = new CrossedDownIndicatorRule(prevLongBandIndicator, rsiMaIndicator);

    }

    @Override
    protected Boolean calculate(int index) {
        if (index == getBarSeries().getBeginIndex()) {
            return true;
        }

        if (shortBandCrossedUp.isSatisfied(index) || shortBandCrossedDown.isSatisfied(index)) {
            return true;
        } else {

            if (longBandCrossedUp.isSatisfied(index) || longBandCrossedDown.isSatisfied(index)) {
                return false;
            } else {
                return getValue(index - 1);
            }
        }

    }
}
