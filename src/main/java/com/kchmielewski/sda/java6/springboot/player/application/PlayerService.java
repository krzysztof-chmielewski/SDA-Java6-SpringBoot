package com.kchmielewski.sda.java6.springboot.player.application;

import com.kchmielewski.sda.java6.springboot.player.application.model.PlayerEntity;
import com.kchmielewski.sda.java6.springboot.player.application.model.TeamEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public Optional<PlayerDto> findById(Integer id) {
        return repository.findById(id).map(this::toDto);
    }

    public List<PlayerDto> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private PlayerDto toDto(PlayerEntity entity) {
        return new PlayerDto(entity.getId(), entity.getName(), entity.getSurname(), entity.getTeam().map(TeamEntity::getName).orElse(""));
    }
}
