package agh.ics.oop;

import java.util.Arrays;
import java.util.stream.Collectors;

public class World {

    public static void main(String[] args) {
//        args = new String[]{"f", "b"};
        System.out.println("system wystartował");
        run(Arrays.stream(args).map(x -> Direction.fromText(x)).toArray(Direction[]::new));
        System.out.println("system zakończył działanie");
    }

    public static void run(Direction[] args) {
        String commands = Arrays.stream(args).map(x -> x.getText() + ", ").collect(Collectors.joining());
        commands = commands.substring(0, commands.length() - 2);
        System.out.println("zwierzak biegnie " + commands);
//            Arrays.stream(args).forEach( x -> System.out.print(x+",") );
        for (Direction arg : args) {
            switch (arg) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case LEFT:
                    System.out.println("Zwierzak idzie w lewo");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak idzie w prawo");
                    break;
            }
        }
    }
}