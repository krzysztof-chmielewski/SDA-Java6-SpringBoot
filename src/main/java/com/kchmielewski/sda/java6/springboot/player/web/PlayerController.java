package com.kchmielewski.sda.java6.springboot.player.web;

import com.kchmielewski.sda.java6.springboot.player.application.PlayerDto;
import com.kchmielewski.sda.java6.springboot.player.application.PlayerService;
import com.kchmielewski.sda.java6.springboot.player.web.exception.PlayerNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("players")
@RestController
public class PlayerController {
    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<PlayerDto> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PlayerDto one(@PathVariable Integer id) {
        return service.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
    }

}
