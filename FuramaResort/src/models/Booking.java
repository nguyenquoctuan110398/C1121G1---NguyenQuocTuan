package models;

import java.util.Date;
import java.util.Objects;

public class Booking {

    private int bookingCode;
    private String startDay;
    private String endDay;
    private int customerCode;
    private String serviceName;
    private String typeOfService;

//    private Customer customer;

    public Booking(int bookingCode, String startDay, String endDay, int customerCode,
                   String serviceName, String typeOfService) {
        this.bookingCode = bookingCode;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerCode = customerCode;
        this.serviceName = serviceName;
        this.typeOfService = typeOfService;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode=" + bookingCode +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", customerCode=" + customerCode +
                ", serviceName='" + serviceName + '\'' +
                ", typeOfService='" + typeOfService + '\'' +
                '}';
    }

    public String getInfoToWrite() {
        return bookingCode + "," + startDay + "," +
                endDay + "," + customerCode + "," +
                serviceName + "," + typeOfService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingCode == booking.bookingCode && customerCode == booking.customerCode &&
                Objects.equals(startDay, booking.startDay) && Objects.equals(endDay, booking.endDay) &&
                Objects.equals(serviceName, booking.serviceName) &&
                Objects.equals(typeOfService, booking.typeOfService);
    }

    @Override
    public int hashCode() {
        return 16;
    }
}
