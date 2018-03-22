import commonStuffs.EffectiveArrays;
import models.Payslip;
import models.SalaryItem;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh Mai on 3/22/2018.
 */
public class EffectiveArraysTest {
    @Test
    public void findNumberTest() {
        int[] randomNumbers = new int[]{10, 8, 6, 5, 2, 3, 2, 1, 3, 1};
        Assert.assertTrue(EffectiveArrays.findGivenElementInArray(randomNumbers,8));
        Assert.assertFalse(EffectiveArrays.findGivenElementInArray(randomNumbers,11));
    }

    @Test
    public void find2ndMinNumberTest() {
        int[] randomNumbers = new int[]{10, 8, 6, 5, 2, 3, 2, 1, 3, 1};
        Assert.assertEquals(2, EffectiveArrays.find2ndMinInArrays(randomNumbers));
    }

    @Test
    public void find3rdMinNumberTest() {
        int[] randomNumbers = new int[]{10, 8, 6, 5, 2, 3, 2, 1, 3, 1};
        Assert.assertEquals(3, EffectiveArrays.find3rdMinInArrays(randomNumbers));
    }

    @Test
    public void calculateSum() {
        SalaryItem item1 = new SalaryItem("MONTHLY_SALARY" , new BigDecimal(1000));
        SalaryItem item2 = new SalaryItem("MONTHLY_SALARY2" , new BigDecimal(600));
        SalaryItem item3 = new SalaryItem("MONTHLY_SALARY3" , new BigDecimal(400));
        List<SalaryItem> salaryItems = new ArrayList<>();
        salaryItems.add(item1);
        salaryItems.add(item2);
        salaryItems.add(item3);
        Payslip payslip = new Payslip(null, null, salaryItems);

        Assert.assertEquals(new BigDecimal(2000), EffectiveArrays.findSumUsingStream(payslip));
    }
}
