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


    TrendIndicator(BarSeries series, EMAIndicator rsiMaIndicator, LongBandIndicator prevLongBandIndicator, ShortBandIndicator prevShortBandIndicator) {
        super(series);

        shortBandCrossedUp = new CrossedUpIndicatorRule(rsiMaIndicator, prevShortBandIndicator);
        shortBandCrossedDown = new CrossedDownIndicatorRule(rsiMaIndicator, prevShortBandIndicator);

        longBandCrossedUp = new CrossedUpIndicatorRule(prevLongBandIndicator, rsiMaIndicator);
        longBandCrossedDown = new CrossedDownIndicatorRule(prevLongBandIndicator, rsiMaIndicator);

    }

    @Override
    protected Boolean calculate(int index) {
        if (index == 0) {
            return true;
        }

        if (shortBandCrossedUp.isSatisfied(index - 1) || shortBandCrossedDown.isSatisfied(index - 1)) {
            return true;
        } else {

            if (longBandCrossedUp.isSatisfied(index - 1) || longBandCrossedDown.isSatisfied(index - 1)) {
                return false;
            } else {
                return getValue(index - 1);
            }
        }

    }
}
