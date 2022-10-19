package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Vector2dTest {

    @Test
    void testToString() {
        Assertions.assertEquals("(0,0)", new Vector2d(0, 0).toString());
        Assertions.assertEquals("(545443,123123)", new Vector2d(545443, 123123).toString());
        Assertions.assertEquals("(999999999,999999999)", new Vector2d(999999999, 999999999).toString());
        Assertions.assertEquals("(-13,0)", new Vector2d(-13, 0).toString());
        Assertions.assertEquals("(-1354535435,234234324)", new Vector2d(-1354535435, 234234324).toString());
        Assertions.assertEquals("(234234,-12312323)", new Vector2d(234234, -12312323).toString());
        Assertions.assertEquals("(-1234567890,-987654321)", new Vector2d(-1234567890, -987654321).toString());
    }

    @Test
    void precedes() {
        Vector2d zeroVector = new Vector2d(0, 0);
        Assertions.assertTrue(zeroVector.precedes(zeroVector));
        Assertions.assertTrue(zeroVector.precedes(new Vector2d(0, 0)));
        Assertions.assertTrue(zeroVector.precedes(new Vector2d(1, 1)));
        Assertions.assertTrue(zeroVector.precedes(new Vector2d(0, 1)));
        Assertions.assertTrue(zeroVector.precedes(new Vector2d(1, 0)));
        Assertions.assertTrue(new Vector2d(-10, -10).precedes(new Vector2d(10, 10)));
        Assertions.assertTrue(new Vector2d(12345, 12345).precedes(new Vector2d(123456, 123456)));

        Assertions.assertFalse(new Vector2d(1, 1).precedes(new Vector2d(0, 0)));
        Assertions.assertFalse(new Vector2d(0, 0).precedes(new Vector2d(-1, -1)));
        Assertions.assertFalse(new Vector2d(-8888, 8888).precedes(new Vector2d(0, 0)));
        Assertions.assertFalse(new Vector2d(99, 99).precedes(new Vector2d(-6, -6)));
    }

    @Test
    void follows() {
        Vector2d vector = new Vector2d(100, 100);
        Assertions.assertTrue(vector.follows(vector));
        Assertions.assertTrue(vector.follows(new Vector2d(0, 0)));
        Assertions.assertTrue(vector.follows(new Vector2d(-1234, -1234)));
        Assertions.assertTrue(new Vector2d(0, 0).follows(new Vector2d(-1234, -1234)));

        Assertions.assertFalse(vector.follows(new Vector2d(101, 101)));
        Assertions.assertFalse(vector.follows(new Vector2d(123, -6)));
        Assertions.assertFalse(vector.follows(new Vector2d(1234567, 1234567)));
        Assertions.assertFalse(new Vector2d(0, 0).follows(new Vector2d(1, 0)));
    }

    @Test
    void add() {
        Vector2d zeroVector = new Vector2d(0, 0);
        Assertions.assertEquals(zeroVector, zeroVector.add(zeroVector));
        Assertions.assertEquals(new Vector2d(2, 8), zeroVector.add(new Vector2d(2, 8)));
        Assertions.assertEquals(new Vector2d(-5, 9), zeroVector.add(new Vector2d(-5, 9)));
        Assertions.assertEquals(new Vector2d(-5, 9).add(new Vector2d(1, 2))
                , new Vector2d(1, 2).add(new Vector2d(-5, 9)));

        Assertions.assertNotEquals(new Vector2d(5, 9), zeroVector.add(new Vector2d(-5, 9)));
        Assertions.assertNotEquals(new Vector2d(1, 2), zeroVector.add(new Vector2d(1234, 87)));
    }

    @Test
    void subtract() {
        Vector2d zeroVector = new Vector2d(0, 0);
        Assertions.assertEquals(zeroVector, zeroVector.subtract(zeroVector));
        Vector2d vector = new Vector2d(5, -5);
        Assertions.assertEquals(zeroVector, vector.subtract(vector));
        Assertions.assertEquals(zeroVector, new Vector2d(5, -5).subtract(new Vector2d(5, -5)));
        Assertions.assertEquals(new Vector2d(6, -7), new Vector2d(1, 2).subtract(new Vector2d(-5, 9)));


        Assertions.assertNotEquals(new Vector2d(1, 2).subtract(new Vector2d(-5, 9)),
                new Vector2d(-5, 9).subtract(new Vector2d(1, 2)));

    }

    @Test
    void upperRight() {
        Vector2d zeroVector = new Vector2d(0, 0);
        Assertions.assertEquals(zeroVector, zeroVector.upperRight(zeroVector));
        Assertions.assertEquals(zeroVector, zeroVector.upperRight(new Vector2d(-5, -45)));
        Assertions.assertEquals(new Vector2d(5, 5), zeroVector.upperRight(new Vector2d(5, 5)));
        Assertions.assertEquals(new Vector2d(0, 5), zeroVector.upperRight(new Vector2d(-5, 5)));
        Assertions.assertEquals(new Vector2d(19, 8), new Vector2d(19, 8).upperRight(new Vector2d(6, -3)));
        Assertions.assertEquals(new Vector2d(-6, -3), new Vector2d(-19, -8).upperRight(new Vector2d(-6, -3)));

    }

    @Test
    void lowerLeft() {
        Vector2d zeroVector = new Vector2d(0, 0);
        Assertions.assertEquals(zeroVector, zeroVector.lowerLeft(zeroVector));
        Assertions.assertEquals(zeroVector, zeroVector.lowerLeft(new Vector2d(5, 2)));
        Assertions.assertEquals(zeroVector, zeroVector.lowerLeft(new Vector2d(1234567, 12356789)));
        Assertions.assertEquals(new Vector2d(-15, -65), zeroVector.lowerLeft(new Vector2d(-15, -65)));
        Assertions.assertEquals(new Vector2d(0, -65), zeroVector.lowerLeft(new Vector2d(65, -65)));
        Assertions.assertEquals(new Vector2d(-1000, 8), new Vector2d(-19, 8).lowerLeft(new Vector2d(-1000, 65)));

    }

    @Test
    void opposite() {
        Assertions.assertEquals(new Vector2d(0, 0).opposite(), new Vector2d(0, 0));
        Assertions.assertEquals(new Vector2d(6, 7).opposite(), new Vector2d(-6, -7));
        Assertions.assertEquals(new Vector2d(-123456, 1234).opposite(), new Vector2d(123456, -1234));
        Assertions.assertEquals(new Vector2d(-123456, -1234).opposite(), new Vector2d(123456, 1234));

        Assertions.assertNotEquals(new Vector2d(6, 7).opposite(), new Vector2d(7, -6));
        Assertions.assertNotEquals(new Vector2d(6, 7).opposite(), new Vector2d(7, 6));
    }

    @Test
    void testEquals() {
        Vector2d vector = new Vector2d(1, 6);
        Assertions.assertEquals(vector, vector);
        Assertions.assertEquals(vector, new Vector2d(1, 6));
        Assertions.assertEquals(new Vector2d(1, 6), vector);
        Assertions.assertEquals(new Vector2d(1, 6), new Vector2d(1, 6));

        Assertions.assertNotEquals(vector, new Vector2d(6, 1));
        Assertions.assertNotEquals(new Vector2d(6, 1), vector);
        Assertions.assertNotEquals(vector, vector.opposite());
        Assertions.assertNotEquals(vector, vector.add(new Vector2d(1, 0)));
    }

    @Test
    void testHashCode() {
        Assertions.assertEquals(new Vector2d(0,0).hashCode(),new Vector2d(0,0).hashCode());
        Assertions.assertNotEquals(new Vector2d(0,0).hashCode(),new Vector2d(1,0).hashCode());
    }
}