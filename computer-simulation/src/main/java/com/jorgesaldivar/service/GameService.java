package com.jorgesaldivar.service;

import com.jorgesaldivar.helper.Door;
import com.jorgesaldivar.helper.Scenario;

/**
 * <pre>
 * The game consist on 2 decisions.
 *      Sticking with the door, even though the host displays another not winning door
 *      Changing decision once host shows another not winning door
 *
 * </pre>
 *
 * @author Jorge Saldivar
 */
public interface GameService {

    /**
     * Setup game
     *
     * @return
     */
    Scenario setupGame();

    /**
     * stickWithDecision:
     * <pre>
     * Steps:
     *      1) You pick door
     *      2) Host picks other door and shows there is no prize in it
     *      3) You stick with decision by not changing doors
     * </pre>
     *
     * @param scenario
     * @return
     */
    Door stickWithDecision(Scenario scenario);

    /**
     * changeDecision:
     * <pre>
     * Steps:
     *      1) You pick door
     *      2) Host picks other door and shows there is no prize in it
     *      3) You change your decision and decide picking remaining door
     * </pre>
     *
     * @param scenario
     * @return
     */
    Door changeDecision(Scenario scenario);

}