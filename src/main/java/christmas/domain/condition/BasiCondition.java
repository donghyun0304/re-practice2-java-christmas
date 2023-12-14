package christmas.domain.condition;

public class BasiCondition implements Condition{

    private static final int MIN_PRICE = 5_000;
    @Override
    public boolean isValid(int price) {
        if(price >= MIN_PRICE){
            return true;
        }
        return false;
    }
}
