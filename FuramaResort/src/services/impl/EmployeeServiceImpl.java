package services.impl;

import models.Employee;
import services.EmployeeService;
import utils.ReadAndWriteCSVFile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {

    private static final String EMPLOYEE_PATH_FILE = "src/data/Employee.csv";


    ReadAndWriteCSVFile readAndWriteCSVFile = new ReadAndWriteCSVFile();

    Scanner scanner = new Scanner(System.in);

    @Override
    public void edit() {
        List<Employee> employeeArrayList = new ArrayList<>();

        employeeArrayList = ReadAndWriteCSVFile.readEmployeeToCSV(EMPLOYEE_PATH_FILE);

        String level = null;
        int count = 0;

        String position = null;
        int count1 = 0;

        System.out.println("Enter employee code to edit: ");
        int employeeCodeEdit = Integer.parseInt(scanner.nextLine());
        if (employeeArrayList.isEmpty()) {
            System.out.println("No employee to edit!");
        } else {
            boolean flag;
            boolean check = false;

            for (int i = 0; i < employeeArrayList.size(); i++) {
                if (employeeCodeEdit == employeeArrayList.get(i).getEmployeeCode()) {
                    check = true;
                    do {
                        flag = true;

                        System.out.println("You want to edit:\n" +
                                "1. Name\n" +
                                "2. Date of birth\n" +
                                "3. Gender\n" +
                                "4. CMND\n" +
                                "5. Phone\n" +
                                "6. Email\n" +
                                "7. Level\n" +
                                "8. Position\n" +
                                "9. Salary\n" +
                                "10. Exit\n");

                        System.out.print("Enter your choose: ");
                        int choose = Integer.parseInt(scanner.nextLine());

                        switch (choose) {
                            case 1:
                                System.out.println("Enter new name: ");
                                String name = scanner.nextLine();
                                employeeArrayList.get(i).setName(name);
                                break;

                            case 2:
                                System.out.println("Enter new date of birth: ");
                                String dateOfBirth = scanner.nextLine();
                                employeeArrayList.get(i).setDateOfBirth(dateOfBirth);
                                break;

                            case 3:
                                System.out.println("Enter new gender: ");
                                String gender = scanner.nextLine();
                                employeeArrayList.get(i).setGender(gender);
                                break;

                            case 4:
                                System.out.println("Enter new CMND: ");
                                String numberCMND = scanner.nextLine();
                                employeeArrayList.get(i).setNumberCMND(numberCMND);
                                break;

                            case 5:
                                System.out.println("Enter new phone: ");
                                String phone = scanner.nextLine();
                                employeeArrayList.get(i).setPhone(phone);
                                break;

                            case 6:
                                System.out.println("Enter new email: ");
                                String email = scanner.nextLine();
                                employeeArrayList.get(i).setEmail(email);
                                break;

                            case 7:
                                System.out.println("------Employee level------");
                                for (Employee.Level employeeLevel : Employee.Level.values()) {
                                    System.out.println(++count + ". " + employeeLevel);
                                }
                                System.out.println("Choose new employee level: ");
                                int choose1 = Integer.parseInt(scanner.nextLine());
                                switch (choose1) {
                                    case 1:
                                        level = Employee.Level.INTERMEDIATE.getValue();
                                        break;
                                    case 2:
                                        level = Employee.Level.COLLEGE.getValue();
                                        break;
                                    case 3:
                                        level = Employee.Level.UNIVERSITY.getValue();
                                        break;
                                    case 4:
                                        level = Employee.Level.AFTERUNIVERSITY.getValue();
                                        break;
                                    default:
                                        break;
                                }
                                employeeArrayList.get(i).setLevel(level);
                                break;

                            case 8:
                                System.out.println("------Employee position------");
                                for (Employee.Position employeePosition : Employee.Position.values()) {
                                    System.out.println(++count1 + ". " + employeePosition);
                                }
                                System.out.println("Choose employee position: ");
                                int choose2 = Integer.parseInt(scanner.nextLine());
                                switch (choose2) {
                                    case 1:
                                        position = Employee.Position.RECEPTIONIST.getValue();
                                        break;

                                    case 2:
                                        position = Employee.Position.SERVANTS.getValue();
                                        break;

                                    case 3:
                                        position = Employee.Position.SPECIALIST.getValue();
                                        break;

                                    case 4:
                                        position = Employee.Position.SUPERVISOR.getValue();
                                        break;

                                    case 5:
                                        position = Employee.Position.MANAGER.getValue();
                                        break;

                                    case 6:
                                        position = Employee.Position.DIRECTOR.getValue();
                                        break;

                                    default:
                                        break;
                                }

                                employeeArrayList.get(i).setPosition(position);
                                break;

                            case 9:
                                System.out.println("Enter new salary: ");
                                int salary = Integer.parseInt(scanner.nextLine());
                                employeeArrayList.get(i).setSalary(salary);
                                break;

                            case 10:
                                flag = false;
                                break;

                            default:
                                System.out.println("Invalid, re-enter");
                        }
                    } while (flag);
                    break;
                }
            }
            if (!check) {
                System.out.println("Can't find employee to edit");
            }
        }
        ReadAndWriteCSVFile.writePersonToCSV(employeeArrayList, EMPLOYEE_PATH_FILE, true);
    }

    @Override
    public void add() {
//        List<Employee> employeeArrayList = new ArrayList<>();

        int count = 0;
        int count1 = 0;
        String level = null;
        String position = null;

        List<Employee> employeeList2 = ReadAndWriteCSVFile.readEmployeeToCSV(EMPLOYEE_PATH_FILE);

//        System.out.println("Enter employee code: ");
        int employeeCode = 1;
        if (!employeeList2.isEmpty()) {
            employeeCode = employeeList2.size()+1;
        }
//        int employeeCode = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter employee name: ");
        String employeeName = scanner.nextLine();

        System.out.println("Enter employee date of birth: ");
        String dateOfBirth = scanner.nextLine();

        System.out.println("Enter employee gender: ");
        String gender = scanner.nextLine();

        System.out.println("Enter employee CMND: ");
        String numberCMND = scanner.nextLine();

        System.out.println("Enter employee phone number: ");
        String phone = scanner.nextLine();

        System.out.println("Enter employee email: ");
        String email = scanner.nextLine();

        System.out.println("------Employee level------");
        for (Employee.Level employeeLevel : Employee.Level.values()) {
            System.out.println(++count + ". " + employeeLevel);
        }
        System.out.println("Choose employee level: ");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                level = Employee.Level.INTERMEDIATE.getValue();
                break;
            case 2:
                level = Employee.Level.COLLEGE.getValue();
                break;
            case 3:
                level = Employee.Level.UNIVERSITY.getValue();
                break;
            case 4:
                level = Employee.Level.AFTERUNIVERSITY.getValue();
                break;
            default:
                break;
        }

        System.out.println("------Employee position------");
        for (Employee.Position employeePosition : Employee.Position.values()) {
            System.out.println(++count1 + ". " + employeePosition);
        }
        System.out.println("Choose employee position: ");
        int choose1 = Integer.parseInt(scanner.nextLine());
        switch (choose1) {
            case 1:
                position = Employee.Position.RECEPTIONIST.getValue();
                break;
            case 2:
                position = Employee.Position.SERVANTS.getValue();
                break;
            case 3:
                position = Employee.Position.SPECIALIST.getValue();
                break;
            case 4:
                position = Employee.Position.SUPERVISOR.getValue();
                break;
            case 5:
                position = Employee.Position.MANAGER.getValue();
                break;
            case 6:
                position = Employee.Position.DIRECTOR.getValue();
                break;
            default:
                break;
        }

        System.out.println("Enter employee salary: ");
        int salary = Integer.parseInt(scanner.nextLine());

        Employee employee = new Employee(employeeCode, employeeName, dateOfBirth, gender, numberCMND,
                phone, email, level, position, salary);
        employeeList2.add(employee);

        ReadAndWriteCSVFile.writePersonToCSV(employeeList2, EMPLOYEE_PATH_FILE, false);
    }

    @Override
    public void display() {
        List<Employee> employeeArrayList = new ArrayList<>();

        employeeArrayList = ReadAndWriteCSVFile.readEmployeeToCSV(EMPLOYEE_PATH_FILE);

        for (Employee employee : employeeArrayList) {
            System.out.println(employee);
        }
    }
}
