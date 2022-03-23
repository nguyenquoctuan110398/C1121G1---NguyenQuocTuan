package model.employee;

import model.Person;

public class Employee extends Person {
    private Double salary;
    private Integer positionId;
    private Integer educationId;
    private  Integer divisionId;
    private String username;

    public Employee() {
    }

    public Employee(Integer id, String name, String birthday, String idCard, Double salary, String phone,
                    String email, String address, Integer positionId, Integer educationId, Integer divisionId) {
        super(id, name, birthday, idCard, phone, email, address);
        this.salary = salary;
        this.positionId = positionId;
        this.educationId = educationId;
        this.divisionId = divisionId;
    }

    public Employee(String name, String birthday, String idCard, Double salary, String phone, String email,
                    String address, Integer positionId, Integer educationId, Integer divisionId,String username) {
        super(name, birthday, idCard, phone, email, address);
        this.salary = salary;
        this.positionId = positionId;
        this.educationId = educationId;
        this.divisionId = divisionId;
        this.username = username;
    }
    public Employee(Integer id, String name, String birthday, String idCard, Double salary, String phone, String email, String address, Integer positionId, Integer educationId, Integer divisionId,String username) {
        super(id, name, birthday, idCard, phone, email, address);
        this.salary = salary;
        this.positionId = positionId;
        this.educationId = educationId;
        this.divisionId = divisionId;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }
}
