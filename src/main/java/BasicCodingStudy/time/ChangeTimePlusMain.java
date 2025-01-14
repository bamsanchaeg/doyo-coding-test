package BasicCodingStudy.time;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ChangeTimePlusMain {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 1, 1, 13, 30, 59);
        System.out.println("localDateTime = " + localDateTime);

        LocalDateTime plusLdt1 = localDateTime.plus(10, ChronoUnit.YEARS);
        System.out.println("plusLdt1 = " + plusLdt1);

        LocalDateTime localDateTime1 = localDateTime.plusYears(10);
        System.out.println("localDateTime1 = " + localDateTime1);

        Period period = Period.ofYears(10);
        System.out.println("period = " + period);
    }
}
