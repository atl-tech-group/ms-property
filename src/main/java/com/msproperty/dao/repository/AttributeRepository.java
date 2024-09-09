package com.msproperty.dao.repository;

import com.msproperty.dao.entity.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<AttributeEntity, Long> {
}
