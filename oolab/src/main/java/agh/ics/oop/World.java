package agh.ics.oop;

import java.util.Arrays;

public class World {

    public static void main(String[] args) throws InterruptedException {

//        MoveDirection[] movesList = OptionsParser.parse(args);
//        System.out.println(Arrays.toString(movesList));
//
//        Animal animal1 = new Animal();
//        System.out.println(animal1);
//        animal1.move(MoveDirection.RIGHT);
//        animal1.move(MoveDirection.FORWARD);
//        animal1.move(MoveDirection.FORWARD);
//        animal1.move(MoveDirection.FORWARD);
//        System.out.println(animal1);
//
//        System.out.println("----------");
//
//        Animal animal2 = new Animal();
//        System.out.println(animal2);
//        for (MoveDirection I : movesList) {
//            animal2.move(I);
//            System.out.println(animal2);
//        }

        System.out.println(Arrays.toString(args));
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

    }

}