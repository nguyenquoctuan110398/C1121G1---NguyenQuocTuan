package model.customer;

import model.Person;

public class CustomerDTO extends Person {
    private Integer gender;
    private String customerTypeName;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer gender, String customerTypeName) {
        this.gender = gender;
        this.customerTypeName = customerTypeName;
    }

    public CustomerDTO(Integer id, String name, String birthday, Integer gender, String idCard, String phone,
                       String email, String address, String customerTypeName) {
        super(id, name, birthday, idCard, phone, email, address);
        this.gender = gender;
        this.customerTypeName = customerTypeName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
