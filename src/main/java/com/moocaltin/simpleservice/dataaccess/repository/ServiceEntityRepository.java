package com.moocaltin.simpleservice.dataaccess.repository;

import com.moocaltin.simpleservice.dataaccess.model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceEntityRepository extends JpaRepository<ServiceEntity, Long> {
}
