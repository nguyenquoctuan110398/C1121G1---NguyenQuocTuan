package models;

import java.util.Date;

public class Employee extends Person {

    public enum Level {
        INTERMEDIATE("Trung cấp"),
        COLLEGE("Cao đẳng"),
        UNIVERSITY("Đại học"),
        AFTERUNIVERSITY("Sau đại học");
        private final String value;

        Level(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Position {
        RECEPTIONIST("Lễ tân"),
        SERVANTS("Phục vụ"),
        SPECIALIST("Chuyên viên"),
        SUPERVISOR("Giám sát"),
        MANAGER("Quản lý"),
        DIRECTOR("Giám đốc");
        private final String value;

        Position(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private int employeeCode;
    private String level;
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(int employeeCode, String level, String position, int salary) {
        this.employeeCode = employeeCode;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(int employeeCode, String name, String dateOfBirth, String gender, String numberCMND,
                    String phone, String email, String level, String position, int salary) {
        super(name, dateOfBirth, gender, numberCMND, phone, email);
        this.employeeCode = employeeCode;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "employeeCode=" + employeeCode + ", " +
                super.toString() +
                ", level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary;
    }

    public String getInfoToWriteCSV() {
        return this.employeeCode + "," + this.getName() + "," + this.getDateOfBirth() +
                "," + this.getGender() + "," + this.getNumberCMND() +
                "," + this.getPhone() + "," + this.getEmail() +
                "," + this.level + "," + this.position + "," + this.salary;
    }
}
