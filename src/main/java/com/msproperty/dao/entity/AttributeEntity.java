package com.msproperty.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "attribute")
public class AttributeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String attributeName;
    String description;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ToString.Exclude
    AttributeCategoryEntity attributeCategory;
}
