
	package com.cg.hospital.entity;

	import jakarta.persistence.*;
	import java.time.LocalDateTime;

	import com.fasterxml.jackson.annotation.JsonManagedReference;

	@Entity
	@Table(name = "stay")
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	public class Stay {

	    @Id
	    @Column(name = "StayID")
	    private int stayId;

	    @ManyToOne
	    @JoinColumn(name = "Patient", referencedColumnName = "SSN")
	    @JsonManagedReference
	    
	    private Patient patient;



	    @Column(name = "Room")
	    private int room;

	    @Column(name = "StayStart")
	    private LocalDateTime stayStart;

	    @Column(name = "StayEnd")
	    private LocalDateTime stayEnd;

	    // Getters and setters
	    public int getStayId() { return stayId; }
	    public void setStayId(int stayId) { this.stayId = stayId; }

	    public Patient getPatient() { return patient; }
	    public void setPatient(Patient patient) { this.patient = patient; }

	    public int getRoom() { return room; }
	    public void setRoom(int room) { this.room = room; }

	    public LocalDateTime getStayStart() { return stayStart; }
	    public void setStayStart(LocalDateTime stayStart) { this.stayStart = stayStart; }

	    public LocalDateTime getStayEnd() { return stayEnd; }
	    public void setStayEnd(LocalDateTime stayEnd) { this.stayEnd = stayEnd; }
	}


