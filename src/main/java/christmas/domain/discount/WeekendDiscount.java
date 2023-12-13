package christmas.domain.discount;

import christmas.domain.EventDate;

public class WeekendDiscount extends Discount{

    private static final String TITLE = "주말 할인";
    private static final int PRICE = 2023;

    private WeekendDiscount(String title, int price) {
        super(title, price);
    }

    public static Discount create(EventDate eventDate){
        return new WeekendDiscount(TITLE, PRICE);
    }

}
