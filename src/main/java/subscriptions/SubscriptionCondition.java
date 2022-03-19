package subscriptions;

import publications.PublicationField;

public class SubscriptionCondition {
    private final PublicationField fieldName;
    private final ComparisonOperator operator;
    private final Object value;

    public SubscriptionCondition(PublicationField fieldName, ComparisonOperator operator, Object value) {
        this.fieldName = fieldName;
        this.operator = operator;
        this.value = value;
    }

    public PublicationField getFieldName() {
        return fieldName;
    }

    public ComparisonOperator getOperator() {
        return operator;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SubscriptionCondition{" +
                "fieldName=" + fieldName +
                ", operator=" + operator +
                ", value=" + value +
                '}';
    }
}
