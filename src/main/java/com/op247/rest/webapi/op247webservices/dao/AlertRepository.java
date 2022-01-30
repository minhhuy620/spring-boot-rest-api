package com.op247.rest.webapi.op247webservices.dao;

import java.util.List;
import com.op247.rest.webapi.op247webservices.entity.Alerts;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<Alerts, Integer> {
    Alerts getAlertByProjectId(int theId);

    Alerts getAlertByCustomerId(int theId);

    Alerts getAlertByServiceId(int theId);
    @Query(value = "select * from alerts a where a.alert_name like %:name%", nativeQuery = true)
    List<Alerts> searchByAlertName(String name);

    @Query(value = "select count(project_id) from alerts", nativeQuery = true)
    int countAlertByProjectId();

    @Query(value = "select count(distinct customer_id) from alerts", nativeQuery = true)
    int countAlertByCustomerId();

    @Query(value = "select count(distinct service_id) from alerts", nativeQuery = true)
    int countAlertByServiceId();

}
