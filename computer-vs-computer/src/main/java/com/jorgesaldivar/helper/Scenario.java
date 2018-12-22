package com.jorgesaldivar.helper;

import com.jorgesaldivar.exception.DoorNotFoundException;
import com.jorgesaldivar.utils.RandomGeneratorUtils;

/**
 * <pre>
 * Represents the scenario of the game.
 * The  is hidden at the start of the game in a random door.
 * The game consist of the following actions:
 *      Player can open door
 *      Host can open other door (not a winning door)
 *      Retrieve the winning door
 *
 * </pre>
 *
 * @author Jorge Saldivar
 */
public class Scenario {

    private static final int FIRST_DOOR = 1;
    private static final int LAST_DOOR = 3;
    private final int doorWithPrize;
    private final Door[] doors;

    public Scenario() {
        this.doors = new Door[3];
        this.doorWithPrize = RandomGeneratorUtils.generate(FIRST_DOOR, LAST_DOOR);
        hidePrizeRandomDoor(doorWithPrize);
    }

    private void hidePrizeRandomDoor(final int prizeDoor) {

        doors[prizeDoor - 1] = new Door(prizeDoor, true);

        final int next = prizeDoor + 1 > LAST_DOOR ? FIRST_DOOR : prizeDoor + 1;
        doors[next - 1] = new Door(next, false);

        final int last = next + 1 > LAST_DOOR ? FIRST_DOOR : next + 1;
        doors[last - 1] = new Door(last, false);

    }

    public Door openDoor(final int choice) {
        if (choice < FIRST_DOOR || choice > LAST_DOOR)
            throw new DoorNotFoundException("Wrong door. Valid doors are 1, 2, or 3");
        return doors[choice - 1];
    }

    public Door hostOpensOtherDoor(final int choice) {
        if (choice < FIRST_DOOR || choice > LAST_DOOR)
            throw new DoorNotFoundException("Wrong door. Valid doors are 1, 2, or 3");

        int next = RandomGeneratorUtils.generate(1, 3, choice, doorWithPrize);
        return doors[next - 1];

    }

    public Door winningDoor() {
        return doors[doorWithPrize - 1];
    }

}