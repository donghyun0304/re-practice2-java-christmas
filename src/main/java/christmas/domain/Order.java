package christmas.domain;

import christmas.domain.condition.Conditions;
import christmas.domain.discount.Discounts;

public class Order {

    private final Foods orderedFoods;
    private final Discounts discounts;

    private final Conditions conditions;

    private Order(final Foods orderedFoods, final Discounts discounts, final Conditions conditions) {
        this.orderedFoods = orderedFoods;
        this.discounts = discounts;
        this.conditions = conditions;
    }

    public static Order of(final Foods orderedFoods, final Discounts discounts, final Conditions conditions){
        return new Order(orderedFoods, discounts, conditions);
    }

    public int calcTotalPriceBeforeDiscount(){
        return orderedFoods.calcTotalPrice();
    }


}
