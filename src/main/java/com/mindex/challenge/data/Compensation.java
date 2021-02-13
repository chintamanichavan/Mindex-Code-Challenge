package com.mindex.challenge.data;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Compensation {
    private String employeeId;
    private int salary;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date effectiveDate;

    public Compensation() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
