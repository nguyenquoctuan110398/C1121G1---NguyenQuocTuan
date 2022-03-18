package service.customer;

import model.Customer.Customer;
import model.Customer.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAll();

    void save(Customer customer);

    Customer findById(Integer id);
}
