package repository.service;

import model.service.Service;
import model.service.ServiceDTO;
import model.service.ServiceType;

import java.util.List;

public interface IServiceRepository {
    List<ServiceDTO> findAll();

    List<ServiceType> findServiceType();

//    void save(Service service);

    void saveVilla(Service service);

    void saveHouse(Service service);

    void saveRoom(Service service);
}
