package com.app.my_project.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class ProductionLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // relatioin database
    @ManyToOne
    @JoinColumn(name = "production_id")

    private ProductionEntity production;
    // วันที่ผลิต
    private LocalDateTime createAt;
    // เก็บหมายเหตุ
    private String remark;
    // เก็บจำนวน
    private int qty;

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductionEntity getProduction() {
        return production;
    }

    public void setProduction(ProductionEntity production) {
        this.production = production;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
