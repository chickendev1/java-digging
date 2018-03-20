import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Thanh Mai on 3/20/2018.
 */
public class DateUtils {
    public static final String FORMAT_DATE = "dd-MM-yyyy";
    public static final String FORMAT_DATE_SLASH = "MM/dd/yy";
    public static final String FORMAT_TIME = "h:mm a";
    public static final String FORMAT_TIME_SEC = "h:mm:ss a";
    public static final String FORMAT_DATE_TIME = "dd-MM-yyyy h:mm a";
    public static final String FORMAT_DATE_TIME_SEC = "dd-MM-yyyy h:mm:ss a";

    public static String formatDate(Object date, String formatDate) throws Exception {
        return formatDateTime(date, formatDate);
    }

    private static String formatDateTime(Object date, String formatDate) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatDate);
        if (date instanceof LocalDate) {
            return ((LocalDate)date).format(formatter);
        } else if (date instanceof LocalDateTime) {
            return ((LocalDateTime)date).format(formatter);
        }
        throw new Exception("Date must be instance of LocalDate or LocalDateTime");
    }

    public static LocalDateTime convertDToLDT(Date date){
        return null;
    }

    public static Date convertLDTToD(LocalDateTime localDate) {
        return null;
    }

    public static String getDateFormat(Date date) {
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.SHORT, Locale.UK);
        return dateInstance.format(date);
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
