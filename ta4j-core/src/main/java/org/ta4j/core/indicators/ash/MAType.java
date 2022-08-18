package org.ta4j.core.indicators.ash;

import org.ta4j.core.BarSeries;
import org.ta4j.core.Indicator;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.indicators.HMAIndicator;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.WMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.num.Num;

public enum MAType {
    SMA {
        @Override
        public Indicator<Num> init(BarSeries barSeries, int length) {
            return init(new ClosePriceIndicator(barSeries), length);
        }

        @Override
        public Indicator<Num> init(Indicator<Num> indicator, int length) {
            return new SMAIndicator(indicator, length);
        }
    },
    EMA {
        @Override
        public Indicator<Num> init(BarSeries barSeries, int length) {
            return init(new ClosePriceIndicator(barSeries), length);
        }

        @Override
        public Indicator<Num> init(Indicator<Num> indicator, int length) {
            return new EMAIndicator(indicator, length);
        }
    },
    WMA {
        @Override
        public Indicator<Num> init(BarSeries barSeries, int length) {
            return init(new ClosePriceIndicator(barSeries), length);
        }

        @Override
        public Indicator<Num> init(Indicator<Num> indicator, int length) {
            return new WMAIndicator(indicator, length);
        }
    },
    SMMA {
        @Override
        public Indicator<Num> init(BarSeries barSeries, int length) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Indicator<Num> init(Indicator<Num> indicator, int length) {
            throw new UnsupportedOperationException();
        }
    },
    HMA {
        @Override
        public Indicator<Num> init(BarSeries barSeries, int length) {
            return init(new ClosePriceIndicator(barSeries), length);

        }

        @Override
        public Indicator<Num> init(Indicator<Num> indicator, int length) {
            return new HMAIndicator(indicator, length);
        }
    },
    ALMA {
        @Override
        public Indicator<Num> init(BarSeries barSeries, int length) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Indicator<Num> init(Indicator<Num> indicator, int length) {
            throw new UnsupportedOperationException();
        }
    };


    public abstract Indicator<Num> init(BarSeries barSeries, int length);

    public abstract Indicator<Num> init(Indicator<Num> indicator, int length);

}
