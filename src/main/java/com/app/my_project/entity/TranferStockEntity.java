package com.app.my_project.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class TranferStockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "from_store_id")
    private StoreEntity fromStore;

    @ManyToOne
    @JoinColumn(name = "to_store_id")
    private StoreEntity toStore;

    @ManyToOne
    @JoinColumn(name = "production_id")
    private ProductionEntity production;

    private Integer quantity;
    private String remark;
    private LocalDateTime createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StoreEntity getFromStore() {
        return fromStore;
    }

    public void setFromStore(StoreEntity fromStore) {
        this.fromStore = fromStore;
    }

    public StoreEntity getToStore() {
        return toStore;
    }

    public void setToStore(StoreEntity toStore) {
        this.toStore = toStore;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public ProductionEntity getProduction() {
        return production;
    }

    public void setProduction(ProductionEntity production) {
        this.production = production;
    }
}
