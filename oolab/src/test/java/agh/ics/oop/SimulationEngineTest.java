package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void run() throws InterruptedException {
        MoveDirection[] directions = OptionsParser.parse("f b r l f f r r f f f f f f f f".split(" "));
        AbstractWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions, new MapBoundary());
        engine.run(false);
        assertNotNull( map.objectAt(new Vector2d(3,4)) );
        assertNotNull( map.objectAt(new Vector2d(2,0)) );
        assertNull( map.objectAt(new Vector2d(2,2)) );
    }
}