package christmas.domain.condition;

public class PresentCondition implements Condition{

    private static final int MIN_PRICE = 120_000;

    @Override
    public boolean isValid(int price) {
        if(price >= MIN_PRICE){
            return true;
        }
        return false;
    }
}
