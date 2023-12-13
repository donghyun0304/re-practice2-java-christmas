package christmas.domain.discount;

import christmas.domain.EventDate;

public class ChristmasDiscount extends Discount{

    private static final String TITLE = "크리스마스 디데이 할인";
    private static final int START_PRICE = 1000;
    private static final int START_DAY = 1;
    private static final int PRICE_PER_DAY = 100;


    private ChristmasDiscount(String title, int price) {
        super(title, price);
    }

    public static Discount create(EventDate eventDate){
        return new ChristmasDiscount(TITLE, calcPrice(eventDate));
    }

    private static int calcPrice(EventDate eventDate){
        int day = eventDate.getDay();
        return START_PRICE + (day - START_DAY) * PRICE_PER_DAY;
    }

}
