package com.msproperty.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "property_type")
public class PropertyTypeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String typeName;

    @OneToMany(
            cascade = ALL,
            mappedBy = "propertyType"
    )
    @ToString.Exclude
    List<PropertyEntity> property;
}
