package models;

import java.util.Date;

public class Customer extends Person{

    private int customerCode;
    private String typeGuest;
    private String address;

    public enum TypeGuest{
        DIAMOND("Diamond"),
        PLATINIUM("Platinium"),
        GOLD("Gold"),
        SILVER("Silver"),
        MEMBER("Member");
        private final String value;
        TypeGuest(final String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Customer() {
    }

    public Customer(int customerCode, String typeGuest, String address) {
        this.customerCode = customerCode;
        this.typeGuest = typeGuest;
        this.address = address;
    }

    public Customer(int customerCode,String name, String dateOfBirth, String gender, String numberCMND,
                    String phone, String email, String typeGuest, String address) {
        super(name, dateOfBirth, gender, numberCMND, phone, email);
        this.customerCode = customerCode;
        this.typeGuest = typeGuest;
        this.address = address;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getTypeGuest() {
        return typeGuest;
    }

    public void setTypeGuest(String typeGuest) {
        this.typeGuest = typeGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "customerCode=" + customerCode + ", " +
                super.toString() +
                ", typeGuest='" + typeGuest + '\'' +
                ", address='" + address + '\'';
    }

    public String getInfoToWriteCSV(){
        return this.customerCode + "," + this.getName() +
                "," + this.getDateOfBirth() + "," + this.getGender() +
                "," + this.getNumberCMND() + "," + this.getPhone() +
                "," + this.getEmail()+ "," + this.typeGuest +
                "," + this.address;
    }
}
