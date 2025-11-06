package com.cg.hospital.entity;

import jakarta.persistence.*;

@Entity
@IdClass(BlockId.class)
public class Block {

    @Id
    private Integer blockFloor;

    @Id
    private Integer blockCode;

    public Block() {}

    public Block(Integer blockFloor, Integer blockCode) {
        this.blockFloor = blockFloor;
        this.blockCode = blockCode;
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
}