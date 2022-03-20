package subscriptions;

import publications.PublicationField;

import java.util.HashSet;
import java.util.Set;

public class Subscription {
    private final Set<SubscriptionCondition> conditions;

    public Subscription() {
        this.conditions = new HashSet<>();
    }

    public Subscription(Set<SubscriptionCondition> conditions) {
        this.conditions = conditions;
    }

    public Set<SubscriptionCondition> getConditions() {
        return conditions;
    }

    public void addCondition(SubscriptionCondition condition) {
        conditions.add(condition);
    }

    public boolean containsConditionRelatedToField(PublicationField field) {
        for (SubscriptionCondition condition : conditions)
            if (condition.getFieldName() == field)
                return true;

        return false;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "conditions=" + conditions +
                '}';
    }
}
