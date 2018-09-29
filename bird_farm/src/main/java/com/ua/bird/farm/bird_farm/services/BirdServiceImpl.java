package com.ua.bird.farm.bird_farm.services;


import com.ua.bird.farm.bird_farm.dao.BirdEntity;
import com.ua.bird.farm.bird_farm.dao.repository.BirdRepository;
import com.ua.bird.farm.bird_farm.dto.BirdDto;
import com.ua.bird.farm.bird_farm.dto.BirdListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BirdServiceImpl implements BirdService {

    @Autowired
    private BirdRepository birdRepository;

    @Override
    public BirdDto getOne(int weight) {

        BirdEntity birdEntity = birdRepository.findByWeight(weight);

        BirdDto birdDto = new BirdDto();
        birdDto.setName(birdEntity.getBirdType());
        birdDto.setPricePerUnit(birdEntity.getPricePerUnit());

        return birdDto;
    }

    @Override
    public List<BirdDto> getAllBirds() {
        List<BirdDto> birdDtoList = new ArrayList<>();
        addBirdToList(birdDtoList);

        return birdDtoList;
    }

    @Override
    public BirdListDto birdListDto() {
        List<BirdDto> birdDtoList = new ArrayList<>();
        addBirdToList(birdDtoList);
        return new BirdListDto(birdDtoList);
    }

    private void addBirdToList(List<BirdDto> birdDtoList) {
        for (BirdEntity birdEntity : birdRepository.findAll()) {
            BirdDto birdDto = new BirdDto();
            birdDto.setName(birdEntity.getBirdType());
            birdDto.setPricePerUnit(birdEntity.getPricePerUnit());
            birdDtoList.add(birdDto);
        }
    }
}
