package com.kik.model.entity;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@AllArgsConstructor
@Table(name = "orders")
@Entity
public class Order extends BaseEntity{
}
