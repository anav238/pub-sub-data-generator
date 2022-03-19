package subscriptions;

import common.RandomFieldsUtils;
import common.RandomUtils;
import publications.PublicationField;

import java.util.*;

public class SubscriptionGenerator {

    private final SubscriptionGeneratorConfiguration configuration;
    private final SplittableRandom random = new SplittableRandom();

    public SubscriptionGenerator(SubscriptionGeneratorConfiguration configuration) {
        this.configuration = configuration;
    }

    public List<Subscription> generateSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();
        for (int i = 0; i < configuration.getSubscriptionsToGenerate(); i++)
            subscriptions.add(generateSubscription());
        return subscriptions;
    }

    private Subscription generateSubscription() {
        Set<SubscriptionCondition> conditions = new HashSet<>();

        boolean includeCompany = includeField(configuration.getCompanySubscriptionFrequency());
        if (includeCompany) {
            ComparisonOperator comparisonOperator = includeField(configuration.getCompanyEqualsFrequency()) ? ComparisonOperator.EQUALS : ComparisonOperator.NOT_EQUALS;
            Object value = RandomFieldsUtils.getRandomFieldValue(PublicationField.COMPANY);
            conditions.add(new SubscriptionCondition(PublicationField.COMPANY, comparisonOperator, value));
        }

        boolean includeValue = includeField(configuration.getValueSubscriptionFrequency());
        if (includeValue)
            conditions.add(generateSubscriptionConditionForField(PublicationField.VALUE));

        boolean includeDrop = includeField(configuration.getDropSubscriptionFrequency());
        if (includeDrop)
            conditions.add(generateSubscriptionConditionForField(PublicationField.DROP));

        boolean includeVariation = includeField(configuration.getVariationSubscriptionFrequency());
        if (includeVariation)
            conditions.add(generateSubscriptionConditionForField(PublicationField.VARIATION));

        boolean includeDate = includeField(configuration.getDateSubscriptionFrequency());
        if (includeDate)
            conditions.add(generateSubscriptionConditionForField(PublicationField.DATE));

        return new Subscription(conditions);
    }

    private SubscriptionCondition generateSubscriptionConditionForField(PublicationField field) {
        ComparisonOperator comparisonOperator = RandomUtils.getRandomComparisonOperator();
        Object value = RandomFieldsUtils.getRandomFieldValue(field);
        return new SubscriptionCondition(field, comparisonOperator, value);
    }

    private boolean includeField(int probability) {
        return random.nextInt(1, 101) <= probability;
    }
}
