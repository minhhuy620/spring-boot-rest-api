package com.op247.rest.webapi.op247webservices.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.op247.rest.webapi.op247webservices.payload.PagedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.op247.rest.webapi.op247webservices.dao.AlertRepository;
import com.op247.rest.webapi.op247webservices.entity.Alerts;

@Service
public class AlertsServiceImpl implements AlertService {
	@Autowired
	private AlertRepository alertRepository;

	@Override
	public PagedResponse<Alerts> getAllAlerts(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Alerts> alerts = alertRepository.findAll(pageable);
		List<Alerts> content = alerts.getNumberOfElements() == 0 ? Collections.emptyList() : alerts.getContent();
		return new PagedResponse<>(content, alerts.getNumber(), alerts.getSize(), alerts.getTotalElements(),
				alerts.getTotalPages(), alerts.isLast());
	}

	@Override
	public ResponseEntity<Alerts> saveAlert(Alerts theAlert) {
		Alerts alerts = alertRepository.save(theAlert);
		return new ResponseEntity<>(alerts, HttpStatus.CREATED);
	}
	@Override
	public ResponseEntity findByAlertId(int theId) {
		Optional<Alerts> alert = alertRepository.findById(theId);
		return new ResponseEntity(alert, HttpStatus.OK);
	}
	@Override
	public Alerts updateAlerts(Alerts theAlert, int theId) {
		Optional<Alerts> data = alertRepository.findById(theId);
		Alerts alert = null;
            if (data != null) {
                alert.setAlertName(theAlert.getAlertName());
                alert.setAlertLevel(theAlert.getAlertLevel());
                alert.setAlertType(theAlert.getAlertType());
                alert.setAlertMessage(theAlert.getAlertMessage());
                alert.setAlertStatus(theAlert.getAlertStatus());
				alert.setAlertCreatedTime(theAlert.getAlertCreatedTime());
//                alert.setAlertUpdatedTime(theAlert.getAlertUpdatedTime());
				alertRepository.save(alert);
            }
		return alert;
	}
	@Override
	public void deleteByAlertId(int theId) {
		alertRepository.deleteById(theId);
	}
	@Override
	public Alerts getAlertByProjectId(int theId) {
		return null;
	}
	@Override
	public Alerts getAlertByCustomerId(int theId) {
		return null;
	}
	@Override
	public Alerts getAlertByServiceId(int theId) {
		return null;
	}
	@Override
	public List<Alerts> searchByAlertName(String name) {
		return alertRepository.searchByAlertName(name);
	}
	@Override
	public int countAlertByProjectId() {
		return 0;
	}
	@Override
	public int countAlertByCustomerId() {
		return 0;
	}
	@Override
	public int countAlertByServiceId() {
		return 0;
	}
}
