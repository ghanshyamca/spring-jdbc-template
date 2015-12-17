package org;

import java.sql.Date;

public class Employee {

    private Integer chkNo;
    private String name;
    private Date doj;
    private String gen;
    private boolean sept;
    private Integer psno;
    private Double salary;

    public Employee(Integer chkNo, String name, Date doj, String gen, boolean sept, Integer psno, Double salary) {
        this.chkNo = chkNo;
        this.name = name;
        this.doj = doj;
        this.gen = gen;
        this.sept = sept;
        this.psno = psno;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee[" + name + "]";
    }

    
}
