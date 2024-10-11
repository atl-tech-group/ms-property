package com.msproperty.utility;


import com.msproperty.dao.entity.PropertyEntity;
import com.msproperty.model.criteria.UserCriteria;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import static com.msproperty.utility.PredicateUtil.applyLikePattern;


@AllArgsConstructor
public class UserSpecification implements Specification<PropertyEntity> {
    private UserCriteria userCriteria;

    @Override
    public Predicate toPredicate(Root<PropertyEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        var predicates = PredicateUtil.builder()
                .addNullSafety(userCriteria.getPropertyName(),
                        birthplace -> cb.like(root.get("property_name"), applyLikePattern(birthplace)))
                .build();

        return cb.and(predicates);
    }
}
