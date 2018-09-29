package com.ua.bird.farm.bird_farm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BirdListDto {

    @JsonProperty("bird_list")
    private List<BirdDto> birdDtos;
}
