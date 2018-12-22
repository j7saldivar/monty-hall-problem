package com.jorgesaldivar.helper;

/**
 * <pre>
 * Represents Door having :
 *      Door number
 *      Prize (Goat = false or Car = true)
 * </pre>
 *
 * @author Jorge Saldivar
 */
public class Door {

    private final int doorNumber;
    private final boolean prize;

    Door(int doorNumber, boolean prize) {
        this.doorNumber = doorNumber;
        this.prize = prize;
    }

    public int doorNumber() {
        return doorNumber;
    }

    public boolean hasPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return prize ?
                String.format("Door %s has prize", doorNumber) :
                String.format("Door %s doesn't have prize", doorNumber);
    }
}