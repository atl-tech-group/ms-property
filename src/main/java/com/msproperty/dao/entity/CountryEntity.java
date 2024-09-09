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
@Builder
@Table(name = "country")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String countryName;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @ToString.Exclude
    RegionEntity region;

    @OneToMany(mappedBy = "country", cascade = ALL)
    @ToString.Exclude
    List<LocationEntity> location;
}
