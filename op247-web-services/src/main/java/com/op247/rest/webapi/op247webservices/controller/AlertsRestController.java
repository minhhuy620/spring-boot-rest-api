package com.op247.rest.webapi.op247webservices.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.op247.rest.webapi.op247webservices.payload.PagedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.op247.rest.webapi.op247webservices.entity.Alerts;
import com.op247.rest.webapi.op247webservices.payload.ApiResponse;
import com.op247.rest.webapi.op247webservices.service.AlertService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/op247-api")
public class AlertsRestController {
    private ApiResponse res;

    @Autowired
    private AlertService alertService;

    @GetMapping("/alerts")
    public ApiResponse getAllAlerts(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int size) {
        PagedResponse<Alerts> data = alertService.getAllAlerts(page, size);
        if (data != null) {
            res = new ApiResponse(true,null,HttpStatus.OK,data);
        } else {
            res.setSuccess(false);
        }
        return res;
    }

    @GetMapping("/alerts/{id}")
    public ApiResponse getAlertById(@PathVariable(value = "id") int alertId) {
        ResponseEntity<Alerts> alert = alertService.findByAlertId(alertId);
        if (alert != null) {
            res = new ApiResponse(true,"Find this alert id - " + alertId,HttpStatus.OK,alert);
        } else {
            res.setMessage("Did not find this alert id - " + alertId);
            res.setSuccess(false);
        }
        return res;
    }

    @PostMapping("/alerts")
    public ApiResponse createUser(@RequestBody Alerts alert) {
        try {
            alertService.saveAlert(alert);
            res = new ApiResponse(true,"Add alert success",HttpStatus.CREATED,alert);
        } catch (Exception ex) {
            res.setMessage(ex.getMessage());
            res.setSuccess(false);
        }
        return res;
    }

    @PutMapping("/alerts/{id}")
    public ApiResponse updateAlert(@RequestBody Alerts alertDetail, @PathVariable("id") int alertId) {
       Alerts alert = alertService.updateAlerts(alertDetail,alertId);
        if (alert != null) {
            res = new ApiResponse(true,"Update success",HttpStatus.OK,alert);
            res.setSuccess(true);
        } else {
            res.setMessage("Did not find alert id - " + alertId);
            res.setSuccess(false);
            res.setStatus(HttpStatus.OK);
        }
        return res;
    }

    @DeleteMapping("/alerts/{id}")
    public ApiResponse deleteAlert(@PathVariable("id") int alertId) {
        ResponseEntity<Alerts> data = alertService.findByAlertId(alertId);
        if (data != null) {
            alertService.deleteByAlertId(alertId);
            res.setSuccess(true);
        } else {
            res.setMessage("Delete success");
            res.setSuccess(false);
        }
        return res;
    }

    @GetMapping("/alerts/search")
    public ApiResponse searchAlertName(@RequestParam("name") String name) {
        List<Alerts> alert = alertService.searchByAlertName(name);
        if (alert != null) {
            res = new ApiResponse(true,"Find this alert name - " + name,HttpStatus.OK,alert);
        } else {
            res.setMessage("Did not find alert name - " + name);
            res.setSuccess(false);
        }
        return res;
    }


    @GetMapping("/alerts/project")
    public ApiResponse getAlertByProjectId(@RequestParam("id") int projectId) {
        Alerts data = alertService.getAlertByProjectId(projectId);
        if (data != null) {
            res.setData(data);
            res.setSuccess(true);
            res.setMessage("Find this project id - " + projectId);
            res.setStatus(HttpStatus.OK);

        } else {
            res.setMessage("Did not find project id - " + projectId);
            res.setSuccess(false);
            res.setStatus(HttpStatus.OK);
        }
        return res;
    }

    @GetMapping("/alerts/customer")
    public ApiResponse getAlertByCustomerId(@RequestParam("id") int customerId) {
        Alerts data = alertService.getAlertByCustomerId(customerId);
        if (data != null) {
            res.setData(data);
            res.setSuccess(true);
            res.setMessage("Find this customer id - " + customerId);
            res.setStatus(HttpStatus.OK);

        } else {
            res.setMessage("Did not find customer id - " + customerId);
            res.setSuccess(false);
            res.setStatus(HttpStatus.OK);
        }
        return res;
    }

    @GetMapping("/alerts/service")
    public ApiResponse getAlertByServiceId(@RequestParam("id") int serviceId) {
        Alerts data = alertService.getAlertByServiceId(serviceId);
        if (data != null) {
            res.setData(data);
            res.setSuccess(true);
            res.setMessage("Find this service id - " + serviceId);
            res.setStatus(HttpStatus.OK);

        } else {
            res.setMessage("Did not find service id - " + serviceId);
            res.setSuccess(false);
            res.setStatus(HttpStatus.OK);
        }
        return res;
    }

    @GetMapping("/alerts/count_project_id")
    public ApiResponse countAlertByProjectId() {
        int data = alertService.countAlertByProjectId();
        if (data != 0) {
            res.setData(data);
            res.setStatus(HttpStatus.OK);
            res.setSuccess(true);
        } else {
            res.setSuccess(false);
        }
        return res;
    }

    @GetMapping("/alerts/count_customer_id")
    public ApiResponse countAlertByCustomerId() {
        int data = alertService.countAlertByCustomerId();
        if (data != 0) {
            res.setData(data);
            res.setStatus(HttpStatus.OK);
            res.setSuccess(true);
        } else {
            res.setSuccess(false);
        }
        return res;
    }

    @GetMapping("/alerts/count_service_id")
    public ApiResponse countAlertByServiceId() {
        int data = alertService.countAlertByServiceId();
        if (data != 0) {
            res.setData(data);
            res.setStatus(HttpStatus.OK);
            res.setSuccess(true);
        } else {
            res.setSuccess(false);
        }
        return res;
    }
}
