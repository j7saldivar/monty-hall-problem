package com.jorgesaldivar.interactive.service.impl;

import com.jorgesaldivar.interactive.service.PlayerService;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * {@link PlayerService} implementation
 *
 * @author Jorge Saldivar
 */
@SuppressWarnings("squid:S106")
public class PlayerServiceImpl implements PlayerService {

    private final Scanner scanner;

    public PlayerServiceImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int pick() {
        System.out.println();
        System.out.print("Pick door (1, 2, or 3) : ");

        int pick = -1;
        while (!scanner.hasNextInt() || ((pick = scanner.nextInt()) > 3 || pick < 1)) {
            System.out.print("\tInvalid door, please pick door (1, 2, or 3) : ");
        }

        return pick > -1 ? pick : scanner.nextInt();
    }

    @Override
    public boolean openOtherDoor() {
        System.out.print("\n\tWould you like to open another door? (yes or no) ");

        String read = scanner.next();
        while (invalidInput(read)) {
            System.out.print("\n\tInvalid option, would you like to open another door? ");
            read = scanner.next();
        }

        return BooleanUtils.toBoolean(read);
    }

    @Override
    public boolean continuePlaying() {
        System.out.print("\n\tWould you like to continue playing? ");
        String input = scanner.next();

        return invalidInput(input) || BooleanUtils.toBoolean(input);
    }

    private boolean invalidInput(String input) {
        return !"y".equalsIgnoreCase(StringUtils.left(input, 1))
                && !"n".equalsIgnoreCase(StringUtils.left(input, 1));
    }

}
