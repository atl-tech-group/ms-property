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
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "region")
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String regionName;

    @OneToMany(
            cascade = ALL,
            mappedBy = "region"
    )
    @ToString.Exclude
    List<CountryEntity> country;
}
