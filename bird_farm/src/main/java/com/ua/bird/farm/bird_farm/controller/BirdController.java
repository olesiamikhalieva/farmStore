package com.ua.bird.farm.bird_farm.controller;


import com.ua.bird.farm.bird_farm.dto.BirdDto;
import com.ua.bird.farm.bird_farm.dto.BirdListDto;
import com.ua.bird.farm.bird_farm.services.BirdService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController()
@RequestMapping("/bird")
@Log4j2
public class BirdController {
    @Autowired
    private BirdService birdService;

    @GetMapping("/one")
    public BirdListDto getAllBird() {
        try {
            BirdListDto birdDtos = birdService.birdListDto();
            log.info(" return all bird - ok {}", birdDtos);
            return birdDtos;
        } catch (Exception e) {
            throw new NoSuchElementException("exception can't get all birds");
        }
    }

    @GetMapping("/sec")
    public List<BirdDto> getAllBird2() {
        try {
            List<BirdDto> birdDtos = birdService.getAllBirds();
            log.info(" return all bird - ok {}", birdDtos);
            return birdDtos;
        } catch (Exception e) {
            throw new NoSuchElementException("exception can't get all birds");
        }
    }
}
