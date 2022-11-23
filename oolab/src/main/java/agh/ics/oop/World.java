package agh.ics.oop;

public class World {

    public static void main(String[] args) throws InterruptedException {
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        MoveDirection[] directions = OptionsParser.parse(args);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }


}