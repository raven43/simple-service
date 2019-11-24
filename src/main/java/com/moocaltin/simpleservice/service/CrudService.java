package com.moocaltin.simpleservice.service;

import com.moocaltin.simpleservice.dataaccess.mapper.ServiceMapper;
import com.moocaltin.simpleservice.dataaccess.model.ServiceEntity;
import com.moocaltin.simpleservice.dataaccess.repository.ServiceEntityRepository;
import com.moocaltin.simpleservice.dataaccess.request.ServiceRequest;
import com.moocaltin.simpleservice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {

    private final ServiceEntityRepository repository;
    private final ServiceMapper serviceMapper;

    @Autowired
    public CrudService(ServiceEntityRepository repository,
                       ServiceMapper serviceMapper) {
        this.repository = repository;
        this.serviceMapper = serviceMapper;
    }

    public List<ServiceEntity> getServices() {
        return repository.findAll();
    }

    public ServiceEntity createNewService(ServiceRequest service) {
        return repository.save(serviceMapper.map(service));
    }

    public ServiceEntity updateExistingService(Long id, ServiceRequest service) {
        getById(id);
        return repository.save(serviceMapper.map(id, service));
    }

    public ServiceEntity getById(Long id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public ServiceEntity deleteService(Long id) {
        ServiceEntity serviceEntity = getById(id);
        repository.deleteById(id);
        return serviceEntity;
    }
}
