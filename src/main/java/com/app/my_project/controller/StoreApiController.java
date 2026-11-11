package com.app.my_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.my_project.entity.StoreEntity;
import com.app.my_project.entity.StoreImportEntity;
import com.app.my_project.repository.StoreImportRepository;
import com.app.my_project.repository.StoreRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.my_project.entity.StoreEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/api/store")
@CrossOrigin(origins = "http://localhost:3000")
public class StoreApiController {
    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreImportRepository storeImportRepository;

    @GetMapping
    public List<StoreEntity> getStore() {
        return storeRepository.findAll();
    }

    @PostMapping
    public StoreEntity postStoreEntity(@RequestBody StoreEntity storeEntity) {

        return storeRepository.save(storeEntity);
    }

    @PutMapping("/{id}")
    public StoreEntity pubStore(@RequestBody StoreEntity storeEntity, @PathVariable Long id) {
        StoreEntity store = storeRepository.findById(id).orElseThrow(() -> new RuntimeException("store not found"));
        store.setName(storeEntity.getName());
        store.setAddress(storeEntity.getAddress());
        store.setRemark(storeEntity.getRemark());
        return storeRepository.save(store);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id) {
        storeRepository.deleteById(id);
    }

    @GetMapping("/data-for-import/{id}")
    public Map<String, Object> getDataForImpor(@PathVariable Long id) {
        List<Object[]> rows = storeRepository.findProductionSummary(id);
        Object[] row = rows.get(0);
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("id", row[0]);
        result.put("name", row[1]);
        result.put("totalProductionLog", row[2]);
        result.put("totalProductionLoss", row[3]);
        return result;
    }

    @PostMapping("/import")
    public StoreImportEntity importData(@RequestBody StoreImportEntity storeImportEntity) {
        return storeImportRepository.save(storeImportEntity);
    }

    @GetMapping("/import/{storeId}")
    public List<StoreImportEntity> getImportData(@PathVariable Long storeId) {
        return storeImportRepository.findByStore_Id(storeId);
    }

    @DeleteMapping("/import/{id}")
    public void deleteImportData(@PathVariable Long id) {
        storeImportRepository.deleteById(id);
    }
}
