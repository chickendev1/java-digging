package models;

import java.math.BigDecimal;

/**
 * Created by Thanh Mai on 3/22/2018.
 */
public class SalaryItem {
    private String code;
    private BigDecimal salaryValue;

    public SalaryItem(String code, BigDecimal salaryValue) {
        this.code = code;
        this.salaryValue = salaryValue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getSalaryValue() {
        return salaryValue;
    }

    public void setSalaryValue(BigDecimal salaryValue) {
        this.salaryValue = salaryValue;
    }
}
