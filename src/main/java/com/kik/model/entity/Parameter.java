package com.kik.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@SuperBuilder
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Parameter extends BaseEntity{
    String name;

}
