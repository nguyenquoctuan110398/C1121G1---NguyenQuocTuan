package services.impl;

import models.Customer;
import services.CustomerService;
import utils.ReadAndWriteCSVFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {

    ReadAndWriteCSVFile readAndWriteCSVFile = new ReadAndWriteCSVFile();

    public static String CUSTOMER_PATH_FILE = "src/data/Customer.csv";

    Scanner scanner = new Scanner(System.in);



    @Override
    public void edit() {
        List<Customer> customerLinkedList = new LinkedList<>();

        customerLinkedList = ReadAndWriteCSVFile.readCustomerToCSV(CUSTOMER_PATH_FILE);

        System.out.println("Enter employee code to edit: ");
        int customerCodeEdit = Integer.parseInt(scanner.nextLine());
        if (customerLinkedList.isEmpty()) {
            System.out.println("No customer to edit!");
        } else {
            boolean flag;
            boolean check = false;


            for (int i = 0; i < customerLinkedList.size(); i++) {
                if (customerCodeEdit == customerLinkedList.get(i).getCustomerCode()) {
                    check = true;
                    do {
                        flag = true;

                        String typeGuest = null;
                        int count = 0;

                        System.out.println("You want to edit: \n" +
                                "1. Name\n" +
                                "2. Date of birth\n" +
                                "3. Gender\n" +
                                "4. CMND\n" +
                                "5. Phone\n" +
                                "6. Email\n" +
                                "7. TypeGuest\n" +
                                "8. Address\n" +
                                "9. Exit\n");

                        System.out.print("Enter your choose: ");
                        int choose = Integer.parseInt(scanner.nextLine());

                        switch (choose) {
                            case 1:
                                System.out.println("Enter new name: ");
                                String name = scanner.nextLine();
                                customerLinkedList.get(i).setName(name);
                                break;

                            case 2:
                                System.out.println("Enter new date of birth: ");
                                String dateOfBirth = scanner.nextLine();
                                customerLinkedList.get(i).setDateOfBirth(dateOfBirth);
                                break;

                            case 3:
                                System.out.println("Enter new gender: ");
                                String gender = scanner.nextLine();
                                customerLinkedList.get(i).setGender(gender);
                                break;

                            case 4:
                                System.out.println("Enter new CMND: ");
                                String numberCMND = scanner.nextLine();
                                customerLinkedList.get(i).setNumberCMND(numberCMND);
                                break;

                            case 5:
                                System.out.println("Enter new phone: ");
                                String phone = scanner.nextLine();
                                customerLinkedList.get(i).setPhone(phone);
                                break;

                            case 6:
                                System.out.println("Enter new email: ");
                                String email = scanner.nextLine();
                                customerLinkedList.get(i).setEmail(email);
                                break;

                            case 7:
                                System.out.println("------TypeGuest------");

                                for (Customer.TypeGuest typeGuest1 : Customer.TypeGuest.values()) {
                                    System.out.println(++count + ". " + typeGuest1);
                                }

                                System.out.println("Choose type guest: ");
                                int choose1 = Integer.parseInt(scanner.nextLine());

                                switch (choose) {
                                    case 1:
                                        typeGuest = Customer.TypeGuest.DIAMOND.getValue();
                                        break;
                                    case 2:
                                        typeGuest = Customer.TypeGuest.PLATINIUM.getValue();
                                        break;
                                    case 3:
                                        typeGuest = Customer.TypeGuest.GOLD.getValue();
                                        break;
                                    case 4:
                                        typeGuest = Customer.TypeGuest.SILVER.getValue();
                                        break;
                                    case 5:
                                        typeGuest = Customer.TypeGuest.MEMBER.getValue();
                                        break;
                                    default:
                                        break;
                                }
                                customerLinkedList.get(i).setTypeGuest(typeGuest);
                                break;

                            case 8:
                                System.out.println("Enter new address: ");
                                String address = scanner.nextLine();
                                customerLinkedList.get(i).setEmail(address);
                                break;

                            case 9:
                                flag = false;
                                break;

                            default:
                                System.out.println("Invalid, re-enter");
                                break;

                        }
                    } while (flag);
                    break;
                }
            }
        }
        ReadAndWriteCSVFile.writePersonToCSV(customerLinkedList, CUSTOMER_PATH_FILE, true);
    }

    @Override
    public void add() {
        List<Customer> customerLinkedList = ReadAndWriteCSVFile.readCustomerToCSV(CUSTOMER_PATH_FILE);

        int customerCode =1;
        if (!customerLinkedList.isEmpty()){
            customerCode = customerLinkedList.size();
        }

        int count = 0;
        String typeGuest = null;

//        System.out.println("Enter customer code: ");
//        int customerCode = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.println("Enter customer date of birth: ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Enter customer gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter customer CMND: ");
        String numberCMND = scanner.nextLine();
        System.out.println("Enter customer phone: ");
        String phone = scanner.nextLine();
        System.out.println("Enter customer email: ");
        String email = scanner.nextLine();

        System.out.println("------TypeGuest------");

        for (Customer.TypeGuest typeGuest1 : Customer.TypeGuest.values()) {
            System.out.println(++count + ". " + typeGuest1);
        }

        System.out.println("Choose type guest: ");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                typeGuest = Customer.TypeGuest.DIAMOND.getValue();
                break;
            case 2:
                typeGuest = Customer.TypeGuest.PLATINIUM.getValue();
                break;
            case 3:
                typeGuest = Customer.TypeGuest.GOLD.getValue();
                break;
            case 4:
                typeGuest = Customer.TypeGuest.SILVER.getValue();
                break;
            case 5:
                typeGuest = Customer.TypeGuest.MEMBER.getValue();
                break;
            default:
                break;
        }

        System.out.println("Enter customer address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(customerCode, name, dateOfBirth, gender, numberCMND,
                phone, email, typeGuest, address);
//        customerLinkedList.add(customer);
        customerLinkedList.add(customer);

        ReadAndWriteCSVFile.writePersonToCSV(customerLinkedList, CUSTOMER_PATH_FILE, false);

    }

    @Override
    public void display() {
        List<Customer> customerLinkedList = new LinkedList<>();

        customerLinkedList = ReadAndWriteCSVFile.readCustomerToCSV(CUSTOMER_PATH_FILE);

        for (Customer customer : customerLinkedList) {
            System.out.println(customer);
        }
    }
}
