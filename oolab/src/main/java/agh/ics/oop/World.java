package agh.ics.oop;

import java.util.Arrays;

public class World {

    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Arrays.toString(args));
//        MoveDirection[] directions = OptionsParser.parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
////        engine.run();
//        GrassField c = new GrassField(10);
//        System.out.println(c);

        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        Vector2d[] positions = { new Vector2d(2,2) };
        MoveDirection[] directions = OptionsParser.parse(args);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        GrassField c = new GrassField(10);
        System.out.println(c);

    }


}