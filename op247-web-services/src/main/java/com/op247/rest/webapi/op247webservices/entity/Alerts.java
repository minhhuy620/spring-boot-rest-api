package com.op247.rest.webapi.op247webservices.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "alerts")
public class Alerts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "alert_name")
	private String alertName;

	@Column(name = "alert_level")
	private String alertLevel;

	@Column(name = "alert_type")
	private String alertType;

	@Column(name = "alert_message")
	private String alertMessage;

	@Column(name = "alert_status")
	private String alertStatus;

	@Column(name = "created_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss a")
	@Temporal(TemporalType.TIMESTAMP)
	private Date alertCreatedTime;

	@Column(name = "updated_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss a")
	@Temporal(TemporalType.TIMESTAMP)
	private Date alertUpdatedTime;

	@Column(name = "project_id")
	private int projectId;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "service_id")
	private int serviceId;

}
