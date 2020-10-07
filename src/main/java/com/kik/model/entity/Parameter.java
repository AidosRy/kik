package com.kik.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Builder
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Parameter extends BaseEntity{
    String name;

    @ManyToOne
    Product product;
}
