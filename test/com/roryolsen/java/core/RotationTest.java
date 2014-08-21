package com.roryolsen.java.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by roryolsen on 8/20/14.
 */
public class RotationTest {

    @Test
    public void testRotation() {
        Assert.assertEquals(new Coordinate(0,1), new Rotation(1).rotateClockwise(new Coordinate(-1, 0)));
        Assert.assertEquals(new Coordinate(2,2), new Rotation(2).rotateClockwise(new Coordinate(-2, -2)));
        Assert.assertEquals(new Coordinate(0,0), new Rotation(2).rotateClockwise(new Coordinate(0, 0)));
        Assert.assertEquals(new Coordinate(2,2), new Rotation(0).rotateClockwise(new Coordinate(2, 2)));
    }
}
