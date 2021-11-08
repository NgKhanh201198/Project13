package com.employee_manager.controller;

import com.employee_manager.exception.ValidationException;
import com.employee_manager.services.EmployeeServiceImpl;
import com.employee_manager.services.IEmployeeService;

import java.util.Scanner;

public class EmloyeeController {
    IEmployeeService employeeService = new EmployeeServiceImpl();

    // 1. Add New Employee
    public void addEmloyee() {
        employeeService.add();
    }

    // 4. List of employee
    public void findAll() {
        employeeService.findAll();
    }

    // 6. Find all Experience
    public void findByExperience() {
        employeeService.findByExperience();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int selection;
        while (true) {
            do {
                System.out.println("-----Employee Manager-----");
                System.out.println("1. Add New Employee");
                System.out.println("2. Update Employee");
                System.out.println("3. Delete Employee By ID");
                System.out.println("4. List of employee");
                System.out.println("5. Find all Fresher");
                System.out.println("6. Find all Experience");
                System.out.println("7. Find all Intern");
                System.out.println("8. Exit");
                System.out.print("Please enter your selection: ");
                selection = scanner.nextInt();
            } while (selection < 1 || selection > 8);

            switch (selection) {
                case 1:
                    this.addEmloyee();
                    System.out.print("Enter any key to return to the menu:");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("2. Update Employee");
                    System.out.print("Enter any key to return to the menu:");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("3. Delete Employee By ID");
                    System.out.print("Enter any key to return to the menu:");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("List of employee:");
                    this.findAll();

                    System.out.print("Enter any key to return to the menu:");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("5. Find all Experience");
                    System.out.print("Enter any key to return to the menu:");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 6:
                    this.findByExperience();
                    System.out.print("Enter any key to return to the menu:");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.println("6-. Find all Intern");
                    System.out.print("Enter any key to return to the menu:");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 8:
                    System.out.print("End program...");
                    System.exit(0);
                    break;
                default:
                    break;
            }

        }
    }
}
