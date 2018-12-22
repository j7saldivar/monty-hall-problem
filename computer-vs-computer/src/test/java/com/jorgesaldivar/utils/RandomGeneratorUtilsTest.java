package com.jorgesaldivar.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RandomGeneratorUtilsTest {

    private static final int LOWER_BOUND = 11;
    private static final int UPPER_BOUND = 15;

    @Test
    public void generate() {

        final int firstRandom = RandomGeneratorUtils.generate(LOWER_BOUND, UPPER_BOUND);
        Assert.assertTrue(initialCondition(firstRandom));

        final int secondRandom = RandomGeneratorUtils.generate(LOWER_BOUND, UPPER_BOUND, firstRandom);
        Assert.assertTrue(initialCondition(firstRandom) && excluded(secondRandom, firstRandom));

        final int thirdRandom = RandomGeneratorUtils.generate(LOWER_BOUND, UPPER_BOUND, firstRandom, secondRandom);
        Assert.assertTrue(initialCondition(firstRandom) && excluded(thirdRandom, firstRandom, secondRandom));

        final int fourthRandom = RandomGeneratorUtils.generate(LOWER_BOUND, UPPER_BOUND, firstRandom, secondRandom, thirdRandom);
        Assert.assertTrue(initialCondition(firstRandom) && excluded(fourthRandom, firstRandom, secondRandom, thirdRandom));

        final int fifthRandom = RandomGeneratorUtils.generate(LOWER_BOUND, UPPER_BOUND, firstRandom, secondRandom, thirdRandom, fourthRandom);
        Assert.assertTrue(initialCondition(firstRandom) && excluded(fifthRandom, firstRandom, secondRandom, thirdRandom, fourthRandom));

        verifyNoRepeatedNumber(firstRandom, secondRandom, thirdRandom, fourthRandom, fifthRandom);

    }

    private boolean initialCondition(int number) {
        return number >= LOWER_BOUND && number <= UPPER_BOUND;
    }

    private boolean excluded(Integer number, Integer... excluded) {
        return !Arrays.asList(excluded).contains(number);
    }

    private void verifyNoRepeatedNumber(Integer... numbers) {
        Set<Integer> crossCheckAbove = new HashSet<>(Arrays.asList(numbers));
        Assert.assertEquals(UPPER_BOUND - LOWER_BOUND + 1, crossCheckAbove.size());
    }

}