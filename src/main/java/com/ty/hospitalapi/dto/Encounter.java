package com.ty.hospitalapi.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime admit_date_time;
	private String reason;
	private String status;
	private LocalDateTime discharge_date_time;
	@ManyToOne
	@JoinColumn
	Branch branch;
	@ManyToOne
	@JoinColumn
	Person person;
	@JsonIgnore
	@OneToMany(mappedBy = "encounter")
	List<MedOrder> medOrders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public LocalDateTime getAdmit_date_time() {
		return admit_date_time;
	}

	public void setAdmit_date_time(LocalDateTime admit_date_time) {
		this.admit_date_time = admit_date_time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDischarge_date_time() {
		return discharge_date_time;
	}

	public void setDischarge_date_time(LocalDateTime discharge_date_time) {
		this.discharge_date_time = discharge_date_time;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	/*public List<Observation> getObservations() {
		return observations;
	}

	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}

	public List<MedOrder> getMedOrders() {
		return medOrders;
	}

	public void setMedOrders(List<MedOrder> medOrders) {
		this.medOrders = medOrders;
	}*/

}
