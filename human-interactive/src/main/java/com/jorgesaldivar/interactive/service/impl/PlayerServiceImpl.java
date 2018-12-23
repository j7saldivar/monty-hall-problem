package com.jorgesaldivar.interactive.service.impl;

import com.jorgesaldivar.interactive.service.PlayerService;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

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

        String read = scanner.next();
        while (invalidNumber(read)) {
            System.out.print("\tInvalid door, please pick door (1, 2, or 3) : ");
            read = scanner.next();
        }

        return Integer.valueOf(read);
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

        String read = scanner.next();
        while (invalidInput(read)) {
            System.out.print("\n\tInvalid option, would you like to continue playing? ");
            read = scanner.next();
        }

        return BooleanUtils.toBoolean(read);

    }

    private boolean invalidNumber(String input) {
        return !NumberUtils.isDigits(input) || (Integer.valueOf(input) < 1 || Integer.valueOf(input) > 3);
    }

    private boolean invalidInput(String input) {
        return !"y".equalsIgnoreCase(StringUtils.left(input, 1))
                && !"n".equalsIgnoreCase(StringUtils.left(input, 1));
    }

}
