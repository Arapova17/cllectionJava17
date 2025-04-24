package task_lms.task_set;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        time();

    }

    public static void time (){
        // Реалдуу убакытты алуу
        LocalTime now = LocalTime.now();
        int hour = now.getHour();

        // Убакытты кадимки форматта көрсөтүү (мисалы: 09:23)
        String formattedTime = now.format(DateTimeFormatter.ofPattern("HH:mm"));

        // Саатка жараша саламдашуу
        String greeting;

        if (hour >= 5 && hour < 12) {
            greeting = "Кутман таң!";
        } else if (hour >= 12 && hour < 17) {
            greeting = "Кутан күн!";
        } else if (hour >= 17 && hour < 22) {
            greeting = "Кутман кеч!";
        } else {
            greeting = "Кутман түн!";
        }

        // Натыйжаны чыгаруу
        System.out.println("Саат -> " + formattedTime);
        System.out.println(greeting);

    }
}
