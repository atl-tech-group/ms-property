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
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "location")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String locationName;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ToString.Exclude
    CountryEntity country;

    @OneToMany(cascade = ALL, mappedBy = "location")
    @ToString.Exclude
    List<PropertyEntity> property;
}
