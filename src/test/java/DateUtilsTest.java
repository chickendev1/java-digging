import org.junit.Assert;
import org.junit.Test;

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
    public  void getDateFormatTest() {

    }
}
