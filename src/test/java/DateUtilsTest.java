
import commonStuffs.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 * Created by Thanh Mai on 3/20/2018.
 */
public class DateUtilsTest {

    @Test
    public void formatDateTest() throws Exception {
        //Test date
        LocalDate date = LocalDate.of(2016, 12, 20);

        //DateTime formatter LocalizedDate provides some default format style
        //FULL: Tuesday, December 20, 2016
        //LONG: December 20, 2016
        //MEDIUM: Dec 20, 2016
        //SHORT: 12/20/16
        String s = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)); // Tuesday, December 20, 2016
        Assert.assertEquals("Tuesday, December 20, 2016", s);

        String result = DateUtils.formatDate(date, DateUtils.FORMAT_DATE_SLASH);
        s = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)); // 12/20/16
        Assert.assertEquals(s, result);

        //Using our format method
        result = DateUtils.formatDate(date, DateUtils.FORMAT_DATE);
        Assert.assertEquals("20-12-2016", result);
    }

    @Test
    public void formatDateTimeTest() throws Exception {
        //Test date
        LocalDateTime date = LocalDateTime.of(2016, 12, 20, 14, 30, 40);

        //DateTime formatter LocalizedDate provides some default format style
        //FULL: won't work
        //LONG: won't work
        //MEDIUM: Dec 20, 2016 2:30:40 PM
        //SHORT: 12/20/16 2:30 PM
        String s = date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)); // Dec 20, 2016 2:30:40 PM
        Assert.assertEquals("Dec 20, 2016 2:30:40 PM", s);

        String result = DateUtils.formatDate(date, "MM/dd/yy h:mm a");
        s = date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)); // 12/20/16 2:30 PM
        Assert.assertEquals(s, result);

        //Using our format method
        result = DateUtils.formatDate(date, DateUtils.FORMAT_DATE_TIME);
        Assert.assertEquals("20-12-2016 2:30 PM", result);
    }

    @Test
    public void convertDateToLocalDateTest() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse("11-12-2012");
        LocalDate localDate = DateUtils.convertDateToLocalDate(date);
        Assert.assertEquals("11-12-2012", DateUtils.formatDate(localDate, DateUtils.FORMAT_DATE));
    }

    @Test
    public void convertDateToLocalDateTimeTest() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse("11-12-2012");
        LocalDateTime localDateTime = DateUtils.convertDateToLocalDateTime(date);
        Assert.assertEquals("11-12-2012 12:00 AM", DateUtils.formatDate(localDateTime, DateUtils.FORMAT_DATE_TIME));
    }

    @Test
    public void convertLocalDateTimeToDate() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.of(2016, 12, 20, 14, 30, 40, 55);
        Date date = DateUtils.convertLocalDateTimeToDate(localDateTime);
        Assert.assertEquals("20-12-2016", DateUtils.formatDate(date, DateUtils.FORMAT_DATE));
    }

    @Test
    public void convertLocalDateToDate() throws Exception {
        LocalDate localDate = LocalDate.of(2016, 12, 20);
        Date date = DateUtils.convertLocalDateToDate(localDate);
        Assert.assertEquals("20-12-2016", DateUtils.formatDate(date, DateUtils.FORMAT_DATE));
    }

    @Test
    public void calculateDateTime() throws Exception {
        LocalDateTime fromDate = LocalDateTime.of(2016, 12, 20, 11, 11, 55);
        LocalDateTime toDate = LocalDateTime.of(2016, 12, 20, 11, 12);
        Assert.assertEquals("0 days 0 hours 0 minutes 5 seconds", DateUtils.calculateDuration(fromDate, toDate));

        LocalDateTime fromDate1 = LocalDateTime.of(2016, 12, 20, 11, 50);
        LocalDateTime toDate1 = LocalDateTime.of(2016, 12, 21, 11, 10);
        Assert.assertEquals("0 days 23 hours 20 minutes 0 seconds", DateUtils.calculateDuration(fromDate1, toDate1));

        LocalDateTime fromDate2 = LocalDateTime.of(2016, 12, 20, 11, 50);
        LocalDateTime toDate2 = LocalDateTime.of(2016, 12, 21, 11, 50);
        Assert.assertEquals("1 days 0 hours 0 minutes 0 seconds", DateUtils.calculateDuration(fromDate2, toDate2));
    }
}
