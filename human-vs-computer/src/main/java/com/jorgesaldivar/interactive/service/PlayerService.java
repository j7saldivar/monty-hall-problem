package com.jorgesaldivar.interactive.service;

/**
 * <pre>
 * The Game consist on player actions. The player can:
 *      Pick a door
 *      Stick or change door decision
 *
 * </pre>
 *
 * @author Jorge Saldivar
 */
public interface PlayerService {

    /**
     * Player picks a door
     *
     * @return
     */
    int pick();

    /**
     * The host will display another door without the prize,
     * the player could then decide sticking or changing door decision
     *
     * @return
     */
    boolean openOtherDoor();

    /**
     * Restarts the game
     *
     * @return
     */
    boolean continuePlaying();

}
