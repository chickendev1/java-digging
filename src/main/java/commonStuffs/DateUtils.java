package commonStuffs;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
            return ((LocalDate) date).format(formatter);
        } else if (date instanceof LocalDateTime) {
            return ((LocalDateTime) date).format(formatter);
        } else if (date instanceof Date) {
            return new SimpleDateFormat(formatDate).format((Date) date);
        }
        throw new Exception("Date must be instance of LocalDate or LocalDateTime");
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //Convert Date -> ZonedDateTime
        ZonedDateTime zonedDateTime = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault());
        //ZonedDateTime -> LocalDate
        return zonedDateTime.toLocalDate();
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //Convert Date -> Instant
        Instant instant = date.toInstant();
        //Instant + system default time zone + toLocalDateTime() = LocalDateTime
        return instant.atZone(defaultZoneId).toLocalDateTime();
    }

    public static Date convertLocalDateToDate(LocalDate localDate) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //Convert LocalDateTime -> Instant
        Instant instant = localDate.atStartOfDay(defaultZoneId).toInstant();
        return Date.from(instant);
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        ZoneOffset defaultZoneOffset = OffsetDateTime.now().getOffset();
        Instant instant = localDateTime.toInstant(defaultZoneOffset);
        return Date.from(instant);
    }

    public static String calculateDuration(LocalDateTime date1, LocalDateTime date2) {
        Duration duration = Duration.between(date1, date2);
        // total seconds of difference (using Math.abs to avoid negative values)
        long seconds = Math.abs(duration.getSeconds());
        long days = seconds / (24 * 60 * 60); // 24h * 60m * 60s
        seconds -= (days * 24 * 60 * 60);
        long hours = seconds / (60 * 60); // 60m * 60s
        seconds -= (hours * 3600);
        long minutes = seconds / 60;
        seconds -= (minutes * 60);

        return days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds";
    }
}
