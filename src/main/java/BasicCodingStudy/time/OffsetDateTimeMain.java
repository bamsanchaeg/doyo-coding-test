package BasicCodingStudy.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeMain {

    public static void main(String[] args) {
        OffsetDateTime nowOdt = OffsetDateTime.now();
        System.out.println("nowOdt = " + nowOdt);

        LocalDateTime idt = LocalDateTime.of(2030, 1, 1, 13, 30, 50);
        System.out.println("idt = " + idt);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(idt, ZoneOffset.of("+01:00"));
        System.out.println("offsetDateTime = " + offsetDateTime);
    }
}
