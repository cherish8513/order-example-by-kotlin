package com.carver.shopstudy.order.repository;

import com.carver.shopstudy.order.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
}