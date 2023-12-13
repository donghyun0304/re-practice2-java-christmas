package christmas.controller;

import christmas.domain.EventDate;
import christmas.domain.Foods;
import christmas.domain.discount.Discounts;
import christmas.service.EventService;
import christmas.view.InputView;
import christmas.view.OutputView;

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
    }
}
