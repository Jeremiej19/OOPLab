package agh.ics.oop;

import java.util.Arrays;
import java.util.stream.Collectors;

public class World {

    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(Arrays.stream(args).map(x -> Direction.fromText(x)).filter(x -> x != Direction.INVALID).toArray(Direction[]::new));
        System.out.println("system zakończył działanie");
    }

    public static void run(Direction[] args) {
        String commands = Arrays.stream(args).map(x -> x.getText() + ", ").collect(Collectors.joining());
        commands = commands.substring(0, commands.length() - 2);
        System.out.println("zwierzak biegnie " + commands);
//        System.out.println(Arrays.stream(args).map(x -> x.getText() + ", ").collect(Collectors.joining())
//                .substring(0, -2 + args.length * 2 + Arrays.stream(args).map(x -> x.getText().length()).reduce(0, (x, y) -> x + y)));
        for (Direction arg : args) {
            switch (arg) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
            }
        }
    }
}