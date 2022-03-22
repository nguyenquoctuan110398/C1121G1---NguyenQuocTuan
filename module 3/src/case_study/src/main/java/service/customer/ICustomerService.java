package service.customer;

import model.customer.Customer;
import model.customer.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    boolean update(Customer customer);

    List<CustomerDTO> searchByName(String nameSearch);

    boolean deleteCustomerById(Integer id);
}
