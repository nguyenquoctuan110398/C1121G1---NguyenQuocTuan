package service.customer.impl;


import model.customer.Customer;
import model.customer.CustomerDTO;
import repository.customer.ICustomerRepository;
import repository.customer.impl.CustomerRepository;
import service.customer.ICustomerService;

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
}
