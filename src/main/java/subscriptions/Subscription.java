package subscriptions;

import java.util.Set;

public class Subscription {
    private final Set<SubscriptionCondition> conditions;

    public Subscription(Set<SubscriptionCondition> conditions) {
        this.conditions = conditions;
    }

    public Set<SubscriptionCondition> getConditions() {
        return conditions;
    }

    public void addCondition(SubscriptionCondition condition) {
        conditions.add(condition);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "conditions=" + conditions +
                '}';
    }
}
