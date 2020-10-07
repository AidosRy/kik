package com.kik.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@Table(name = "orders")
@Entity
public class Order extends BaseEntity{
}
