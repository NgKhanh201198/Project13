package com.employeemanager.entity;

import java.util.List;

public class Employee {
    private int id;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private String employeeType;
    private String employeeCount;
    public List<Certificate> certificates;

    public Employee() {
        super();
    }

    public Employee(int id, String fullName, String birthDay, String phone, String email, String employeeType, String employeeCount) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        this.employeeCount = employeeCount;
    }

    public void showInfo() {
        System.out.printf("|%-6s", id);
        System.out.printf("|%-20s", fullName);
        System.out.printf("|%-13s", birthDay);
        System.out.printf("|%-13s", phone);
        System.out.printf("|%-25s", email);
        System.out.printf("|%-15s|", employeeType);
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(String employeeCount) {
        this.employeeCount = employeeCount;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}
