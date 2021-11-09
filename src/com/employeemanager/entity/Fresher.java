package com.employeemanager.entity;

import java.util.stream.Collectors;

public class Fresher extends Employee {
    private String education;
    private String graduationRank;
    private String graduationDate;

    public Fresher() {
        super();
    }

    public Fresher(String graduationDate, String graduationRank, String education) {
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Fresher(int id, String fullName, String birthDay, String phone, String email, String employeeType, String employeeCount, String graduationDate, String graduationRank, String education) {
        super(id, fullName, birthDay, phone, email, employeeType, employeeCount);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void showMe() {
        super.showInfo();
        System.out.printf("%-20s", education);
        System.out.printf("|%-18s", graduationRank);
        System.out.printf("|%-18s", graduationDate);
        String certificateInfo = super.getCertificates().stream().map(Certificate::getCertificateName).collect(Collectors.joining(", "));
        System.out.printf("|%-20s|", certificateInfo);
    }
}
