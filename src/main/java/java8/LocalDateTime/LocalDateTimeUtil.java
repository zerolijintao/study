package java8.LocalDateTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LocalDateTimeUtil {
    public static Temporal nextWorkingDay(DayOfWeek dayOfWeek) {
        LocalDate date = LocalDate.of(2017, 11, 23);
        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
                temporal -> {
                    //读取当前天数
                    DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
                    //正常情况增加1天
                    int dayToAdd = 1;
                    //如果当天是周五,增加三天
                    if (dow == DayOfWeek.FRIDAY) {
                        dayToAdd = 3;
                    }
                    //如果当天是周六增加两天
                    if (dow == DayOfWeek.SATURDAY) {
                        dayToAdd = 2;
                    }
                    //增加恰当的天数后,返回修改的日期
                    return temporal.plus(dayToAdd, ChronoUnit.DAYS);
                });
        date = date.with(nextWorkingDay);
        return date;
    }


    public static void main(String[] args) {
        LocalDate startDay = LocalDate.of(2019, 4, 11);
        LocalDate endDay = LocalDate.of(2019, 5, 1);
        List<Integer> weeks = new ArrayList<>(Arrays.asList(3));

        List<LocalDate> weekLocalDateListByRange = getWeekLocalDateListByRange(startDay, endDay, weeks);
        weekLocalDateListByRange.forEach(t -> System.out.println(t.toString()));
    }

    public static List<LocalDate> getWeekLocalDateListByRange(LocalDate startDay, LocalDate endDay, List<Integer> weeks) {
        List<LocalDate> localDateList = new ArrayList<>();
        LocalDate tempDay;
        for (Integer week : weeks) {
            tempDay = startDay.with(ChronoField.DAY_OF_WEEK, week);
            if (tempDay.isBefore(startDay)) {
                tempDay = tempDay.plusWeeks(1);
            }
            while (tempDay.isBefore(endDay) || tempDay.isEqual(endDay)) {
                localDateList.add(tempDay);
                tempDay = tempDay.plusWeeks(1);
            }
        }
        return localDateList;
    }

    public static List<LocalDate> getBetweenDate(LocalDate startDate, LocalDate endDate, List<Integer> days) {
        List<LocalDate> list = new ArrayList<>();
        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        if (distance < 1) {
            return list;
        }
        Stream.iterate(startDate, d -> d.plusDays(1)).limit(distance + 1).forEach(f ->
        {
            if (days.contains(f.getDayOfWeek().getValue())) {
                list.add(f);
            }
        });
        return list;
    }
}
