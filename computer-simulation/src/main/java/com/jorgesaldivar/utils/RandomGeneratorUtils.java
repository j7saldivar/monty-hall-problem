package com.jorgesaldivar.utils;

import java.util.Arrays;
import java.util.Random;

/**
 * Generates random numbers utility
 *
 * @author Jorge Saldivar
 */
public class RandomGeneratorUtils {

    private static final Random RANDOM = new Random();

    private RandomGeneratorUtils() {
    }

    /**
     * Generates random numbers.
     * Lower and upper bound are inclusive. Excluding numbers can also be provided as an optional parameter.
     *
     * @param lowerBoundInclusive
     * @param upperBoundInclusive
     * @param excludeNumbers
     * @return
     */
    public static int generate(int lowerBoundInclusive, int upperBoundInclusive, Integer... excludeNumbers) {
        Integer random = RANDOM.nextInt((upperBoundInclusive - lowerBoundInclusive) + 1) + lowerBoundInclusive;
        if (Arrays.asList(excludeNumbers).contains(random))
            random = generate(lowerBoundInclusive, upperBoundInclusive, excludeNumbers);
        return random;
    }

}