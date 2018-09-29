package com.ua.bird.farm.bird_farm.services;


import com.ua.bird.farm.bird_farm.dto.BirdDto;
import com.ua.bird.farm.bird_farm.dto.BirdListDto;

import java.util.List;

public interface BirdService {

    BirdDto getOne(int name);

    List<BirdDto> getAllBirds();

    BirdListDto birdListDto();
}
