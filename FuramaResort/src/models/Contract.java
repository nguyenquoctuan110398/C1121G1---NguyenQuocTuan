package models;

public class Contract {
    private int contractNumber;
    private int bookingCode;
    private double depositAmount;
    private double totalAmount;
    private int customerCode;

    public Contract() {
    }

    public Contract(int contractNumber, int bookingCode, double depositAmount, double totalAmount,
                    int customerCode) {
        this.contractNumber = contractNumber;
        this.bookingCode = bookingCode;
        this.depositAmount = depositAmount;
        this.totalAmount = totalAmount;
        this.customerCode = customerCode;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber=" + contractNumber +
                ", bookingCode=" + bookingCode +
                ", depositAmount=" + depositAmount +
                ", totalAmount=" + totalAmount +
                ", customerCode=" + customerCode +
                '}';
    }

    public String getInfoToWriteCSV() {
        return contractNumber + "," + bookingCode + "," +
                depositAmount + "," + totalAmount + "," + contractNumber;
    }
}
