package com.msproperty.dao.repository;

import com.msproperty.dao.entity.PropertyEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long>, JpaSpecificationExecutor<PropertyEntity> {

//    @EntityGraph(attributePaths =
//            {"location", "placeType", "propertyType", "attributes", "categories"},
//            type = EntityGraph.EntityGraphType.FETCH)
//    List<PropertyEntity> findAll();

}
