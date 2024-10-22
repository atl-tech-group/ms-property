package com.msproperty.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "property")
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    BigDecimal nightly_price;
    String property_name;
    Integer num_guests;
    Integer num_beds;
    Integer num_bedrooms;
    Integer num_bathrooms;
    Integer is_guest_favourite;
    String description;
    String address_line_1;
    String address_line_2;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ToString.Exclude
    @JsonBackReference // Prevent recursion
    LocationEntity location;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "place_type_id", referencedColumnName = "id")
    @ToString.Exclude
    @JsonBackReference // Prevent recursion
    PlaceTypeEntity placeType;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "property_type_id", referencedColumnName = "id")
    @ToString.Exclude
    @JsonBackReference // Prevent recursion
    PropertyTypeEntity propertyType;

    @ManyToMany(cascade = ALL)
    @JoinTable(
            name = "property_attribute",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id")
    )
    @ToString.Exclude
    @JsonBackReference // Prevent recursion
    private List<AttributeEntity> attributes;

    @ManyToMany(cascade = ALL)
    @JoinTable(
            name = "property_category",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @ToString.Exclude
    @JsonBackReference // Prevent recursion
    private List<CategoryEntity> categories;
}
