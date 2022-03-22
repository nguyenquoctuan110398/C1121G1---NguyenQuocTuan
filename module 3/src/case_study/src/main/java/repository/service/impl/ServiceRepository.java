package repository.service.impl;

import jdk.nashorn.internal.ir.SplitReturn;
import model.service.Service;
import model.service.ServiceDTO;
import model.service.ServiceType;
import repository.BaseRepository;
import repository.service.IServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {

    private BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_SERVICES =
            "select service_id, service_name, service_area, service_cost, service_max_people, " +
                    "rent_type_name, service_type_name, standard_room, description_other_convenience, " +
                    "ifnull(pool_area, -1) pool_area, ifnull(number_of_floors, -1) " +
                    "number_of_floors from rent_type " +
                    "inner join service on rent_type.rent_type_id = service.rent_type_id " +
                    "inner join service_type on service.service_type_id = service_type.service_type_id";

    private static final String SELECT_SERVICE_TYPES =
            "select * from service_type";

    private static final String INSERT_INTO_VILLA =
            "insert into service(service_id, service_name, service_area, service_cost, " +
                    "service_max_people, rent_type_id, service_type_id, standard_room, " +
                    "description_other_convenience, pool_area, number_of_floors) values (?,?,?,?,?,?,?,?,?,?,?)";

    private static final String INSERT_INTO_HOUSE =
            "insert into service(service_name, service_area, service_cost, " +
                    "service_max_people, rent_type_id, service_type_id, standard_room, " +
                    "description_other_convenience, number_of_floors) values (?,?,?,?,?,?,?,?,?,?)";

    private static final String INSERT_INTO_ROOM =
            "insert into service(service_id, service_name, service_area, service_cost, " +
                    "service_max_people, rent_type_id, service_type_id) " +
                    "values (?,?,?,?,?,?,?)";

    @Override
    public List<ServiceDTO> findAll() {
        Connection connection = baseRepository.getConnection();

        List<ServiceDTO> serviceDTOList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICES);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                Integer area = resultSet.getInt("service_area");
                Double cost = resultSet.getDouble("service_cost");
                Integer maxPeople = resultSet.getInt("service_max_people");
                String rentTypeName = resultSet.getString("rent_type_name");
                String serviceTypeName = resultSet.getString("service_type_name");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                Double poolArea = resultSet.getDouble("pool_area");
                Integer numberOfFloors = resultSet.getInt("number_of_floors");

                ServiceDTO serviceDTO = new ServiceDTO(id, name, area, cost, maxPeople, rentTypeName,
                        serviceTypeName, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors);

                serviceDTOList.add(serviceDTO);
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
        return serviceDTOList;
    }

    @Override
    public List<ServiceType> findServiceType() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_TYPES);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("service_type_id");
                String name = resultSet.getString("service_type_name");

                ServiceType serviceType = new ServiceType(id, name);

                serviceTypeList.add(serviceType);
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
        return serviceTypeList;
    }

//    @Override
//    public void save(Service service) {
//        try(Connection connection = this.baseRepository.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_VILLA)){
//
//            if (service.getServiceTypeId() == 1){
//                preparedStatement.setInt(1, service.getId());
//                preparedStatement.setString(2, service.getName());
//                preparedStatement.setInt(3, service.getArea());
//                preparedStatement.setDouble(4, service.getCost());
//                preparedStatement.setInt(5, service.getMaxPeople());
//                preparedStatement.setInt(6, service.getRentTypeId());
//                preparedStatement.setInt(7, service.getServiceTypeId());
//                preparedStatement.setString(8, service.getStandardRoom());
//                preparedStatement.setString(9, service.getDescriptionOtherConvenience());
//                preparedStatement.setDouble(10, service.getPoolArea());
//                preparedStatement.setInt(11, service.getNumberOfFloors());
//
//                preparedStatement.executeUpdate();
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void saveVilla(Service service) {
        try(Connection connection = this.baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_VILLA)) {
            //service(service_id, service_name, service_area, service_cost, " +
            //"service_max_people, rent_type_id, service_type_id, standard_room, " +
            //"description_other_convenience, pool_area, number_of_floors) values (?,?,?,?,?,?,?,?,?,?,?)
            preparedStatement.setInt(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setInt(3, service.getArea());
            preparedStatement.setDouble(4, service.getCost());
            preparedStatement.setInt(5, service.getMaxPeople());
            preparedStatement.setInt(6, service.getRentTypeId());
            preparedStatement.setInt(7, service.getServiceTypeId());
            preparedStatement.setString(8, service.getStandardRoom());
            preparedStatement.setString(9, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(10, service.getPoolArea());
            preparedStatement.setInt(11, service.getNumberOfFloors());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveHouse(Service service) {
        try(Connection connection =this.baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_HOUSE)){
            //service_id, service_name, service_area, service_cost, " +
            //service_max_people, rent_type_id, service_type_id, standard_room, " +
            //description_other_convenience, number_of_floors

            preparedStatement.setInt(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setInt(3, service.getArea());
            preparedStatement.setDouble(4, service.getCost());
            preparedStatement.setInt(5, service.getMaxPeople());
            preparedStatement.setInt(6, service.getRentTypeId());
            preparedStatement.setInt(7, service.getServiceTypeId());
            preparedStatement.setString(8, service.getStandardRoom());
            preparedStatement.setString(9, service.getDescriptionOtherConvenience());
            preparedStatement.setInt(10, service.getNumberOfFloors());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveRoom(Service service) {
        try(Connection connection = this.baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_ROOM)){

            preparedStatement.setInt(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setInt(3, service.getArea());
            preparedStatement.setDouble(4, service.getCost());
            preparedStatement.setInt(5, service.getMaxPeople());
            preparedStatement.setInt(6, service.getRentTypeId());
            preparedStatement.setInt(7, service.getServiceTypeId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
