package com.jorgesaldivar.interactive;

import com.jorgesaldivar.interactive.config.InteractiveApplicationConfig;
import com.jorgesaldivar.interactive.runner.InteractiveGame;

/**
 * Monty Hall Problem
 *
 * @author Jorge Saldivar
 */
public class MontyHallInteractiveApplication {

    public static void main(String[] args) {
        new InteractiveGame
                (InteractiveApplicationConfig.getInstance().playerService())
                .start();
    }
}
