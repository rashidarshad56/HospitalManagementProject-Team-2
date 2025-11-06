package com.cg.hospital.entity;

import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    private Integer roomNumber;

    private String roomType;

    private Boolean unavailable;

    private Integer blockFloor;

    private Integer blockCode;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "blockFloor", referencedColumnName = "blockFloor", insertable = false, updatable = false),
        @JoinColumn(name = "blockCode", referencedColumnName = "blockCode", insertable = false, updatable = false)
    })
    private Block block;

    public Room() {}

    public Room(Integer roomNumber, String roomType, Boolean unavailable, Integer blockFloor, Integer blockCode) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.unavailable = unavailable;
        this.blockFloor = blockFloor;
        this.blockCode = blockCode;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Boolean getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(Boolean unavailable) {
        this.unavailable = unavailable;
    }

    public Integer getBlockFloor() {
        return blockFloor;
    }

    public void setBlockFloor(Integer blockFloor) {
        this.blockFloor = blockFloor;
    }

    public Integer getBlockCode() {
        return blockCode;
    }

    public void setBlockCode(Integer blockCode) {
        this.blockCode = blockCode;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}