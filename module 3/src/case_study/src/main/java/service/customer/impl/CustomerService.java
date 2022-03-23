package service.customer.impl;


import model.customer.Customer;
import model.customer.CustomerDTO;
import repository.customer.ICustomerRepository;
import repository.customer.impl.CustomerRepository;
import service.Regex;
import service.customer.ICustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {

    private ICustomerRepository iCustomerRepository = new CustomerRepository();

    @Override
    public List<CustomerDTO> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Map<String, String> save(Customer customer) {

        Regex regex = new Regex();

        Map<String, String> customerMap = new HashMap<>();
        boolean check = true;

        if (!customer.getCode().matches(regex.REGEX_CODE_CUSTOMER)) {
            check = false;
            customerMap.put("code", "Không đúng định dạng (ví dụ:KH-XXXX)");
        }

        if (iCustomerRepository.checkCustomerCodeExist(customer.getCode())) {
            check = false;
            customerMap.put("checkCodeExist", "Customer đã tồn tại");
        }

        if (!customer.getName().matches(regex.REGEX_NAME)) {
            check = false;
            customerMap.put("name", "Không đúng định dạng viết hoa ký tự đầu (ví dụ: Tuấn Nguyễn");
        }

        if (!customer.getIdCard().matches(regex.REGEX_ID_CARD)){
            check = false;
            customerMap.put("idCard", "Không đúng định dạng là số XXXXXXXX hoặc XXXXXXXXXXXX với X là 0-9");
        }

        if (!customer.getPhone().matches(regex.REGEX_PHONE)){
            check = false;
            customerMap.put("phone", "Sai định dạng số điện thoại " +
                    "(090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx)");
        }

        if (!customer.getEmail().matches(regex.REGEX_EMAIL)){
            check = false;
            customerMap.put("email", "Không đúng cách viết email");
        }



//        if (!customer.getName().matches(regex.REGEX_NAME)) {
//            flag = false;
//            map.put("name", "Không đúng định dạng viết hoa kí tự đầu,có dấu(ví dụ:Nguyễn Long)");
//        }
////        if (!customer.getBirthday().matches(regex.REGEX_DATE)) {
////            flag = false;
////            map.put("birthday", "Không đúng định dạng yyyy-mm-dd (ví dụ:2021-12-02)");
////        }
//        if (!customer.getIdCard().matches(regex.REGEX_NUMBER)) {
//            flag = false;
//            map.put("idCard", "Không đúng định dạng số");
//        }
//        if (!customer.getPhone().matches(regex.REGEX_PHONE)) {
//            flag = false;
//            map.put("phone", "Sai định dạng số điện thoại (090|091|(84)+)");
//        }
//        if (!customer.getEmail().matches(regex.REGEX_EMAIL)) {
//            flag = false;
//            map.put("email", "Sai định dạng email (ví dụ: test@gmail.com)");
//        }

        if (check) {
            iCustomerRepository.save(customer);
        }
        return customerMap;
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public boolean update(Customer customer) {
        return iCustomerRepository.update(customer);
    }

    @Override
    public List<CustomerDTO> searchByName(String nameSearch) {
        return iCustomerRepository.searchByName(nameSearch);
    }

    @Override
    public boolean deleteCustomerById(Integer id) {
        return iCustomerRepository.deleteCustomerById(id);
    }

//    @Override
//    public List<Customer> checkCustomerByCode(String code) {
//        return iCustomerRepository.checkCustomerByCode(code);
//    }
}
