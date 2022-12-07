package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.Arrays;

public class World {

    public static void main(String[] args) throws InterruptedException {
        Application.launch(App.class, args);
        try {

//            MapBoundary mapBoundary = new MapBoundary();
//            AbstractWorldMap map = new GrassField(10, mapBoundary);
//            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//            MoveDirection[] directions = OptionsParser.parse(args);
//            IEngine engine = new SimulationEngine(directions, map, positions, mapBoundary);
//            engine.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }


}