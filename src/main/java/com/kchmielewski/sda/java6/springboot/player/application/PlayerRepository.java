package com.kchmielewski.sda.java6.springboot.player.application;

import com.kchmielewski.sda.java6.springboot.player.application.model.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
}
