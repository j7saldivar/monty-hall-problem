package com.jorgesaldivar;

import com.jorgesaldivar.config.SimulationConfig;
import com.jorgesaldivar.runner.Game;

/**
 * Monty Hall Problem
 *
 * @author Jorge Saldivar
 */
public class MontyHallProblemApplication {

    public static void main(String[] args) {
        new Game
                (SimulationConfig.getInstance().gameService())
                .start();
    }

}