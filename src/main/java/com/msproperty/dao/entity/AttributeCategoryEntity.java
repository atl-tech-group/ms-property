package com.msproperty.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "attribute_category")
public class AttributeCategoryEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String category_name;

    @OneToMany(
            fetch = LAZY,
            cascade = ALL,
            mappedBy = "attributeCategory"
    )
    @ToString.Exclude
    List<AttributeEntity> attribute;
}
