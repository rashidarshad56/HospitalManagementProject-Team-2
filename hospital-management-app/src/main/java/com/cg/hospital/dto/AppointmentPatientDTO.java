package com.cg.hospital.dto;

import java.time.LocalDateTime;

public class AppointmentPatientDTO {
	    private int appointmentId;
	    private String patientName;
	    private String address;
	    private String phone;
	    private LocalDateTime starto;
	    private LocalDateTime endo;
		public LocalDateTime getStarto() {
			return starto;
		}
		public void setStarto(LocalDateTime starto) {
			this.starto = starto;
		}
		public LocalDateTime getEndo() {
			return endo;
		}
		public void setEndo(LocalDateTime endo) {
			this.endo = endo;
		}
		public int getAppointmentId() {
			return appointmentId;
		}
		public void setAppointmentId(int appointmentId) {
			this.appointmentId = appointmentId;
		}
		public String getPatientName() {
			return patientName;
		}
		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public AppointmentPatientDTO(int appointmentId, String patientName, String address, String phone, LocalDateTime starto,LocalDateTime endo) {
			super();
			this.appointmentId = appointmentId;
			this.patientName = patientName;
			this.address = address;
			this.phone = phone;
			this.starto = starto;
			this.endo = endo;
	}
}
