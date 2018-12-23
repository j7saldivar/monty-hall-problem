package com.jorgesaldivar.config;

import com.jorgesaldivar.service.GameService;
import com.jorgesaldivar.service.impl.GameServiceImpl;

/**
 * Application Config. Setup application dependencies
 *
 * @author Jorge Saldivar
 */
public class SimulationConfig {

    private static final SimulationConfig INSTANCE = new SimulationConfig();
    private GameService gameService;

    private SimulationConfig() {
    }

    public static SimulationConfig getInstance() {
        return INSTANCE;
    }

    public GameService gameService() {
        synchronized (this) {
            if (null == gameService)
                gameService = new GameServiceImpl();
            return gameService;
        }
    }

}