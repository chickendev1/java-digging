import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Thanh Mai on 3/20/2018.
 */
public class DateUtils {
    //format Date : dd MM yyyy
    public static String formatDate(String formatDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        //String one = date.format(formatter);
        //System.out.println("Format Date: "+one);
        return "OK";
    }

    public static LocalDateTime convertDToLDT(Date date){
        return null;
    }

    public static Date convertLDTToD(LocalDateTime localDate) {
        return null;
    }

    public static String localDateToOutputString(LocalDate localDate, DateTimeFormatter dateTimeFormatter) {
        if(localDate == null) {
            return null;
        } else {
            LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.of(0, 0, 0));
            ZonedDateTime dateTimeWithZone = localDateTime.atZone(ZoneId.of("+00:00"));
            return dateTimeFormatter == null?dateTimeWithZone.format(DateTimeFormatter.ISO_ZONED_DATE_TIME):dateTimeWithZone.format(dateTimeFormatter);
        }
    }

    public static LocalDate zonedStringToLocalDate(String str) {
        ZonedDateTime dateTimeWithZone = ZonedDateTime.parse(str);
        dateTimeWithZone = dateTimeWithZone.withZoneSameInstant(ZoneId.of("+00:00"));
        return LocalDate.from(dateTimeWithZone);
    }

    public static String localDateTimeToOutputString(LocalDateTime localDateTime) {
        return localDateTimeToOutputString(localDateTime, (DateTimeFormatter)null);
    }

    private static String localDateTimeToOutputString(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        if(localDateTime == null) {
            return null;
        } else {
            LocalDateTime localDateTimeWithoutNanoSecond = localDateTime.withNano(0);
            ZonedDateTime dateTimeWithZone = localDateTimeWithoutNanoSecond.atZone(ZoneId.of("+00:00"));
            return dateTimeFormatter == null?dateTimeWithZone.format(DateTimeFormatter.ISO_ZONED_DATE_TIME):dateTimeWithZone.format(dateTimeFormatter);
        }
    }

    public static LocalDateTime zonedStringToLocalDateTime(String str) {
        ZonedDateTime dateTimeWithZone = ZonedDateTime.parse(str);
        dateTimeWithZone = dateTimeWithZone.withZoneSameInstant(ZoneId.of("+00:00"));
        return LocalDateTime.from(dateTimeWithZone);
    }

}
