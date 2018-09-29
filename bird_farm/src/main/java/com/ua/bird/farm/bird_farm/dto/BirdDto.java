package com.ua.bird.farm.bird_farm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BirdDto {

    @JsonProperty
    private String name;
    @JsonProperty
    private long amount;
    @JsonProperty("price_per_unit")
    private int pricePerUnit;

}
