package com.ua.store.store.services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.ua.store.store.dto.BirdDto;
import com.ua.store.store.dto.BirdListDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Log4j2
public class GetBirdFromFarmServices {

    private static final String FARM_ULR = "http://localhost:8081/bird";

    public List<BirdDto> getBirdFromFar() {
        RestTemplate restTemplate = new RestTemplate();

        BirdListDto birdListDto = restTemplate
                .getForObject(FARM_ULR + "/one", BirdListDto.class);

        log.info(" restTemplate result from Dto {}", birdListDto);


        List<BirdDto> birdDtos = new ArrayList<>();
        for (BirdDto birdDto : birdListDto.getBirdDtoList()) {
            birdDtos.add(birdDto);
        }
        return birdDtos;
    }


    public List<BirdDto> getBirdFromFar2() {
        RestTemplate restTemplate = new RestTemplate();

        String jsonInput = restTemplate
                .getForObject(FARM_ULR + "/sec", String.class);
        log.info(" restTemplate result from String {}", jsonInput);

        ObjectMapper mapper = new ObjectMapper();
        try {
            List<BirdDto> birdDtoList = mapper.readValue(jsonInput, new TypeReference<List<BirdDto>>() {
            });
            log.info("list bird Dto is {}", birdDtoList);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    public List<BirdDto> getBirdFromFar3() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonInput = restTemplate
                .getForObject(FARM_ULR + "/one", String.class);
        log.info(" restTemplate result from String {}", jsonInput);

        try {
            JsonNode rootNode= objectMapper.readTree(jsonInput);
            ArrayNode slaidsNode = (ArrayNode) rootNode.get("bird_list");
            Iterator<JsonNode> slaidsIterator = slaidsNode.elements();
            while (slaidsIterator.hasNext()) {
                JsonNode slaidNode = slaidsIterator.next();
                System.out.println(slaidNode.get("name"));
                }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    public List<BirdDto> getBirdFromFar4() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonInput = restTemplate
                .getForObject(FARM_ULR + "/sec", String.class);
        log.info(" restTemplate result from String {}", jsonInput);

        try {
            JsonNode rootNode= objectMapper.readTree(jsonInput);
            ArrayNode slaidsNode = (ArrayNode) rootNode;
            Iterator<JsonNode> slaidsIterator = slaidsNode.elements();
            while (slaidsIterator.hasNext()) {
                JsonNode slaidNode = slaidsIterator.next();
                System.out.println(slaidNode.get("name"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

}
