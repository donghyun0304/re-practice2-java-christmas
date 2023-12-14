package christmas.controller;

import christmas.domain.EventDate;
import christmas.domain.Foods;
import christmas.domain.Order;
import christmas.domain.Present;
import christmas.domain.condition.*;
import christmas.domain.discount.Discounts;
import christmas.service.EventService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventController {

    private final InputView inputView;
    private final OutputView outputView;
    private final EventService eventService;

    public EventController(InputView inputView, OutputView outputView, EventService eventService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.eventService = eventService;
    }

    public void run(){
        outputView.printStart();
        EventDate eventDate = inputView.inputDate();
        Foods foods = inputView.inputMenu();
        Discounts discounts = eventService.findDiscounts(eventDate);
        System.out.println("discounts = " + discounts);

        List<Condition> conditionGroup
                = new ArrayList<>(List.of(new EventCondition(), new BasiCondition(), new PresentCondition()));
        Conditions conditions = new Conditions(conditionGroup);

        Order order = Order.of(foods, discounts, conditions);
        int totalPriceBeforeDiscount = order.calcTotalPriceBeforeDiscount();
        int christmasDiscount = order.calcChristmasDiscount();
        System.out.println("christmasDiscount = " + christmasDiscount);
        int weekdayDiscount = order.calcWeekdayDiscount();
        System.out.println("weekdayDiscount = " + weekdayDiscount);
        int weekendDiscount = order.calcWeekendDiscount();
        System.out.println("weekendDiscount = " + weekendDiscount);
        int specialDiscount = order.calcSpecialDiscount();
        System.out.println("specialDiscount = " + specialDiscount);

        int discountPrice = order.calcTotalDiscountPrice();
        System.out.println("discountPrice = " + discountPrice);
        int totalBenefitPrice = order.calcTotalBenefitPrice();
        System.out.println("totalBenefitPrice = " + totalBenefitPrice);

        int totalPriceAfterDiscount = order.calcTotalPriceAfterDiscount();
        System.out.println("totalPriceAfterDiscount = " + totalPriceAfterDiscount);
    }
}