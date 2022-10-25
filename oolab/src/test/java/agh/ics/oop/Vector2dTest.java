package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        assertEquals("(0,0)", new Vector2d(0, 0).toString());
        assertEquals("(545443,123123)", new Vector2d(545443, 123123).toString());
        assertEquals("(999999999,999999999)", new Vector2d(999999999, 999999999).toString());
        assertEquals("(-13,0)", new Vector2d(-13, 0).toString());
        assertEquals("(-1354535435,234234324)", new Vector2d(-1354535435, 234234324).toString());
        assertEquals("(234234,-12312323)", new Vector2d(234234, -12312323).toString());
        assertEquals("(-1234567890,-987654321)", new Vector2d(-1234567890, -987654321).toString());
    }

    @Test
    void precedes() {
        Vector2d zeroVector = new Vector2d(0, 0);
        assertTrue(zeroVector.precedes(zeroVector));
        assertTrue(zeroVector.precedes(new Vector2d(0, 0)));
        assertTrue(zeroVector.precedes(new Vector2d(1, 1)));
        assertTrue(zeroVector.precedes(new Vector2d(0, 1)));
        assertTrue(zeroVector.precedes(new Vector2d(1, 0)));
        assertTrue(new Vector2d(-10, -10).precedes(new Vector2d(10, 10)));
        assertTrue(new Vector2d(12345, 12345).precedes(new Vector2d(123456, 123456)));

        assertFalse(new Vector2d(1, 1).precedes(new Vector2d(0, 0)));
        assertFalse(new Vector2d(0, 0).precedes(new Vector2d(-1, -1)));
        assertFalse(new Vector2d(-8888, 8888).precedes(new Vector2d(0, 0)));
        assertFalse(new Vector2d(99, 99).precedes(new Vector2d(-6, -6)));
    }

    @Test
    void follows() {
        Vector2d vector = new Vector2d(100, 100);
        assertTrue(vector.follows(vector));
        assertTrue(vector.follows(new Vector2d(0, 0)));
        assertTrue(vector.follows(new Vector2d(-1234, -1234)));
        assertTrue(new Vector2d(0, 0).follows(new Vector2d(-1234, -1234)));

        assertFalse(vector.follows(new Vector2d(101, 101)));
        assertFalse(vector.follows(new Vector2d(123, -6)));
        assertFalse(vector.follows(new Vector2d(1234567, 1234567)));
        assertFalse(new Vector2d(0, 0).follows(new Vector2d(1, 0)));
    }

    @Test
    void add() {
        Vector2d zeroVector = new Vector2d(0, 0);
        assertEquals(zeroVector, zeroVector.add(zeroVector));
        assertEquals(new Vector2d(2, 8), zeroVector.add(new Vector2d(2, 8)));
        assertEquals(new Vector2d(-5, 9), zeroVector.add(new Vector2d(-5, 9)));
        assertEquals(new Vector2d(-5, 9).add(new Vector2d(1, 2))
                , new Vector2d(1, 2).add(new Vector2d(-5, 9)));

        Assertions.assertNotEquals(new Vector2d(5, 9), zeroVector.add(new Vector2d(-5, 9)));
        Assertions.assertNotEquals(new Vector2d(1, 2), zeroVector.add(new Vector2d(1234, 87)));
    }

    @Test
    void subtract() {
        Vector2d zeroVector = new Vector2d(0, 0);
        assertEquals(zeroVector, zeroVector.subtract(zeroVector));
        Vector2d vector = new Vector2d(5, -5);
        assertEquals(zeroVector, vector.subtract(vector));
        assertEquals(zeroVector, new Vector2d(5, -5).subtract(new Vector2d(5, -5)));
        assertEquals(new Vector2d(6, -7), new Vector2d(1, 2).subtract(new Vector2d(-5, 9)));


        Assertions.assertNotEquals(new Vector2d(1, 2).subtract(new Vector2d(-5, 9)),
                new Vector2d(-5, 9).subtract(new Vector2d(1, 2)));

    }

    @Test
    void upperRight() {
        Vector2d zeroVector = new Vector2d(0, 0);
        assertEquals(zeroVector, zeroVector.upperRight(zeroVector));
        assertEquals(zeroVector, zeroVector.upperRight(new Vector2d(-5, -45)));
        assertEquals(new Vector2d(5, 5), zeroVector.upperRight(new Vector2d(5, 5)));
        assertEquals(new Vector2d(0, 5), zeroVector.upperRight(new Vector2d(-5, 5)));
        assertEquals(new Vector2d(19, 8), new Vector2d(19, 8).upperRight(new Vector2d(6, -3)));
        assertEquals(new Vector2d(-6, -3), new Vector2d(-19, -8).upperRight(new Vector2d(-6, -3)));

    }

    @Test
    void lowerLeft() {
        Vector2d zeroVector = new Vector2d(0, 0);
        assertEquals(zeroVector, zeroVector.lowerLeft(zeroVector));
        assertEquals(zeroVector, zeroVector.lowerLeft(new Vector2d(5, 2)));
        assertEquals(zeroVector, zeroVector.lowerLeft(new Vector2d(1234567, 12356789)));
        assertEquals(new Vector2d(-15, -65), zeroVector.lowerLeft(new Vector2d(-15, -65)));
        assertEquals(new Vector2d(0, -65), zeroVector.lowerLeft(new Vector2d(65, -65)));
        assertEquals(new Vector2d(-1000, 8), new Vector2d(-19, 8).lowerLeft(new Vector2d(-1000, 65)));

    }

    @Test
    void opposite() {
        assertEquals(new Vector2d(0, 0).opposite(), new Vector2d(0, 0));
        assertEquals(new Vector2d(6, 7).opposite(), new Vector2d(-6, -7));
        assertEquals(new Vector2d(-123456, 1234).opposite(), new Vector2d(123456, -1234));
        assertEquals(new Vector2d(-123456, -1234).opposite(), new Vector2d(123456, 1234));

        Assertions.assertNotEquals(new Vector2d(6, 7).opposite(), new Vector2d(7, -6));
        Assertions.assertNotEquals(new Vector2d(6, 7).opposite(), new Vector2d(7, 6));
    }

    @Test
    void testEquals() {
        Vector2d vector = new Vector2d(1, 6);
        assertEquals(vector, vector);
        assertEquals(vector, new Vector2d(1, 6));
        assertEquals(new Vector2d(1, 6), vector);
        assertEquals(new Vector2d(1, 6), new Vector2d(1, 6));

        Assertions.assertNotEquals(vector, new Vector2d(6, 1));
        Assertions.assertNotEquals(new Vector2d(6, 1), vector);
        Assertions.assertNotEquals(vector, vector.opposite());
        Assertions.assertNotEquals(vector, vector.add(new Vector2d(1, 0)));
    }

    @Test
    void testHashCode() {
        assertEquals(new Vector2d(0,0).hashCode(),new Vector2d(0,0).hashCode());
        assertEquals(new Vector2d(12345678,78).hashCode(),new Vector2d(12345678,78).hashCode());

        Assertions.assertNotEquals(new Vector2d(0,0).hashCode(),new Vector2d(1,0).hashCode());
        Assertions.assertNotEquals(new Vector2d(1234,5).hashCode(),new Vector2d(5,1234).hashCode());
    }
}