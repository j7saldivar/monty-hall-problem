package com.jorgesaldivar.service.impl;

import com.jorgesaldivar.helper.Door;
import com.jorgesaldivar.helper.Scenario;
import com.jorgesaldivar.service.GameService;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameServiceImplTest {

    private final GameService gameService = new GameServiceImpl();

    @Test
    public void stickWithDecision() {
        Door door = gameService.stickWithDecision(gameService.setupGame());
        Assert.assertNotNull(door);
    }

    @Test
    public void changeDecision() {
        Door door = gameService.changeDecision(gameService.setupGame());
        Assert.assertNotNull(door);
    }
}