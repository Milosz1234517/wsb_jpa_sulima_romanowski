package com.jpacourse.persistance.entity;

import com.jpacourse.persistance.enums.TreatmentType;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	private TreatmentType type;

	@ManyToOne(targetEntity = VisitEntity.class)
	@JoinColumn(name = "visit_id", referencedColumnName = "id", nullable = false)
	private VisitEntity visitEntity;

	public VisitEntity getVisitEntity() {
		return visitEntity;
	}

	public void setVisitEntity(VisitEntity visitEntity) {
		this.visitEntity = visitEntity;
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

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

}
