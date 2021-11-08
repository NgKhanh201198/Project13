package com.employee_manager.entity;

import java.util.stream.Collectors;

public class Experience extends Employee {
    private int expInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(int expInYear, String proSkill) {
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience(int id, String fullName, String birthDay, String phone, String email, String employeeType, String employeeCount, int expInYear, String proSkill) {
        super(id, fullName, birthDay, phone, email, employeeType, employeeCount);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public void showMe() {
        super.showInfo();
        System.out.printf("%-10s", expInYear);
        System.out.printf("|%-20s", proSkill);
        String certificateInfo = super.getCertificates().stream().map(Certificate::getCertificateName).collect(Collectors.joining(", "));
        System.out.printf("|%-20s|", certificateInfo);
    }
}
