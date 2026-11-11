package com.app.my_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.my_project.repository.TranferStockRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import com.app.my_project.entity.TranferStockEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/transfer-stock")
public class TranferStockApiController {
    @Autowired
    private TranferStockRepository tranferStockRepository;

    @GetMapping
    public List<TranferStockEntity> list() {
        return tranferStockRepository.findAll();
    }

    @PostMapping
    public TranferStockEntity create(@RequestBody TranferStockEntity transferStock) {
        return tranferStockRepository.save(transferStock);
    }

    @PutMapping("/{id}")
    public TranferStockEntity update(
            @PathVariable Long id,
            @RequestBody TranferStockEntity transferStock) {
        TranferStockEntity transferStockEntity = tranferStockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransferStock not found"));
        transferStockEntity.setFromStore(transferStock.getFromStore());
        transferStockEntity.setToStore(transferStock.getToStore());
        transferStockEntity.setQuantity(transferStock.getQuantity());
        transferStockEntity.setRemark(transferStock.getRemark());
        transferStockEntity.setCreateAt(transferStock.getCreateAt());
        transferStockEntity.setProduction(transferStock.getProduction());

        return tranferStockRepository.save(transferStockEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tranferStockRepository.deleteById(id);
    }
}