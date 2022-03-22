package subscriptions;

import common.RandomFieldsUtils;
import common.RandomUtils;
import publications.PublicationField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SplittableRandom;

public class SubscriptionGenerator {

    private final SubscriptionGeneratorConfiguration configuration;

    public SubscriptionGenerator(SubscriptionGeneratorConfiguration configuration) {
        this.configuration = configuration;
    }

    public List<Subscription> generateSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();
        for (int i = 0; i < configuration.getSubscriptionsToGenerate(); i++)
            subscriptions.add(new Subscription());

        List<SubscriptionCondition> conditions = generateSubscriptionConditions();
        Collections.shuffle(conditions);

        int subscriptionIndex = 0;
        for (SubscriptionCondition condition : conditions) {
            Subscription currentSubscription = subscriptions.get(subscriptionIndex);

            while (currentSubscription.containsConditionRelatedToField(condition.getFieldName())) {
                subscriptionIndex = subscriptionIndex == subscriptions.size() - 1 ? 0 : subscriptionIndex + 1;
                currentSubscription = subscriptions.get(subscriptionIndex);
            }

            currentSubscription.addCondition(condition);
            subscriptionIndex = subscriptionIndex == subscriptions.size() - 1 ? 0 : subscriptionIndex + 1;
        }
        return subscriptions;
    }

    private List<SubscriptionCondition> generateSubscriptionConditions() {
        List<SubscriptionCondition> conditions = new ArrayList<>();
        for (int i = 0; i < configuration.getCompanySubscriptions(); i++) {
            Object value = RandomFieldsUtils.getRandomFieldValue(PublicationField.COMPANY);
            if (i < configuration.getCompanyEqualsSubscriptions())
                conditions.add(new SubscriptionCondition(PublicationField.COMPANY, ComparisonOperator.EQUALS, value));
            else
                conditions.add(new SubscriptionCondition(PublicationField.COMPANY, ComparisonOperator.NOT_EQUALS, value));
        }

        for (int i = 0; i < configuration.getValueSubscriptions(); i++)
            conditions.add(generateSubscriptionConditionForField(PublicationField.VALUE));

        for (int i = 0; i < configuration.getDropSubscriptions(); i++)
            conditions.add(generateSubscriptionConditionForField(PublicationField.DROP));

        for (int i = 0; i < configuration.getVariationSubscriptions(); i++)
            conditions.add(generateSubscriptionConditionForField(PublicationField.VARIATION));

        for (int i = 0; i < configuration.getDateSubscriptions(); i++)
            conditions.add(generateSubscriptionConditionForField(PublicationField.DATE));

        return conditions;
    }


    private SubscriptionCondition generateSubscriptionConditionForField(PublicationField field) {
        ComparisonOperator comparisonOperator = RandomUtils.getRandomComparisonOperator();
        Object value = RandomFieldsUtils.getRandomFieldValue(field);
        return new SubscriptionCondition(field, comparisonOperator, value);
    }
}
