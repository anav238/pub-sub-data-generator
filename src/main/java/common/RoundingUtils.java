package common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingUtils {
    public static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        BigDecimal bigDecimal = BigDecimal.valueOf(value).setScale(places, RoundingMode.HALF_UP);

        return bigDecimal.doubleValue();
    }
}
