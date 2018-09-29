package com.ua.bird.farm.bird_farm.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class BirdEntity {

    @Id
    @GeneratedValue
    private long Id;
    @Column
    private String birdType;
    @Column
    private int pricePerUnit;
    @Column
    private String birdHeals;
    @Column
    private int weight;


}
