package common;

import subscriptions.ComparisonOperator;

import java.util.Date;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private static final ComparisonOperator[] comparisonOperators = ComparisonOperator.values();
    private static final SplittableRandom random = new SplittableRandom();

    public static Date getRandomDateInRange(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }

    public static double getRandomDoubleInRange(double rangeMin, double rangeMax) {
        return rangeMin + (rangeMax - rangeMin) * random.nextDouble();
    }

    public static ComparisonOperator getRandomComparisonOperator() {
        return comparisonOperators[random.nextInt(comparisonOperators.length)];
    }

}
