package com.jorgesaldivar.runner;

import com.jorgesaldivar.helper.Door;
import com.jorgesaldivar.service.GameService;
import com.jorgesaldivar.service.impl.GameServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Start of game
 *
 * @author Jorge Saldivar
 */
@SuppressWarnings("squid:S106")
public class Game {

    private static final int TIMES_PLAYED = 1_000_000;
    private final GameService gameService;

    public Game(GameService gameService) {
        this.gameService = gameService;
    }

    public void start() {

        final List<Door> stickWithDecision = new ArrayList<>();
        final List<Door> changeDecision = new ArrayList<>();
        IntStream.range(0, TIMES_PLAYED)
                .sequential()
                .forEach(i -> {
                    stickWithDecision.add(gameService.stickWithDecision(gameService.setupGame()));
                    changeDecision.add(gameService.changeDecision(gameService.setupGame()));
                });

        final Map<Boolean, Long> stickWithDecisionResults = results(stickWithDecision);
        final Map<Boolean, Long> changeDecisionResults = results(changeDecision);

        printResults("Stick with decision", stickWithDecisionResults);
        printResults("Change decision", changeDecisionResults);

    }

    private Map<Boolean, Long> results(final List<Door> decision) {
        return decision
                .stream()
                .collect(Collectors.groupingBy(Door::hasPrize,
                        Collectors.counting()));
    }

    private void printResults(final String message, final Map<Boolean, Long> results) {

        System.out.println(message);
        results.forEach((k, v) ->
                System.out.println("\t" + translateResults(k) + " - " + String.format("%.2f", (double) v / TIMES_PLAYED * 100)));
        System.out.println();

    }

    private String translateResults(final boolean results) {
        return results ? "Won" : "Lost";
    }

}