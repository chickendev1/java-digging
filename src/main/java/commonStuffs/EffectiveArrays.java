package commonStuffs;

import models.Payslip;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Thanh Mai on 3/22/2018.
 */
public class EffectiveArrays {
    public static boolean findGivenElementInArray(int[] array, int element) {
        return Arrays.stream(array).filter(x -> element == x).findFirst().isPresent();
    }

    public static BigDecimal findSumUsingStream(Payslip payslip) {
        return payslip.getSalaryItems().stream().map(salaryItem -> salaryItem.getSalaryValue()).reduce((x, y) -> x.add(y)).get();
    }

    public static int find2ndMinInArrays (int[] randomNumbers) {
        int firstMinNumber = randomNumbers[0];
        int secondMinNumber = -1;

        for (int i = 2; i < randomNumbers.length; i++) {
            if (randomNumbers[i] < firstMinNumber) {
                secondMinNumber = firstMinNumber;
                firstMinNumber = randomNumbers[i];
            } else if (randomNumbers[i] < secondMinNumber && randomNumbers[i] > firstMinNumber) {
                secondMinNumber = randomNumbers[i];
            }
        }
        return secondMinNumber;
    }

    public static int find3rdMinInArrays (int[] randomNumbers) {
        int firstMinNumber = randomNumbers[0];
        int secondMinNumber = -1;
        int thirdMinNumber = -1;

        for (int i = 0; i < randomNumbers.length; i++) {
            if (randomNumbers[i] < firstMinNumber) {
                thirdMinNumber = secondMinNumber;
                secondMinNumber = firstMinNumber;
                firstMinNumber = randomNumbers[i];
            } else if (randomNumbers[i] < secondMinNumber && randomNumbers[i] > firstMinNumber) {
                thirdMinNumber = secondMinNumber;
                secondMinNumber = randomNumbers[i];
            }  else if (randomNumbers[i] < thirdMinNumber && randomNumbers[i] > secondMinNumber && randomNumbers[i] > firstMinNumber) {
                thirdMinNumber = secondMinNumber;
            }

        }
        return thirdMinNumber;
    }
}
