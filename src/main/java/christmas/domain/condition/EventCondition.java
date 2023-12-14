package christmas.domain.condition;

public class EventCondition implements Condition{

    private static final int MIN_PRICE = 10_000;
    @Override
    public boolean isValid(int price) {
        if (price >= MIN_PRICE) {
            return true;
        }
        return false;
    }
}
