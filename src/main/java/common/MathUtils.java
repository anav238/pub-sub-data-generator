package common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtils {

    public static int getRoundedValueOfPercentage(double percentage, double from) {
        return (int) Math.ceil(getValueOfPercentage(percentage, from));
    }

    public static double getValueOfPercentage(double percentage, double from) {
        return percentage / 100 * from;
    }

    public static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        BigDecimal bigDecimal = BigDecimal.valueOf(value).setScale(places, RoundingMode.HALF_UP);

        return bigDecimal.doubleValue();
    }
}
