package subscriptions;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ComparisonOperator {
    EQUALS("="),
    NOT_EQUALS("!="),
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL_TO("<="),
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUAL_TO(">=");

    private final String text;

    ComparisonOperator(final String text) {
        this.text = text;
    }

    @JsonValue
    public String getText() {
        return text;
    }
}
