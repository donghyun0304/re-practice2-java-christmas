package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public enum EventCalendar {

    CHRISTMAS(date -> isBetweenChristMas(date)),
    WEEKDAYS(date -> {
        List<DayOfWeek> dayOfWeeks = List.of(DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY);
        return containsInDayOfWeek(date, dayOfWeeks);
    }),
    WEEKENDS(date -> {
        List<DayOfWeek> dayOfWeeks = List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
        return containsInDayOfWeek(date, dayOfWeeks);
    }),
    SPECIAL(date -> {
        List<Integer> days = List.of(3, 10, 17, 24, 25, 31);
        return days.stream()
                .anyMatch(day -> date.isSameDay(day));
    });

    private Predicate<EventDate> predicate;

    EventCalendar(Predicate<EventDate> predicate) {
        this.predicate = predicate;
    }

    private static final LocalDate START_CHRISTMAS = LocalDate.of(2023, 12, 1);
    private static final LocalDate END_CHRISTMAS = LocalDate.of(2023, 12, 25);

    private static boolean isBetweenChristMas(EventDate eventDate){
        return eventDate.isBetween(START_CHRISTMAS, END_CHRISTMAS);
    }

    private static boolean containsInDayOfWeek(EventDate eventDate, List<DayOfWeek> dayOfWeeks){
        return eventDate.contains(dayOfWeeks);
    }
}
