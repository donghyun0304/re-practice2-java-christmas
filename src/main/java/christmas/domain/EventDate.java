package christmas.domain;

import christmas.utils.ErrorMessage;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;

public class EventDate {

    private static final int YEAR = 2023;
    private static final int MONTH = 12;

    private final LocalDate date;

    private EventDate(final LocalDate date) {
        this.date = date;
    }

    public static EventDate from(int day){
        try {
            LocalDate.of(YEAR, MONTH, day);
        } catch (DateTimeException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_DATE, e);
        }
        return new EventDate(LocalDate.of(YEAR, MONTH, day));
    }

}
