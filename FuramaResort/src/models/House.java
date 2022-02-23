package models;

import java.util.Date;

public class House extends Facility {

    private String roomStandard;
    private int numberFloors;

    public House() {
    }

    public House(String roomStandard, int numberFloors) {
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public House(String serviceName, double usableArea, double rentalCosts, int maxNumberPeople,
                 String rentalType, String roomStandard, int numberFloors) {
        super(serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", roomStandard='" + roomStandard + '\'' +
                ", numberFloors=" + numberFloors;
    }

    @Override
    public String getInfoToWriteCSV() {
        return super.getInfoToWriteCSV() + "," + roomStandard + "," + numberFloors;
    }
}
