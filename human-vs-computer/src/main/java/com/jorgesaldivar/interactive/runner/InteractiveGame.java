package com.jorgesaldivar.interactive.runner;

import com.jorgesaldivar.helper.Door;
import com.jorgesaldivar.helper.Scenario;
import com.jorgesaldivar.interactive.service.PlayerService;
import com.jorgesaldivar.utils.RandomGeneratorUtils;

/**
 * Game start
 *
 * @author Jorge Saldivar
 */
@SuppressWarnings("squid:S106")
public class InteractiveGame {

    private final PlayerService playerService;

    public InteractiveGame(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void start() {

        do {
            final Scenario scenario = new Scenario();

            final int pick = playerService.pick();
            Door doorPicked = scenario.openDoor(pick);

            final Door hostDoor = scenario.hostOpensOtherDoor(pick);
            System.out.println(String.format("\t- Host opened door %d and %s", hostDoor.doorNumber(), translate(hostDoor.hasPrize())));

            if (playerService.openOtherDoor())
                doorPicked = scenario.openDoor(RandomGeneratorUtils.generate(1, 3, pick, hostDoor.doorNumber()));

            System.out.println(String.format("\t- You have opened door %d and %s", doorPicked.doorNumber(), translate(doorPicked.hasPrize())));

        } while (playerService.continuePlaying());
    }

    private String translate(final boolean prize) {
        return prize ? "has prize" : "has no prize";
    }

}