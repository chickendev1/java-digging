package models;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Thanh Mai on 3/22/2018.
 */
public class Payslip {
    private LocalDate fromDate;
    private LocalDate toDate;
    private List<SalaryItem> salaryItems;

    public Payslip(LocalDate fromDate, LocalDate toDate, List<SalaryItem> salaryItems) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.salaryItems = salaryItems;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public List<SalaryItem> getSalaryItems() {
        return salaryItems;
    }

    public void setSalaryItems(List<SalaryItem> salaryItems) {
        this.salaryItems = salaryItems;
    }
}
