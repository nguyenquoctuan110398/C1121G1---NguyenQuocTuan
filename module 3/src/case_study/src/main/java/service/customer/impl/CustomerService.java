package service.customer.impl;


import model.Customer.Customer;
import model.Customer.CustomerDTO;
import repository.customer.ICustomerRepository;
import repository.customer.impl.CustomerRepository;
import service.customer.ICustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CustomerService implements ICustomerService {

    private ICustomerRepository iCustomerRepository = new CustomerRepository();

    @Override
    public List<CustomerDTO> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id);
    }
}
