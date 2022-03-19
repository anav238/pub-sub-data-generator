package common;

import publications.PublicationField;

import java.util.Date;
import java.util.SplittableRandom;

public class RandomFieldsUtils {

    private static final Company[] companies = Company.values();
    private static final SplittableRandom random = new SplittableRandom();

    public static Object getRandomFieldValue(PublicationField fieldType) {
        return switch (fieldType) {
            case COMPANY -> getRandomCompanyFieldValue();
            case VALUE -> getRandomValueFieldValue();
            case DROP -> getRandomDropFieldValue();
            case VARIATION -> getRandomVariationFieldValue();
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
