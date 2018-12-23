package com.jorgesaldivar.helper;

import org.junit.Assert;
import org.junit.Test;

public class DoorTest {

    @Test
    public void toString_CheckExpectedMessages() {

        Assert.assertEquals("Door 1 doesn't have prize", new Door(1, false).toString());
        Assert.assertEquals("Door 3 has prize", new Door(3, true).toString());

    }

}