package services.impl;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import services.FacilityService;
import utils.ReadAndWriteCSVFile;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {

    public static final String REGEX_STR="^[A-Z][a-z]+$";
    public static final String REGEX_ID_VILLA="^(SVVL)[-][\\d]{4}$";
    public static final String REGEX_AMOUNT="^(([1-9])|([1][0-9])|(20))$";
//    public static final String


    Scanner scanner = new Scanner(System.in);

    public void display() {
        Map<Facility, Integer> villaIntegerMap = new LinkedHashMap<>();
        Map<Facility, Integer> houseIntegerMap = new LinkedHashMap<>();
        Map<Facility, Integer> roomIntegerMap = new LinkedHashMap<>();

        villaIntegerMap = ReadAndWriteCSVFile.readFacilityToCSV(ReadAndWriteCSVFile.VILLA_FILE);
        houseIntegerMap = ReadAndWriteCSVFile.readFacilityToCSV(ReadAndWriteCSVFile.HOUSE_FILE);
        roomIntegerMap = ReadAndWriteCSVFile.readFacilityToCSV(ReadAndWriteCSVFile.ROOM_FILE);

        if (!villaIntegerMap.isEmpty()) {
            Set<Facility> key = villaIntegerMap.keySet();

            System.out.println("-------VILLA LIST-------");
            for (Facility facility : key) {
                System.out.println(facility + ", number of hires is: " + villaIntegerMap.get(facility));
            }
        }

        if (!houseIntegerMap.isEmpty()) {
            Set<Facility> key = houseIntegerMap.keySet();

            System.out.println("-------HOUSE LIST-------");
            for (Facility facility : key) {
                System.out.println(facility + ", number of hires is: " + houseIntegerMap.get(facility));
            }
        }

        if (!roomIntegerMap.isEmpty()) {
            Set<Facility> key = roomIntegerMap.keySet();

            System.out.println("-------ROOM LIST-------");
            for (Facility facility : key) {
                System.out.println(facility + ", number of hires is: " + roomIntegerMap.get(facility));
            }
        }
    }

    public void addVilla() {
        Map<Facility, Integer> villaIntegerMap = new LinkedHashMap<>();

        System.out.println("Enter service name: ");
        String serviceName = scanner.nextLine();

        System.out.println("Enter usable area: ");
        double usableArea = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter rental costs: ");
        double retalCosts = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter max number people: ");
        int maxNumberPeople = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter rental type: ");
        String rentalType = scanner.nextLine();

        System.out.println("Enter room standard: ");
        String roomStandard = scanner.nextLine();

        System.out.println("Enter pool area: ");
        double poolArea = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter number floor: ");
        int numberFloor = Integer.parseInt(scanner.nextLine());

        Villa villa = new Villa(serviceName, usableArea, retalCosts, maxNumberPeople, rentalType,
                roomStandard, poolArea, numberFloor);


        villaIntegerMap.put(villa, 0);

        ReadAndWriteCSVFile.writeFacilityToCSV(villa, ReadAndWriteCSVFile.VILLA_FILE, true);

    }

    public void addHouse() {
        Map<Facility, Integer> houseIntegerMap = new LinkedHashMap<>();

        System.out.println("Enter service name: ");
        String serviceName = scanner.nextLine();

        System.out.println("Enter usable area: ");
        double usableArea = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter rental costs: ");
        double retalCosts = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter max number people: ");
        int maxNumberPeople = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter rental type: ");
        String rentalType = scanner.nextLine();

        System.out.println("Enter room standard: ");
        String roomStandard = scanner.nextLine();

        System.out.println("Enter number floor: ");
        int numberFloor = Integer.parseInt(scanner.nextLine());

        House house = new House(serviceName, usableArea, retalCosts, maxNumberPeople,
                rentalType, roomStandard, numberFloor);
        houseIntegerMap.put(house, 0);

        ReadAndWriteCSVFile.writeFacilityToCSV(house, ReadAndWriteCSVFile.HOUSE_FILE, true);
    }

    public void addRoom() {
        Map<Facility, Integer> roomIntegerMap = new LinkedHashMap<>();

        System.out.println("Enter service name: ");
        String serviceName = scanner.nextLine();

        System.out.println("Enter usable area: ");
        double usableArea = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter rental costs: ");
        double retalCosts = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter max number people: ");
        int maxNumberPeople = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter rental type: ");
        String rentalType = scanner.nextLine();

        System.out.println("Enter free service: ");
        String freeService = scanner.nextLine();

        Room room = new Room(serviceName, usableArea, retalCosts, maxNumberPeople, rentalType, freeService);

        roomIntegerMap.put(room, 0);

        ReadAndWriteCSVFile.writeFacilityToCSV(room, ReadAndWriteCSVFile.ROOM_FILE, true);
    }

}
