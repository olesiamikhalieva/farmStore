package com.ua.bird.farm.bird_farm.dao.repository;

import com.ua.bird.farm.bird_farm.dao.BirdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<BirdEntity, Long>{

    BirdEntity findByWeight(int weight);
}
