package com.app.my_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.my_project.entity.TranferStockEntity;

public interface TranferStockRepository extends JpaRepository<TranferStockEntity,Long>{
    List<TranferStockEntity> findByFromStoreId(Long fromStoreId);
    List<TranferStockEntity> findByToStoreId(Long toStoreId);
}
