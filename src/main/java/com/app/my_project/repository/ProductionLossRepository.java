package com.app.my_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.my_project.entity.ProductionlossEntity;

public interface ProductionLossRepository extends JpaRepository<ProductionlossEntity, Long> {
    List<ProductionlossEntity> findAllByProductionIdOrderByIdDesc(Long productionId);
}
