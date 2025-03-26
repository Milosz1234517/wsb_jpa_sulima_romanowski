package com.jpacourse.persistance.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne(targetEntity = DoctorEntity.class)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
	private DoctorEntity doctorEntity;

	@ManyToOne(targetEntity = PatientEntity.class)
	@JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
	private PatientEntity patientEntity;

	@OneToMany(targetEntity = MedicalTreatmentEntity.class, mappedBy = "visitEntity", cascade = CascadeType.REMOVE)
	private Collection<MedicalTreatmentEntity> medicalTreatmentEntities;

	public PatientEntity getPatientEntity() {
		return patientEntity;
	}

	public void setPatientEntity(PatientEntity patientEntity) {
		this.patientEntity = patientEntity;
	}

	public DoctorEntity getDoctorEntity() {
		return doctorEntity;
	}

	public void setDoctorEntity(DoctorEntity doctorEntity) {
		this.doctorEntity = doctorEntity;
	}

	public Collection<MedicalTreatmentEntity> getMedicalTreatmentEntities() {
		return medicalTreatmentEntities;
	}

	public void setMedicalTreatmentEntities(Collection<MedicalTreatmentEntity> medicalTreatmentEntities) {
		this.medicalTreatmentEntities = medicalTreatmentEntities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}
