package com.msproperty.dao.repository;

import com.msproperty.dao.entity.PlaceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceTypeRepository extends JpaRepository<PlaceTypeEntity, Long> {
}
