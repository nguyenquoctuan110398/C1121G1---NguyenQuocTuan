package service.customer;

import model.customer.Customer;
import model.customer.CustomerDTO;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<CustomerDTO> findAll();

    Map<String, String> save(Customer customer);

    Customer findById(Integer id);

    boolean update(Customer customer);

    List<CustomerDTO> searchByName(String nameSearch);

    boolean deleteCustomerById(Integer id);

//    List<Customer> checkCustomerByCode(String code);
}
