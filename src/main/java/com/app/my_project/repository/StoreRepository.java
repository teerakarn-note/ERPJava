package com.app.my_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.my_project.entity.StoreEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long> {
    String SQL = """
                SELECT
                    id,
                    name,
                    (
                        SELECT SUM(production_log_entity.qty)
                        FROM production_log_entity
                        WHERE production_log_entity.production_id = production_entity.id
                    ) AS total_production_log,
                    (
                        SELECT SUM(productionloss_entity.qty)
                        FROM productionloss_entity
                        WHERE productionloss_entity.production_id = production_entity.id
                    ) AS total_production_loss
                    FROM production_entity
                    WHERE production_entity.id = :id
            """;

    @Query(value = SQL, nativeQuery = true)
    List<Object[]> findProductionSummary(@Param("id") Long id);
}
