package com.mritunjay.spring.training.project.inventory.service.repository;

import com.mritunjay.spring.training.project.inventory.service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository <Inventory,Long>{
}
