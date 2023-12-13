package christmas.domain.discount;

import christmas.domain.EventDate;

public class SpecialDiscount extends Discount{

    private static final String TITLE = "특별 할인";
    private static final int PRICE = 1000;

    private SpecialDiscount(String title, int price) {
        super(title, price);
    }

    public static Discount create(EventDate eventDate){
        return new SpecialDiscount(TITLE, PRICE);
    }

}
