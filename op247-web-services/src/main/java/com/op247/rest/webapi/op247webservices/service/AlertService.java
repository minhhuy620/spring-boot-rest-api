package com.op247.rest.webapi.op247webservices.service;

import java.util.List;
import java.util.Optional;
import com.op247.rest.webapi.op247webservices.entity.Alerts;
import com.op247.rest.webapi.op247webservices.payload.PagedResponse;
import org.springframework.http.ResponseEntity;

public interface AlertService{
	PagedResponse<Alerts> getAllAlerts(int page, int size);
	ResponseEntity<Alerts> saveAlert(Alerts theAlert);
	Alerts updateAlerts(Alerts theAlert, int theId);
	ResponseEntity<Alerts> findByAlertId(int theId);
	void deleteByAlertId(int theId);

	Alerts getAlertByProjectId(int theId);
	Alerts getAlertByCustomerId(int theId);
	Alerts getAlertByServiceId(int theId);
	List<Alerts> searchByAlertName(String name);

	int countAlertByProjectId();
	int countAlertByCustomerId();
	int countAlertByServiceId();
}
