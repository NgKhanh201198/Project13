package com.employeemanager.entity;

import java.util.stream.Collectors;

public class Intern extends Employee {
    String majors;
    String semester;
    String universityName;

    public Intern() {
        super();
    }

    public Intern(String majors, String semester, String universityName) {
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public Intern(int id, String fullName, String birthDay, String phone, String email, String employeeType, String employeeCount, String majors, String semester, String universityName) {
        super(id, fullName, birthDay, phone, email, employeeType, employeeCount);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void showMe() {
        super.showInfo();
        System.out.printf("%-20s", majors);
        System.out.printf("|%-10s", semester);
        System.out.printf("|%-20s", universityName);
        String certificateInfo = super.getCertificates().stream().map(Certificate::getCertificateName).collect(Collectors.joining(", "));
        System.out.printf("|%-20s|", certificateInfo);
    }
}
