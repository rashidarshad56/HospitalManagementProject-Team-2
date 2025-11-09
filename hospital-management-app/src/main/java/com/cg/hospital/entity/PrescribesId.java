package com.cg.hospital.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class PrescribesId implements Serializable {

    private static final long serialVersionUID = 1L;

    private int patient;
    private Integer medication;
    private LocalDateTime date;

    public int getPatient() {
		return patient;
	}

	public void setPatient(int patient) {
		this.patient = patient;
	}

	public Integer getMedication() {
        return medication;
    }

    public void setMedication(Integer medication) {
        this.medication = medication;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrescribesId)) return false;
        PrescribesId that = (PrescribesId) o;
        return Objects.equals(patient, that.patient) &&
               Objects.equals(medication, that.medication) &&
               Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, medication, date);
    }
}