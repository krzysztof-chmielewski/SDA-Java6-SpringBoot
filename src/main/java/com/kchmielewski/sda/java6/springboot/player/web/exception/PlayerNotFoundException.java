package com.kchmielewski.sda.java6.springboot.player.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Integer id) {
        super("Player with " + id + " not found.");
    }
}
