package repository.customer.impl;


import model.customer.Customer;
import model.customer.CustomerDTO;
import repository.BaseRepository;
import repository.customer.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {


//    private ICustomerTypeService iCustomerTypeService = new CustomerTypeService();


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
                    "customer_phone, customer_email, customer_address, customer_type_id " +
                    "from customer where customer_id=?;";

    private static final String UPDATE_CUSTOMER_SQL =
            "update customer set customer_name = ?, customer_birthday = ?, customer_gender=?, " +
                    "customer_id_card=?, customer_phone=?, customer_email=?, " +
                    "customer_address=?, customer_type_id=? where customer_id=?;";

    private static final String SEARCH_CUSTOMER_BY_NAME =
            "select customer_id, customer_name, customer_birthday, customer_gender, customer_id_card, " +
                    "customer_phone, customer_email, customer_address, customer_type_name " +
                    "from customer " +
                    "inner join customer_type on customer.customer_type_id = customer_type.customer_type_id " +
                    "where customer_name like ?;";

    private static final String DELETE_CUSTOMER_BY_ID =
            "delete from customer where customer_id=?";

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
        Customer customer = null;

        Connection connection = this.baseRepository.getConnection();
//        List<CustomerType> customerTypeList = new ArrayList<>();
//        customerTypeList = iCustomerTypeService.findAll();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //customer_name, customer_birthday, customer_gender, customer_id_card, " +
                //"customer_phone, customer_email, customer_address, customer_type_id)
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                Integer customerTypeId = resultSet.getInt("customer_type_id");

                customer = new Customer(id, name, birthday, gender, idCard, phone,
                        email, address, customerTypeId);
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

        return customer;
    }

    @Override
    public boolean update(Customer customer) {
        Connection connection = baseRepository.getConnection();

        boolean rowUpdated = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);

            //customer_name = ?, customer_birthday = ?, customer_gender=?, " +
            //"customer_id_card=?, customer_phone=?, customer_email=?, " +
            //"customer_address=?, customer_type_id=? where customer_id=?
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId());
            preparedStatement.setInt(9, customer.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowUpdated;
    }

    @Override
    public List<CustomerDTO> searchByName(String nameSearch) {
        Connection connection = baseRepository.getConnection();

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_BY_NAME);

            preparedStatement.setString(1, "%" + nameSearch + "%");
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            // customer_id, customer_name, customer_birthday, customer_gender, customer_id_card, " +
            // customer_phone, customer_email, customer_address, customer_type_name
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = Integer.valueOf(resultSet.getString("customer_gender"));
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                String customerTypeName = resultSet.getString("customer_type_name");

                CustomerDTO customerDTO = new CustomerDTO(id, name, birthday, gender, idCard, phone,
                        email, address, customerTypeName);

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
    public boolean deleteCustomerById(Integer id) {
        boolean rowDelete = false;

        try (Connection connection = this.baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID)) {

            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDelete;
    }
}
