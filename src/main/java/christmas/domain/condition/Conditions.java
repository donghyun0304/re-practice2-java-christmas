package christmas.domain.condition;

import java.util.List;
import java.util.Optional;

public class Conditions {

    private final List<Condition> conditions;

    public Conditions(final List<Condition> conditions) {
        this.conditions = conditions;
    }

    public Optional<Condition> findCondition(Class<? extends Condition> conditionClass){
        return conditions.stream()
                .filter(conditionClass::isInstance)
                .findAny();
    }
}
