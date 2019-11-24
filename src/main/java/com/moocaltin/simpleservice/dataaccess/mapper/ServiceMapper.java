package com.moocaltin.simpleservice.dataaccess.mapper;

import com.moocaltin.simpleservice.dataaccess.model.ServiceEntity;
import com.moocaltin.simpleservice.dataaccess.request.ServiceRequest;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

    public ServiceEntity map(ServiceRequest request) {
        return new ServiceEntity(
                request.getDevice(),
                request.getName(),
                request.getProducer(),
                request.getModel(),
                request.getType(),
                request.getTermDays(),
                request.getCost(),
                request.getImageUrl()
        );
    }

    public ServiceEntity map(Long id, ServiceRequest request) {
        return new ServiceEntity(
                id,
                request.getDevice(),
                request.getName(),
                request.getProducer(),
                request.getModel(),
                request.getType(),
                request.getTermDays(),
                request.getCost(),
                request.getImageUrl()
        );
    }
}
