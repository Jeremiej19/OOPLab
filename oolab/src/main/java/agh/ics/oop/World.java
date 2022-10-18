package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class World {

    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(Arrays.stream(args).map(x -> MoveDirection.fromText(x)).filter(x -> x != MoveDirection.INVALID).toArray(MoveDirection[]::new));
        System.out.println("system zakończył działanie");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(MapDirection.WEST.next());
        System.out.println(MapDirection.WEST.previous());
        System.out.println(MapDirection.NORTH.next());
        System.out.println(MapDirection.NORTH.previous());

    }

    public static void run(MoveDirection[] args) {

        System.out.println("Parametry: " + Arrays.stream(args).map(x -> x.getText()).collect(Collectors.joining(", ")));

        for (MoveDirection arg : args) {
            switch (arg) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
            }
        }
    }
}