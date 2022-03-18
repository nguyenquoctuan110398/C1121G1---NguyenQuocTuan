package repository.customer.impl;


import model.Customer.Customer;
import model.Customer.CustomerDTO;
import repository.BaseRepository;
import repository.customer.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {


    private BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_CUSTOMERS =
            "select customer_id, customer_name, customer_birthday, customer_gender, customer_id_card, " +
                    "customer_phone, customer_email, customer_address, customer_type_name " +
                    "from customer " +
                    "inner join customer_type on customer.customer_type_id = customer_type.customer_type_id " +
                    "order by customer_id;";

    private static final String INSERT_CUSTOMER =
            "insert into customer(customer_name, customer_birthday, customer_gender, customer_id_card, " +
                    "customer_phone, customer_email, customer_address, customer_type_id) " +
                    "value(?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_CUSTOMER_BY_ID =
            "select customer_name, customer_birthday, customer_gender, customer_id_card, " +
                    "customer_phone, customer_email, customer_address, customer_type_id) " +
                    "where customer_id = ?;";

    @Override
    public List<CustomerDTO> findAll() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        Connection connection = this.baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMERS);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                String customerTypeName = resultSet.getString("customer_type_name");

                CustomerDTO customerDTO = new CustomerDTO(id, name, birthday, gender, idCard,
                        phone, email, address, customerTypeName);

                customerDTOList.add(customerDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerDTOList;
    }

    @Override
    public void save(Customer customer) {
        Connection connection = baseRepository.getConnection();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer;

        Connection connection = this.baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
