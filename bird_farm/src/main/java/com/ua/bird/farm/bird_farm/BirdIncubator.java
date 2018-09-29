package com.ua.bird.farm.bird_farm;


import com.ua.bird.farm.bird_farm.dao.BirdEntity;
import com.ua.bird.farm.bird_farm.dao.repository.BirdRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Log4j2
public class BirdIncubator {

    @Autowired
    private BirdRepository birdRepository;

    @PostConstruct
    public  void  incubator(){

        for (int i=0; i<=10; i++){
            BirdEntity birdEntity = new BirdEntity();
            birdEntity.setBirdHeals((i+23)+"");
            birdEntity.setBirdType("duck");
            birdEntity.setWeight(5+i);
            birdEntity.setPricePerUnit(25);
            birdRepository.save(birdEntity);

        }

        for (int i=0; i<=10; i++){
            BirdEntity birdEntity = new BirdEntity();
            birdEntity.setBirdHeals((i+30)+"");
            birdEntity.setBirdType("eagl");
            birdEntity.setWeight(10+i);
            birdEntity.setPricePerUnit(40);
            birdRepository.save(birdEntity);
            }

    }
}
