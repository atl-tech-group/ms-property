package com.msproperty.dao.repository;

import com.msproperty.dao.entity.PropertyTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyTypeRepository extends JpaRepository<PropertyTypeEntity, Long> {
}
