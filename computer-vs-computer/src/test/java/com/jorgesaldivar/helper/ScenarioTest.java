package com.jorgesaldivar.helper;

import com.jorgesaldivar.exception.DoorNotFoundException;
import com.jorgesaldivar.utils.RandomGeneratorUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ScenarioTest {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 3;

    @Test
    public void openDoor_2DoorsWithoutPrize_1WithPrize() {

        Map<Boolean, Integer> hasPrize = new HashMap<>();

        Scenario scenario = new Scenario();
        for (int i = LOWER_BOUND; i <= UPPER_BOUND; i++)
            hasPrize.compute(scenario.openDoor(i).hasPrize(), (k, v) -> null == v ? 1 : v + 1);

        Assert.assertEquals(Integer.valueOf(1), hasPrize.get(Boolean.TRUE));
        Assert.assertEquals(Integer.valueOf(2), hasPrize.get(Boolean.FALSE));

    }

    @Test(expected = DoorNotFoundException.class)
    public void openDoor_InvalidLowerBound() {
        new Scenario().openDoor(LOWER_BOUND - 1);
    }

    @Test(expected = DoorNotFoundException.class)
    public void openDoor_InvalidUpperBound() {
        new Scenario().openDoor(UPPER_BOUND + 1);
    }

    @Test
    public void hostOpensOtherDoor_OpenDoorThenOtherDoor_OtherIsNotWinningDoor() {
        for (int i = 0; i < 10; i++)
            verifyOtherIsNotWinningDoor();
    }

    private void verifyOtherIsNotWinningDoor() {
        Scenario scenario = new Scenario();
        int pick = RandomGeneratorUtils.generate(LOWER_BOUND, UPPER_BOUND);
        scenario.openDoor(pick);
        Assert.assertFalse(scenario.hostOpensOtherDoor(pick).hasPrize());
    }

    @Test(expected = DoorNotFoundException.class)
    public void hostOpensOtherDoor_InvalidLowerBound() {
        new Scenario().hostOpensOtherDoor(LOWER_BOUND - 1);
    }

    @Test(expected = DoorNotFoundException.class)
    public void hostOpensOtherDoor_InvalidUpperBound() {
        new Scenario().hostOpensOtherDoor(UPPER_BOUND + 1);
    }

    @Test
    public void winningDoor_IfWinningDoorReturn_OtherwiseCheckPickedDoorDoesNotHavePrize() {
        for (int i = 0; i < 10; i++)
            openWinningOrOtherPickedDoor();
    }

    private void openWinningOrOtherPickedDoor() {

        int choice = RandomGeneratorUtils.generate(LOWER_BOUND, UPPER_BOUND);
        Scenario scenario = new Scenario();

        if (scenario.winningDoor().doorNumber() == choice)
            Assert.assertTrue(scenario.winningDoor().hasPrize());
        else
            Assert.assertFalse(scenario.openDoor(choice).hasPrize());

    }

}