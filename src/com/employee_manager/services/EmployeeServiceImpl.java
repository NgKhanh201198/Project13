package com.employee_manager.services;

import com.employee_manager.entity.Certificate;
import com.employee_manager.entity.Employee;
import com.employee_manager.entity.Experience;
import com.employee_manager.exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    Scanner scanner = new Scanner(System.in);
    ValidationException validationException = new ValidationException();
    List<Employee> employeeList = new ArrayList<>();

    public List<Certificate> addExperience() {
        String number;
        while (true) {
            System.out.print("Enter number of certificate: ");
            number = scanner.nextLine();
            try {
                validationException.checkNumber(number);
                break;
            } catch (NumberException exception) {
                System.out.println(ANSI_RED + "Error: " + exception.getMessage() + ANSI_RESET);
            }
        }

        List<Certificate> list = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(number); i++) {
            System.out.printf("Certificate number %s:\n", i + 1);
            System.out.print("Enter certificate id: ");
            int certificateId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter certificate name: ");
            String certificateName = scanner.nextLine();
            System.out.print("Enter certificate rank: ");
            String certificateRank = scanner.nextLine();
            System.out.print("Enter certificate date: ");
            String certificateDate = scanner.nextLine();

            Certificate certificate = new Certificate(certificateId, certificateName, certificateRank, certificateDate);
            list.add(certificate);
        }

        return list;
    }

    @Override
    public void add() {
        String fullName;
        String birthDay;
        String phone;
        String email;
        int employeeType;

        System.out.println(ANSI_GREEN + "+------------------+" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "| Add new employee |" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "+------------------+" + ANSI_RESET);

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            System.out.print("Enter fullname: ");
            fullName = scanner.nextLine();
            try {
                validationException.checkName(fullName);
                break;
            } catch (NameException exception) {
                System.out.println(ANSI_RED + "Error: " + exception.getMessage() + ANSI_RESET);
            }
        }

        while (true) {
            System.out.print("Enter birthDay: ");
            birthDay = scanner.nextLine();
            try {
                validationException.checkBirthday(birthDay);
                break;
            } catch (BirthdayException exception) {
                System.out.println(ANSI_RED + "Error: " + exception.getMessage() + ANSI_RESET);
            }
        }

        while (true) {
            System.out.print("Enter phone: ");
            phone = scanner.nextLine();
            try {
                validationException.checkPhone(phone);
                break;
            } catch (PhoneException exception) {
                System.out.println(ANSI_RED + "Error: " + exception.getMessage() + ANSI_RESET);
            }
        }

        while (true) {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            try {
                validationException.checkEmail(email);
                break;
            } catch (EmailException exception) {
                System.out.println(ANSI_RED + "Error: " + exception.getMessage() + ANSI_RESET);
            }
        }

        while (true) {
            System.out.println("Select employee type:");
            System.out.println("0. Experience");
            System.out.println("1. Fresher");
            System.out.println("2. Intern");
            System.out.print("Enter employeeType: ");
            employeeType = scanner.nextInt();
            if (employeeType < 0 || employeeType > 2) {
                System.out.println(ANSI_RED + "Invalid selection. Please choose again!" + ANSI_RESET);
            } else {
                break;
            }
        }

        switch (employeeType) {
            case 0:
                Experience experience = new Experience();
                experience.setId(id);
                experience.setFullName(fullName);
                experience.setBirthDay(birthDay);
                experience.setPhone(phone);
                experience.setEmail(email);
                experience.setEmployeeType("Experience");
                System.out.print("Enter experience in year: ");
                int expInYear = scanner.nextInt();
                scanner.nextLine();
                experience.setExpInYear(expInYear);
                System.out.print("Enter pro skill: ");
                String proSkill = scanner.nextLine();
                experience.setProSkill(proSkill);

                experience.setCertificates(addExperience());

                employeeList.add(experience);
                break;
            case 1:
                System.out.println("Fresher");
                break;
            case 2:
                System.out.println("Intern");
                break;
            default:
                break;
        }
    }

    @Override
    public void update(int id) {


    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Employee findById(int id) {
        Employee oldEemployee = new Employee();

        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                oldEemployee = employee;
            }
        }
        return oldEemployee;
    }

    @Override
    public void findAll() {
        System.out.print(ANSI_BLUE);
        System.out.println("+------+--------------------+------------------+-------------+-------------------------+");
        System.out.println("|ID    |FullName            |BirthDay          |Phone        |Email                    |");
        System.out.println("+------+--------------------+------------------+-------------+-------------------------+");
        for (Employee employee : employeeList) {
            employee.showInfo();
            System.out.println("");
        }
        System.out.println("+------+--------------------+------------------+-------------+-------------------------+");
        System.out.println(ANSI_RESET);

    }

    @Override
    public void findByIntern() {

    }

    @Override
    public void findByFresher() {

    }

    @Override
    public void findByExperience() {
        System.out.print(ANSI_BLUE);
        System.out.println("+------+--------------------+------------------+-------------+-------------------------+----------+--------------------+--------------------+");
        System.out.println("|ID    |FullName            |BirthDay          |Phone        |Email                    |ExpInYear |ProSkill            |CertificateName     |");
        System.out.println("+------+--------------------+------------------+-------------+-------------------------+----------+--------------------+--------------------+");
        for (Employee employee : employeeList) {
            Experience experience = (Experience) employee;
            experience.showMe();
            System.out.println("");
        }
        System.out.println("+------+--------------------+------------------+-------------+-------------------------+----------+--------------------+--------------------+");
        System.out.println(ANSI_RESET);
    }
}
