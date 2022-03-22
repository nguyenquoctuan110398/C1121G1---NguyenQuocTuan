package service.service.impl;

import model.service.Service;
import model.service.ServiceDTO;
import model.service.ServiceType;
import repository.service.IServiceRepository;
import repository.service.impl.ServiceRepository;
import service.service.IServiceService;

import java.util.List;

public class ServiceService implements IServiceService {

    private IServiceRepository iServiceRepository = new ServiceRepository();

    @Override
    public List<ServiceDTO> findAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public List<ServiceType> findServiceType() {
        return iServiceRepository.findServiceType();
    }

//    @Override
//    public void save(Service service) {
//        iServiceRepository.save(service);
//    }

    @Override
    public void saveVilla(Service service) {
        iServiceRepository.saveVilla(service);
    }

    @Override
    public void saveHouse(Service service) {
        iServiceRepository.saveHouse(service);
    }

    @Override
    public void saveRoom(Service service) {
        iServiceRepository.saveRoom(service);
    }
}
