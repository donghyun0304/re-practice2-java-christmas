package christmas.domain;

import christmas.utils.ErrorMessage;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class EventDate {

    private static final int YEAR = 2023;
    private static final int MONTH = 12;

    private final LocalDate date;

    private EventDate(final LocalDate date) {
        this.date = date;
    }

    public static EventDate from(final int day){
        try {
            LocalDate.of(YEAR, MONTH, day);
        } catch (DateTimeException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_DATE, e);
        }
        return new EventDate(LocalDate.of(YEAR, MONTH, day));
    }

    public boolean isBetween(final LocalDate startDate, final LocalDate endDate){
        return (this.date.isAfter(startDate) || this.date.isEqual(startDate)) &&
                (this.date.isBefore(endDate) || this.date.isEqual(endDate));
    }

    public boolean contains(List<DayOfWeek> dayOfWeeks){
        return dayOfWeeks.contains(date);
    }

    public boolean isSameDay(int day){
        return date.getDayOfMonth() == day;
    }

}
