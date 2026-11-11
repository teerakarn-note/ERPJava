package com.app.my_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.my_project.entity.ProductionlossEntity;
import com.app.my_project.repository.ProductionLossRepository;
import com.app.my_project.repository.ProductionRepository;

@RestController
@RequestMapping("/api/production-loss")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductionLossApiController {
    @Autowired
    private ProductionLossRepository productionLossRepository;

    @GetMapping("/{productionId}")
    public List<ProductionlossEntity> getAllProductionLosses(@PathVariable Long

    productionId) {
        return productionLossRepository.findAllByProductionIdOrderByIdDesc(productionId);
    }

    @PostMapping
    public ProductionlossEntity createProductionLoss(@RequestBody ProductionlossEntity productionLoss) {
        return productionLossRepository.save(productionLoss);
    }

    @PutMapping("/{id}")
    public ProductionlossEntity updateProductionLoss(@PathVariable Long id,
            @RequestBody ProductionlossEntity productionLoss) {
        ProductionlossEntity p = productionLossRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductionLoss Not found"));
        p.setProduction(productionLoss.getProduction());
        p.setRemark(productionLoss.getRemark());
        p.setQty(productionLoss.getQty());
        p.setCreateAt(productionLoss.getCreateAt());
        return productionLossRepository.save(p);
    }

    @DeleteMapping("/{id}")
    public void deleteProductionLoss(@PathVariable Long id) {
        productionLossRepository.deleteById(id);
    }

}
