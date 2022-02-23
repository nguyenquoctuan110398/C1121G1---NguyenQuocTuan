package models;

import java.util.Date;

public class Room extends Facility {

    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceName, double usableArea, double rentalCosts, int maxNumberPeople,
                String rentalType, String freeService) {
        super(serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", freeService='" + freeService + '\'';
    }

    public String getInfoToWriteCSV() {
        return super.getInfoToWriteCSV() + "," + freeService;
    }
}
