package com.msproperty.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
@Table(name = "place_type")
public class PlaceTypeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String place_type;

    @OneToMany(
            cascade = ALL,
            mappedBy = "placeType"
    )
    @ToString.Exclude
    List<PropertyEntity> property;
}
