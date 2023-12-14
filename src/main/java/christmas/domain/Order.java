package christmas.domain;

import christmas.domain.condition.Condition;
import christmas.domain.condition.Conditions;
import christmas.domain.condition.EventCondition;
import christmas.domain.condition.PresentCondition;
import christmas.domain.discount.*;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;

public class Order {

    private static final int ZERO = 0;

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

    public int calcChristmasDiscount(){
        Optional<Discount> discount = discounts.findDiscount(ChristmasDiscount.class);
        Optional<Condition> condition = conditions.findCondition(EventCondition.class);
        if(discount.isEmpty() || condition.isEmpty() || !condition.get().isValid(calcTotalPriceBeforeDiscount())){
            return ZERO;
        }
            return discount.get().getPrice();
    }

    public int calcWeekdayDiscount(){
        Optional<Discount> discount = discounts.findDiscount(WeekdayDiscount.class);
        Optional<Condition> condition = conditions.findCondition(EventCondition.class);
        if(discount.isEmpty() || condition.isEmpty() || !condition.get().isValid(calcTotalPriceBeforeDiscount())){
            return ZERO;
        }
        return orderedFoods.getAmountOfFoodInCategory(Menu.DESSERT) * discount.get().getPrice();
    }

    public int calcWeekendDiscount(){
        Optional<Discount> discount = discounts.findDiscount(WeekendDiscount.class);
        Optional<Condition> condition = conditions.findCondition(EventCondition.class);
        if(discount.isEmpty() || condition.isEmpty() || !condition.get().isValid(calcTotalPriceBeforeDiscount())){
            return ZERO;
        }
        return orderedFoods.getAmountOfFoodInCategory(Menu.MAIN) * discount.get().getPrice();
    }

    public int calcSpecialDiscount(){
        Optional<Discount> discount = discounts.findDiscount(SpecialDiscount.class);
        Optional<Condition> condition = conditions.findCondition(EventCondition.class);
        if(discount.isEmpty() || condition.isEmpty() || !condition.get().isValid(calcTotalPriceBeforeDiscount())){
            return ZERO;
        }
        return discount.get().getPrice();
    }

    public Optional<Present> getPresent(){
        Optional<Condition> condition = conditions.findCondition(PresentCondition.class);
        if(condition.isEmpty() || !condition.get().isValid(calcTotalPriceBeforeDiscount())){
            return Optional.empty();
        }
        return Optional.of(new Present());
    }

    public int calcPresentPrice(){
        if(getPresent().isEmpty()){
            return ZERO;
        }
        return getPresent().get().getPrice();
    }

    public int calcTotalDiscountPrice(){
        return calcChristmasDiscount() + calcWeekdayDiscount() + calcWeekendDiscount() + calcSpecialDiscount();
    }

    public int calcTotalBenefitPrice(){
        return calcTotalDiscountPrice() + calcPresentPrice();
    }

    public int calcTotalPriceAfterDiscount(){
        return calcTotalPriceBeforeDiscount() - calcTotalDiscountPrice();
    }

    public Optional<Basi> getBasi(){
        return Basi.find(calcTotalBenefitPrice());
    }

    public Map<Food, Integer> getOrderedFoods(){
        return orderedFoods.getFoods();
    }

}
