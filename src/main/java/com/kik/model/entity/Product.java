package com.kik.model.entity;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@SuperBuilder
@NoArgsConstructor
@Entity
public class Product extends BaseEntity{

    @ManyToOne
    Order order;

    @OneToMany
    List<Parameter> parameters;

    long price;
}
