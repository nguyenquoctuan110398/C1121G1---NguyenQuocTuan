package model.customer;

import model.Person;

public class Customer extends Person {
    private Integer gender;
    private Integer customerTypeId;

    public Customer() {
    }

    public Customer(String code){
        super(code);
    }

    public Customer(Integer gender, Integer customerTypeId) {
        this.gender = gender;
        this.customerTypeId = customerTypeId;
    }

    public Customer(String code, String name, String birthday, Integer gender, String idCard,
                    String phone, String email, String address, Integer customerTypeId) {
        super(code, name, birthday, idCard, phone, email, address);
        this.gender = gender;
        this.customerTypeId = customerTypeId;
    }

    public Customer(Integer id, String code, String name, String birthday, Integer gender, String idCard,
                    String phone, String email, String address, Integer customerTypeId) {
        super(id, code, name, birthday, idCard, phone, email, address);
        this.gender = gender;
        this.customerTypeId = customerTypeId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }
}
