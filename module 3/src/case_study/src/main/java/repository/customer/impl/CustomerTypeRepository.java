package repository.customer.impl;

import model.customer.CustomerType;
import repository.BaseRepository;
import repository.customer.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {

    private BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_CUSTOMER_TYPE =
            "select customer_type_id, customer_type_name from customer_type";

    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();

        Connection connection = this.baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE);

            ResultSet resultSet =preparedStatement.executeQuery();

            while (resultSet.next()){
                Integer id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");

                CustomerType customerType = new CustomerType(id, name);

                customerTypeList.add(customerType);
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

        return customerTypeList;
    }
}
