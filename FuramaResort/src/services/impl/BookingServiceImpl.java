package services.impl;

import models.*;
import services.BookingService;
import utils.BookingComparator;
import utils.ReadAndWriteCSVFile;

import java.util.*;

public class BookingServiceImpl implements BookingService {


    Queue<Booking> bookingNoContractSet = new LinkedList<>();


    Scanner scanner = new Scanner(System.in);


    public Set<Booking> sendBooking() {

        Set<Booking> bookingNoContractSet = ReadAndWriteCSVFile.readBookingTreeSetToCSV(ReadAndWriteCSVFile.BOOKING_NO_CONTRACT_FILE);
        return bookingNoContractSet;
    }

    @Override
    public void add() {
        Set<Booking> bookingTreeSet = new TreeSet<>(new BookingComparator());

        System.out.println("Enter booking code: ");
        int bookingCode = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter start day: ");
        String startDate = scanner.nextLine();

        System.out.println("Enter end day: ");
        String endDate = scanner.nextLine();

        int customerCode = chooseCustomerCode();

        String serviceName = chooseServiceName();

        System.out.println("Enter type of service: ");
        String typeOfService = scanner.nextLine();

        Booking booking = new Booking(bookingCode, startDate, endDate, customerCode, serviceName, typeOfService);

        bookingTreeSet.add(booking);
        ReadAndWriteCSVFile.writeBookingTreeSetToCSV(bookingTreeSet, ReadAndWriteCSVFile.BOOKING_FILE, true);

        bookingNoContractSet.add(booking);
        ReadAndWriteCSVFile.writeBookingQueueToCSV(bookingNoContractSet, ReadAndWriteCSVFile.BOOKING_NO_CONTRACT_FILE, true);
    }

    @Override
    public void display() {
        Set<Booking> bookingTreeSet = new TreeSet<>(new BookingComparator());

        bookingTreeSet = ReadAndWriteCSVFile.readBookingTreeSetToCSV(ReadAndWriteCSVFile.BOOKING_FILE);

        for (Booking booking : bookingTreeSet) {
            System.out.println(booking);
        }
    }

    public int chooseCustomerCode() {
        List<Customer> customerLinkedList = new LinkedList<>();

        customerLinkedList = ReadAndWriteCSVFile.readCustomerToCSV(CustomerServiceImpl.CUSTOMER_PATH_FILE);

        int customerCode;

        System.out.println("------Customer code------");
        for (int i = 0; i < customerLinkedList.size(); i++) {
            System.out.println((i + 1) + ". " + customerLinkedList.get(i));
        }

        System.out.println("Choose customer code: ");
        int j = Integer.parseInt(scanner.nextLine());

        customerCode = customerLinkedList.get(j - 1).getCustomerCode();

        return customerCode;
    }

    public String chooseServiceName() {
        Map<Facility, Integer> villaIntegerMap = new LinkedHashMap<>();
        Map<Facility, Integer> houseIntegerMap = new LinkedHashMap<>();
        Map<Facility, Integer> roomIntegerMap = new LinkedHashMap<>();

        villaIntegerMap = ReadAndWriteCSVFile.readFacilityToCSV(ReadAndWriteCSVFile.VILLA_FILE);
        houseIntegerMap = ReadAndWriteCSVFile.readFacilityToCSV(ReadAndWriteCSVFile.HOUSE_FILE);
        roomIntegerMap = ReadAndWriteCSVFile.readFacilityToCSV(ReadAndWriteCSVFile.ROOM_FILE);

        String serviceName = "";

        System.out.println("------Service name------");

        System.out.println("------Villa------");
        if (!villaIntegerMap.isEmpty()) {
            Set<Facility> key = villaIntegerMap.keySet();

            for (Facility villa : key) {
                System.out.println(villa + ", number of hires is: " +
                        villaIntegerMap.get(villa));
            }
        }

        System.out.println("------House------");
        if (!houseIntegerMap.isEmpty()) {
            Set<Facility> key = houseIntegerMap.keySet();

            for (Facility house : key) {
                System.out.println(house + ", number of hires is: " +
                        houseIntegerMap.get(house));
            }
        }

        System.out.println("------Room------");
        if (!roomIntegerMap.isEmpty()) {
            Set<Facility> key = roomIntegerMap.keySet();

            for (Facility room : key) {
                System.out.println(room + ", number of hires is: " +
                        roomIntegerMap.get(room));
            }
        }

        System.out.println("Enter service name to booking: ");
        String serviceNameToBooking = scanner.nextLine();

        if (!villaIntegerMap.isEmpty()) {
            Set<Facility> key = villaIntegerMap.keySet();
            for (Facility villa : key) {
                if (serviceNameToBooking.equals(villa.getServiceName())) {
                    serviceName = villa.getServiceName();
                }
            }
        }

        if (!houseIntegerMap.isEmpty()) {
            Set<Facility> key = houseIntegerMap.keySet();

            for (Facility house : key) {
                if (serviceNameToBooking.equals(house.getServiceName())) {
                    serviceName = house.getServiceName();
                }
            }
        }

        if (!roomIntegerMap.isEmpty()) {
            Set<Facility> key = roomIntegerMap.keySet();

            for (Facility room : key) {
                if (serviceNameToBooking.equals(room.getServiceName())) {
                    serviceName = room.getServiceName();
                }
            }
        }
        return serviceName;
    }
}
