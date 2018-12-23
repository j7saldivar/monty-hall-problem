package com.jorgesaldivar.service.impl;

import com.jorgesaldivar.helper.Door;
import com.jorgesaldivar.helper.Scenario;
import com.jorgesaldivar.service.GameService;
import com.jorgesaldivar.utils.RandomGeneratorUtils;

/**
 * {@link GameService} implementation
 *
 * @author Jorge Saldivar
 */
public class GameServiceImpl implements GameService {

    /**
     * Setup game
     *
     * @return
     */
    @Override
    public Scenario setupGame() {
        return new Scenario();
    }

    @Override
    public Door stickWithDecision(final Scenario scenario) {
        int pick = RandomGeneratorUtils.generate(1, 3);

        Door doorPicked = scenario.openDoor(pick);
        scenario.hostOpensOtherDoor(pick).hasPrize();
        return doorPicked;
    }

    @Override
    public Door changeDecision(final Scenario scenario) {
        int pick = RandomGeneratorUtils.generate(1, 3);

        int pickedDoor = scenario.openDoor(pick).doorNumber();
        int hostDoor = scenario.hostOpensOtherDoor(pick).doorNumber();
        int changeDecision = RandomGeneratorUtils.generate(1, 3, pickedDoor, hostDoor);
        return scenario.openDoor(changeDecision);
    }

}
