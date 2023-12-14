package christmas.domain.discount;

import christmas.domain.EventDate;

public class WeekdayDiscount extends Discount{

    private static final String TITLE = "평일 할인";
    private static final int PRICE = 2023;

    private WeekdayDiscount(String title, int price) {
        super(title, price);
    }

    public static Discount create(EventDate eventDate){
        return new WeekdayDiscount(TITLE, PRICE);
    }



}
