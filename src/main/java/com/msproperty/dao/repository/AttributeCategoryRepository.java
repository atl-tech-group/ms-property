package com.msproperty.dao.repository;

import com.msproperty.dao.entity.AttributeCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeCategoryRepository extends JpaRepository<AttributeCategoryEntity, Long> {
}
