package subscriptions;

import java.util.Properties;

public class SubscriptionGeneratorConfiguration {
    private final int subscriptionsToGenerate;
    private final int companySubscriptionFrequency;
    private final int valueSubscriptionFrequency;
    private final int dropSubscriptionFrequency;
    private final int variationSubscriptionFrequency;
    private final int dateSubscriptionFrequency;
    private final int companyEqualsFrequency;

    public SubscriptionGeneratorConfiguration(Properties properties) {
        this.subscriptionsToGenerate = Integer.parseInt(properties.getProperty("NO_OF_SUBSCRIPTIONS"));
        this.companySubscriptionFrequency = Integer.parseInt(properties.getProperty("COMPANY_SUBSCRIPTION_FREQUENCY"));
        this.valueSubscriptionFrequency = Integer.parseInt(properties.getProperty("VALUE_SUBSCRIPTION_FREQUENCY"));
        this.dropSubscriptionFrequency =  Integer.parseInt(properties.getProperty("DROP_SUBSCRIPTION_FREQUENCY"));
        this.variationSubscriptionFrequency = Integer.parseInt(properties.getProperty("VARIATION_SUBSCRIPTION_FREQUENCY"));
        this.dateSubscriptionFrequency = Integer.parseInt(properties.getProperty("DATE_SUBSCRIPTION_FREQUENCY"));
        this.companyEqualsFrequency = Integer.parseInt(properties.getProperty("COMPANY_EQUALS_FREQUENCY"));
    }

    public int getSubscriptionsToGenerate() {
        return subscriptionsToGenerate;
    }

    public int getCompanySubscriptionFrequency() {
        return companySubscriptionFrequency;
    }

    public int getValueSubscriptionFrequency() {
        return valueSubscriptionFrequency;
    }

    public int getDropSubscriptionFrequency() {
        return dropSubscriptionFrequency;
    }

    public int getVariationSubscriptionFrequency() {
        return variationSubscriptionFrequency;
    }

    public int getDateSubscriptionFrequency() {
        return dateSubscriptionFrequency;
    }

    public int getCompanyEqualsFrequency() {
        return companyEqualsFrequency;
    }
}
