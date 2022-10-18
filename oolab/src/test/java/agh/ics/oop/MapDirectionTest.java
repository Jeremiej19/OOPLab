package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapDirectionTest {

    @Test
    void testToString() {
        Assertions.assertEquals(MapDirection.NORTH.toString(), "północ");
        Assertions.assertEquals(MapDirection.EAST.toString(), "wschód");
        Assertions.assertEquals(MapDirection.SOUTH.toString(), "południe");
        Assertions.assertEquals(MapDirection.WEST.toString(), "zachód");
    }

    @Test
    void next() {
        Assertions.assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
        Assertions.assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        Assertions.assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);
        Assertions.assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);
    }

    @Test
    void previous() {
        Assertions.assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);
        Assertions.assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);
        Assertions.assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);
        Assertions.assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);

    }

    @Test
    void toUnitVector() {
        Assertions.assertEquals(MapDirection.NORTH.toUnitVector(), new Vector2d(0, 1));
        Assertions.assertEquals(MapDirection.EAST.toUnitVector(), new Vector2d(1, 0));
        Assertions.assertEquals(MapDirection.SOUTH.toUnitVector(), new Vector2d(0, -1));
        Assertions.assertEquals(MapDirection.WEST.toUnitVector(), new Vector2d(-1, 0));
    }
}