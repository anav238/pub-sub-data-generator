package subscriptions;

import common.MathUtils;

import java.util.Properties;

public class SubscriptionGeneratorConfiguration {
    private final int subscriptionsToGenerate;

    private final int companySubscriptions;
    private final int valueSubscriptions;
    private final int dropSubscriptions;
    private final int variationSubscriptions;
    private final int dateSubscriptions;

    private final int companyEqualsSubscriptions;

    public SubscriptionGeneratorConfiguration(Properties properties) {
        this.subscriptionsToGenerate = Integer.parseInt(properties.getProperty("NO_OF_SUBSCRIPTIONS"));

        int companySubscriptionFrequency = Integer.parseInt(properties.getProperty("COMPANY_SUBSCRIPTION_FREQUENCY"));
        int valueSubscriptionFrequency = Integer.parseInt(properties.getProperty("VALUE_SUBSCRIPTION_FREQUENCY"));
        int dropSubscriptionFrequency = Integer.parseInt(properties.getProperty("DROP_SUBSCRIPTION_FREQUENCY"));
        int variationSubscriptionFrequency = Integer.parseInt(properties.getProperty("VARIATION_SUBSCRIPTION_FREQUENCY"));
        int dateSubscriptionFrequency = Integer.parseInt(properties.getProperty("DATE_SUBSCRIPTION_FREQUENCY"));

        this.companySubscriptions = MathUtils.getRoundedValueOfPercentage(companySubscriptionFrequency, subscriptionsToGenerate);
        this.valueSubscriptions = MathUtils.getRoundedValueOfPercentage(valueSubscriptionFrequency, subscriptionsToGenerate);
        this.dropSubscriptions = MathUtils.getRoundedValueOfPercentage(dropSubscriptionFrequency, subscriptionsToGenerate);
        this.variationSubscriptions = MathUtils.getRoundedValueOfPercentage(variationSubscriptionFrequency, subscriptionsToGenerate);
        this.dateSubscriptions = MathUtils.getRoundedValueOfPercentage(dateSubscriptionFrequency, subscriptionsToGenerate);

        int companyEqualsFrequency = Integer.parseInt(properties.getProperty("COMPANY_EQUALS_FREQUENCY"));

        this.companyEqualsSubscriptions = MathUtils.getRoundedValueOfPercentage(companyEqualsFrequency, companySubscriptions);
    }

    public int getSubscriptionsToGenerate() {
        return subscriptionsToGenerate;
    }

    public int getCompanySubscriptions() {
        return companySubscriptions;
    }

    public int getValueSubscriptions() {
        return valueSubscriptions;
    }

    public int getDropSubscriptions() {
        return dropSubscriptions;
    }

    public int getVariationSubscriptions() {
        return variationSubscriptions;
    }

    public int getDateSubscriptions() {
        return dateSubscriptions;
    }

    public int getCompanyEqualsSubscriptions() {
        return companyEqualsSubscriptions;
    }
}
