package com.mritunjay.spring.project.order.service.repository;

import com.mritunjay.spring.project.order.service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order,Long>{


}
