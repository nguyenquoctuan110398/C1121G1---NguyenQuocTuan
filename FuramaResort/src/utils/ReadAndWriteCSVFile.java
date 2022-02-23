package utils;

import models.*;

import java.io.*;
import java.util.*;

public class ReadAndWriteCSVFile {

    public static final String VILLA_FILE = "src/data/Villa.csv";
    public static final String HOUSE_FILE = "src/data/House.csv";
    public static final String ROOM_FILE = "src/data/Room.csv";
    public static final String BOOKING_FILE = "src/data/Booking.csv";
    public static final String BOOKING_NO_CONTRACT_FILE = "src/data/BookingNoContract.csv";
    public static final String CONTRACT_FILE = "src/data/Contract.csv";


    public static <E> void writePersonToCSV(List<E> elementList, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (E element : elementList) {
                if (element instanceof Employee) {
                    bufferedWriter.write(((Employee) element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                } else if (element instanceof Customer) {
                    bufferedWriter.write(((Customer) element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readEmployeeToCSV(String pathFile) {
        List<Employee> employeeArrayList = new ArrayList<>();
        File file = new File(pathFile);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Employee employee = new Employee(Integer.parseInt(array[0]), array[1], array[2], array[3],
                        array[4], array[5], array[6], array[7], array[8], Integer.parseInt(array[9]));

                employeeArrayList.add(employee);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeArrayList;
    }

    public static List<Customer> readCustomerToCSV(String pathFile) {
        List<Customer> customerArrayList = new ArrayList<>();
        File file = new File(pathFile);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Customer customer = new Customer(Integer.parseInt(array[0]), array[1], array[2], array[3],
                        array[4], array[5], array[6], array[7], array[8]);

                customerArrayList.add(customer);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerArrayList;
    }

    public static void writeFacilityToCSV(Facility facility, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(facility.getInfoToWriteCSV());
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Facility, Integer> readFacilityToCSV(String pathFile) {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        File file = new File(pathFile);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr = null;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");

                if (pathFile.equals(VILLA_FILE)) {
                    Villa villa = new Villa(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]),
                            Integer.parseInt(arr[3]), arr[4], arr[5], Double.parseDouble(arr[6]),
                            Integer.parseInt(arr[7]));
                    facilityIntegerMap.put(villa, 0);

                } else if (pathFile.equals(HOUSE_FILE)) {
                    House house = new House(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]),
                            Integer.parseInt(arr[3]), arr[4], arr[5], Integer.parseInt(arr[6]));
                    facilityIntegerMap.put(house, 0);
                } else {
                    Room room = new Room(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]),
                            Integer.parseInt(arr[3]), arr[4], arr[5]);
                    facilityIntegerMap.put(room, 0);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilityIntegerMap;
    }

    public static void writeBookingTreeSetToCSV(Set<Booking> bookingTreeSet, String pathFilde, boolean append) {
        File file = new File(pathFilde);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Booking booking: bookingTreeSet){
                bufferedWriter.write(booking.getInfoToWrite());
                bufferedWriter.newLine();
            }


            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBookingQueueToCSV(Queue<Booking> bookingQueue, String pathFilde, boolean append) {
        File file = new File(pathFilde);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Booking booking: bookingQueue){
                bufferedWriter.write(booking.getInfoToWrite());
                bufferedWriter.newLine();
            }


            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<Booking> readBookingTreeSetToCSV(String pathFile) {
        Set<Booking> bookingTreeSet = new TreeSet<>(new BookingComparator());
        File file = new File(pathFile);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr = null;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");

                Booking booking = new Booking(Integer.parseInt(arr[0]), arr[1], arr[2],
                        Integer.parseInt(arr[3]), arr[4], arr[5]);
                bookingTreeSet.add(booking);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookingTreeSet;
    }

    public static void writeContractToCSV(List<Contract> contractList, String pathFile, boolean append){
        File file = new File(pathFile);

        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Contract contract:contractList){

                bufferedWriter.write(contract.getInfoToWriteCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Contract> readContractToCSV(String pathFile) {
        List<Contract> contractList = new ArrayList<>();
        File file = new File(pathFile);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Contract contract = new Contract(Integer.parseInt(array[0]),Integer.parseInt(array[1]),
                        Double.parseDouble(array[2]),Double.parseDouble(array[3]),Integer.parseInt(array[4]));

                contractList.add(contract);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return contractList;
    }
}
