package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void testMap() {
        IWorldMap map = new RectangularMap(7, 5);
        assertFalse(map.canMoveTo(new Vector2d(5, 7)));
        Animal a1 = new Animal(map);
        Animal a2 = new Animal(map, new Vector2d(2, 3));
        assertTrue(map.place(a1));
        assertThrows(IllegalArgumentException.class, () -> map.place(new Animal(map)));
        assertTrue(map.place(a2));
        assertFalse(map.canMoveTo(new Vector2d(2, 3)));
        assertTrue(map.canMoveTo(new Vector2d(3, 2)));
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.FORWARD);
        a2.move(MoveDirection.BACKWARD);
        a2.move(MoveDirection.BACKWARD);
        a2.move(MoveDirection.BACKWARD);
        assertTrue(a1.isAt(new Vector2d(2, 2)));
        assertTrue(a2.isAt(new Vector2d(2, 3)));
        a2.move(MoveDirection.FORWARD);
        a2.move(MoveDirection.FORWARD);
        a2.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.LEFT);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.FORWARD);
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(0, 2)));
        assertTrue(a2.isAt(new Vector2d(2, 4)));
        assertThrows(IllegalArgumentException.class,() -> map.place(new Animal(map, new Vector2d(2, 4))));
        assertSame(map.objectAt(new Vector2d(2, 4)), a2);
    }

}