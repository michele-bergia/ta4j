package org.ta4j.core.indicators.rvi;

import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.AbstractIndicator;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.num.Num;

public class RVIndicator extends CachedIndicator<Num> {

    private final int barCount;

    /**
     * Constructor.
     *
     * @param series the related bar series
     */
    public RVIndicator(BarSeries series, int barCount) {
        super(series);
        this.barCount = barCount;
    }

    @Override
    protected Num calculate(int index) {
        return new SMAIndicator(new Numerator(getBarSeries()), barCount).getValue(index).dividedBy(
                new SMAIndicator(new Denominator(getBarSeries()), barCount).getValue(index)
        );
    }

    private Bar[] getEligibleBars(int index) {
        return index < 3
                ? null
                : new Bar[]{
                getBarSeries().getBar(index),
                getBarSeries().getBar(index - 1),
                getBarSeries().getBar(index - 2),
                getBarSeries().getBar(index - 3)
        };
    }

    private class Numerator extends AbstractIndicator<Num> {

        /**
         * Constructor.
         *
         * @param series the related bar series
         */
        protected Numerator(BarSeries series) {
            super(series);
        }

        @Override
        public Num getValue(int index) {
            final Bar[] eligibleBars = getEligibleBars(index);
            if (eligibleBars == null) {
                return numOf(-1);
            }

            Num a = eligibleBars[0].getClosePrice().minus(eligibleBars[0].getOpenPrice());
            Num b = eligibleBars[1].getClosePrice().minus(eligibleBars[1].getOpenPrice());
            Num c = eligibleBars[2].getClosePrice().minus(eligibleBars[2].getOpenPrice());
            Num d = eligibleBars[3].getClosePrice().minus(eligibleBars[3].getOpenPrice());

            return a.plus(b.multipliedBy(numOf(2))).plus(c.multipliedBy(numOf(2))).plus(d).dividedBy(numOf(6));
        }
    }

    private class Denominator extends AbstractIndicator<Num> {

        /**
         * Constructor.
         *
         * @param series the related bar series
         */
        protected Denominator(BarSeries series) {
            super(series);
        }

        @Override
        public Num getValue(int index) {
            final Bar[] eligibleBars = getEligibleBars(index);
            if (eligibleBars == null) {
                return numOf(-1);
            }

            Num e = eligibleBars[0].getHighPrice().minus(eligibleBars[0].getLowPrice());
            Num f = eligibleBars[1].getHighPrice().minus(eligibleBars[1].getLowPrice());
            Num g = eligibleBars[2].getHighPrice().minus(eligibleBars[2].getLowPrice());
            Num h = eligibleBars[3].getHighPrice().minus(eligibleBars[3].getLowPrice());

            return e.plus(f.multipliedBy(numOf(2))).plus(g.multipliedBy(numOf(2))).plus(h).dividedBy(numOf(6));
        }
    }

}
