package com.jorgesaldivar.exception;

/**
 * {@link RuntimeException} for invalid door
 *
 * @author Jorge Saldivar
 */
public class DoorNotFoundException extends RuntimeException {

    public DoorNotFoundException(String message) {
        super(message);
    }

}
