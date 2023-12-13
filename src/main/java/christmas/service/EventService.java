package christmas.service;

import christmas.domain.discount.ChristmasDiscount;
import christmas.domain.discount.Discount;
import christmas.domain.discount.Discounts;
import christmas.domain.EventDate;
import christmas.domain.discount.WeekdayDiscount;

import java.util.ArrayList;
import java.util.List;

import static christmas.domain.EventCalendar.*;

public class EventService {

    public Discounts findDiscounts(EventDate eventDate){
        List<Discount> discounts = new ArrayList<>();
        if(isDateInEventDays(CHRISTMAS, eventDate)){
            discounts.add(ChristmasDiscount.create(eventDate));
        }
        if(isDateInEventDays(WEEKDAYS, eventDate)){
            discounts.add(WeekdayDiscount.create(eventDate));
        }
        if(isDateInEventDays(WEEKENDS, eventDate)){

        }
        return new Discounts(discounts);
    }

}
