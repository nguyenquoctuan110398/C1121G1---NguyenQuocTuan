package services.impl;

import models.Booking;
import models.Contract;
import models.Customer;
import services.BookingService;
import services.ContractService;
import utils.ReadAndWriteCSVFile;

import java.util.*;

public class ContractServiceImpl implements ContractService {

//    static List<Contract> contractList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        List<Contract> contractList = new ArrayList<>();
        contractList = ReadAndWriteCSVFile.readContractToCSV(ReadAndWriteCSVFile.CONTRACT_FILE);

        for (Contract contract : contractList) {
            System.out.println(contract);
        }
    }

    @Override
    public void createNewContract() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
        List<Contract> contractList = new ArrayList<>();

        contractList =ReadAndWriteCSVFile.readContractToCSV(ReadAndWriteCSVFile.CONTRACT_FILE);

        for (Booking booking : bookingSet) {
            if (!(booking.getServiceName().contains("Room"))) {
                bookingQueue.add(booking);
            }
        }

        while (!bookingQueue.isEmpty()) {
            for (Booking booking1 : bookingQueue) {
                System.out.println(booking1);
            }

            Booking booking = bookingQueue.remove();

            ReadAndWriteCSVFile.writeBookingQueueToCSV(bookingQueue, ReadAndWriteCSVFile.BOOKING_NO_CONTRACT_FILE, false);

            System.out.println("Enter contract number: ");
            int contractNumber = Integer.parseInt(scanner.nextLine());

            int bookingCode = booking.getBookingCode();

            System.out.println("Enter deposit amount: ");
            Double depositAmount = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter total amount: ");
            int totalAmount = Integer.parseInt(scanner.nextLine());

            int customerCode = booking.getCustomerCode();

            Contract contract = new Contract(contractNumber, bookingCode, depositAmount, totalAmount, customerCode);

            contractList.add(contract);

            ReadAndWriteCSVFile.writeContractToCSV(contractList, ReadAndWriteCSVFile.CONTRACT_FILE, false);

            System.out.println("CONTRACT CREATED SUCCESSFULLY");
        }
    }

    @Override
    public void edit() {
        List<Contract> contractList = new ArrayList<>();
        contractList = ReadAndWriteCSVFile.readContractToCSV(ReadAndWriteCSVFile.CONTRACT_FILE);

        System.out.println("Enter contract number to edit: ");
        int contractNumberEdit = Integer.parseInt(scanner.nextLine());

        if (contractList.isEmpty()) {
            System.out.println("No contract to edit");
        } else {
            boolean flag;
            boolean check = false;

            for (int i = 0; i < contractList.size(); i++) {
                if (contractNumberEdit == contractList.get(i).getContractNumber()) {
                    check = true;
                    do {
                        flag = true;
                        System.out.println("You want to edit\n" +
                                "1. Deposit amount\n" +
                                "2. Total amount\n" +
                                "3. Exit");

                        System.out.print("Enter your choose: ");
                        int choose = Integer.parseInt(scanner.nextLine());

                        switch (choose){
                            case 1:
                                System.out.println("Enter new deposit amount: ");
                                Double depositAmount = Double.parseDouble(scanner.nextLine());

                                contractList.get(i).setDepositAmount(depositAmount);
                                break;

                            case 2:
                                System.out.println("Enter new total amount: ");
                                Double totalAmount = Double.parseDouble(scanner.nextLine());

                                contractList.get(i).setTotalAmount(totalAmount);
                                break;

                            case 3:
                                flag=false;
                                break;

                            default:
                                System.out.println("Invalid, re-enter");
                        }

                    }while (flag);
                    break;
                }
            }
            if (!check) {
                System.out.println("Can't find contract to edit");
            }
        }
        ReadAndWriteCSVFile.writeContractToCSV(contractList,ReadAndWriteCSVFile.CONTRACT_FILE,false);
    }
}
