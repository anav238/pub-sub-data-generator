package common;

import publications.PublicationField;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.SplittableRandom;

import static common.MathUtils.round;

public class RandomFieldsUtils {

    private static final Company[] companies = Company.values();
    private static final SplittableRandom random = new SplittableRandom();
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public static Object getRandomFieldValue(PublicationField fieldType) {
        return switch (fieldType) {
            case COMPANY -> getRandomCompanyFieldValue();
            case VALUE -> round(getRandomValueFieldValue(), 2);
            case DROP -> round(getRandomDropFieldValue(), 2);
            case VARIATION -> round(getRandomVariationFieldValue(), 2);
            case DATE -> getRandomDateFieldValue();
        };
    }

    private static Company getRandomCompanyFieldValue() {
        return companies[random.nextInt(companies.length)];
    }

    private static double getRandomValueFieldValue() {
        return RandomUtils.getRandomDoubleInRange(Constants.MIN_VALUE, Constants.MAX_VALUE);
    }

    private static double getRandomDropFieldValue() {
        return RandomUtils.getRandomDoubleInRange(Constants.MIN_DROP, Constants.MAX_DROP);
    }

    private static double getRandomVariationFieldValue() {
        return RandomUtils.getRandomDoubleInRange(Constants.MIN_VARIATION, Constants.MAX_VARIATION);
    }

    private static Date getRandomDateFieldValue() {
        return RandomUtils.getRandomDateInRange(Constants.START_DATE, Constants.END_DATE);
    }

}
