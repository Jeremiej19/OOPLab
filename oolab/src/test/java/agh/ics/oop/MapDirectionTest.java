package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapDirectionTest {

    @Test
    void testToString() {
        assertEquals(MapDirection.NORTH.toString(), "północ");
        assertEquals(MapDirection.EAST.toString(), "wschód");
        assertEquals(MapDirection.SOUTH.toString(), "południe");
        assertEquals(MapDirection.WEST.toString(), "zachód");
    }

    @Test
    void next() {
        assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
        assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);
        assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);
    }

    @Test
    void previous() {
        assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);
        assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);
        assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);

    }

    @Test
    void toUnitVector() {
        assertEquals(MapDirection.NORTH.toUnitVector(), new Vector2d(0, 1));
        assertEquals(MapDirection.EAST.toUnitVector(), new Vector2d(1, 0));
        assertEquals(MapDirection.SOUTH.toUnitVector(), new Vector2d(0, -1));
        assertEquals(MapDirection.WEST.toUnitVector(), new Vector2d(-1, 0));
    }
}