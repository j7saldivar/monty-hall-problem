package com.jorgesaldivar.interactive.config;

import com.jorgesaldivar.interactive.service.PlayerService;
import com.jorgesaldivar.interactive.service.impl.PlayerServiceImpl;

import java.util.Scanner;

/**
 * Application Config. Setup application dependencies
 *
 * @author Jorge Saldivar
 */
public class InteractiveConfig {

    private static final InteractiveConfig INSTANCE = new InteractiveConfig();
    private PlayerService playerService;

    private InteractiveConfig() {
    }

    public static InteractiveConfig getInstance() {
        return INSTANCE;
    }

    public PlayerService playerService() {
        synchronized (this) {
            if (null == playerService)
                playerService = new PlayerServiceImpl(new Scanner(System.in));
            return playerService;
        }
    }

}
