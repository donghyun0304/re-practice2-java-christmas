package christmas.controller;

import christmas.domain.EventDate;
import christmas.domain.Foods;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {

    private final InputView inputView;
    private final OutputView outputView;

    public EventController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        outputView.printStart();
        EventDate eventDate = inputView.inputDate();
        Foods foods = inputView.inputMenu();
        
    }
}
