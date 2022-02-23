package controllers;

import services.BookingService;
import services.EmployeeService;
import services.Service;
import services.impl.*;

import java.util.Scanner;

public class FuramaController {

    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    BookingServiceImpl bookingService = new BookingServiceImpl();
    ContractServiceImpl contractService = new ContractServiceImpl();
    PromotionManagementServiceImpl promotionManagementService = new PromotionManagementServiceImpl();

    Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        int choose=0;
        boolean check;

        do {
            check=true;
            System.out.println("1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");

            System.out.println("Enter choose: ");
            try{
                choose = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Nhập sai định dạng, mời nhập lại");
            }

            switch (choose) {
                case 1:
                    int choose1=0;
                    boolean flag;
                    do {
                        flag = true;

                        System.out.println("1\tDisplay list employees\n" +
                                "2\tAdd new employee\n" +
                                "3\tEdit employee\n" +
                                "4\tReturn main menu\n");


                        System.out.print("Enter your choose: ");
                        try{
                            choose1 = Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Nhập sai định dạng, mời nhập lại");
                        }

                        switch (choose1) {
                            case 1:
                                employeeService.display();
                                break;

                            case 2:
                                employeeService.add();
                                break;

                            case 3:
                                employeeService.edit();
                                break;

                            case 4:
                                flag = false;
                                break;

                            default:
                                System.out.println("Invalid, re-enter");
                        }
                    } while (flag);
                    break;

                case 2:
                    int choose2=0;
                    boolean flag1;

                    do {
                        flag1 = true;

                        System.out.println("1.\tDisplay list customers\n" +
                                "2.\tAdd new customer\n" +
                                "3.\tEdit customer\n" +
                                "4.\tReturn main menu\n");

                        System.out.print("Enter your choose: ");
                        try{
                            choose2 = Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Nhập sai định dạng, mời nhập lại");
                        }
//                        choose2 = Integer.parseInt(scanner.nextLine());

                        switch (choose2) {
                            case 1:
                                customerService.display();
                                break;

                            case 2:
                                customerService.add();
                                break;

                            case 3:
                                customerService.edit();
                                break;

                            case 4:
                                flag1 = false;
                                break;

                            default:
                                System.out.println("Invalid, re-enter");
                        }
                    } while (flag1);
                    break;

                case 3:
                    int choose3=0;
                    boolean flag2;

                    do {
                        flag2=true;

                        System.out.println("1. Display list facility\n" +
                                "2. Add new facility\n" +
                                "3. Display list facility maintenance\n" +
                                "4. Return main menu\n");

                        System.out.print("Enter your choose: ");

                        try{
                            choose3 = Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Nhập sai định dạng, mời nhập lại");
                        }
//                        choose3 = Integer.parseInt(scanner.nextLine());

                        switch (choose3) {
                            case 1:
                                facilityService.display();
                                break;

                            case 2:
                                int choosee=0;
                                boolean flagg;

                                do {
                                    flagg=true;

                                    System.out.println("1. Add New Villa\n" +
                                            "2. Add New House\n" +
                                            "3. Add New Room\n" +
                                            "4. Back to menu\n");

                                    System.out.println("Enter choose: ");

                                    try{
                                        choosee = Integer.parseInt(scanner.nextLine());
                                    }catch (NumberFormatException e){
                                        System.out.println("Nhập sai định dạng, mời nhập lại");
                                    }
//                                    choosee = Integer.parseInt(scanner.nextLine());

                                    switch (choosee){
                                        case 1:
                                            facilityService.addVilla();
                                            break;
                                        case 2:
                                            facilityService.addHouse();
                                            break;
                                        case 3:
                                            facilityService.addRoom();
                                            break;
                                        case 4:
                                            flagg = false;
                                            break;

                                        default:
                                            System.out.println("Invalid, re-enter");
                                    }
                                } while (flagg);

                            case 3:
                                break;

                            case 4:
                                flag2 = false;
                                break;

                            default:
                                System.out.println("Invalid, re-enter");
                        }
                    }while (flag2);


                case 4:

                    int chooseee=0;
                    boolean flaggg;

                    do {
                        flaggg=true;

                        System.out.println("1.\tAdd new booking\n" +
                                "2.\tDisplay list booking\n" +
                                "3.\tCreate new contracts\n" +
                                "4.\tDisplay list contracts\n" +
                                "5.\tEdit contracts\n" +
                                "6.\tReturn main menu\n");
                        System.out.println("Enter your choose: ");

                        try{
                            chooseee = Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Nhập sai định dạng, mời nhập lại");
                        }
//                        chooseee=Integer.parseInt(scanner.nextLine());

                        switch (chooseee){
                            case 1:
                                bookingService.add();
                                break;

                            case 2:
                                bookingService.display();
                                break;

                            case 3:
                                contractService.createNewContract();
                                break;

                            case 4:
                                contractService.display();
                                break;

                            case 5:
                                contractService.edit();
                                break;

                            case 6:
                                flaggg=false;
                                break;

                            default:
                                System.out.println("Invalid, re-enter");
                        }
                    } while (flaggg);

                    break;

                case 5:
                    boolean flagg;
                    int choosee=0;

                    do{
                        flagg=true;

                        System.out.println("1.\tDisplay list customers use service\n" +
                                "2.\tDisplay list customers get voucher\n" +
                                "3.\tReturn main menu\n");
                        System.out.println("Enter your choose: ");
                        try{
                            choosee = Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Nhập sai định dạng, mời nhập lại");
                        }
//                        choosee = Integer.parseInt(scanner.nextLine());

                        switch (choosee){
                            case 1:
                                promotionManagementService.displayCustomersUseService();
                                break;

                            case 2:
                                promotionManagementService.displayCustomersGetVoucher();
                                break;

                            case 3:
                                flagg = false;
                                break;

                            default:
                                System.out.println("Invalid, re-enter");
                        }

                    }while (flagg);

                    break;

                case 6:
                    check=false;
                    break;

                default:
                    System.out.println("Enter incorrectly, please re-enter");
            }
        } while (check);


    }

    public static void main(String[] args) {
        FuramaController furamaController = new FuramaController();

        furamaController.displayMainMenu();
    }
}
