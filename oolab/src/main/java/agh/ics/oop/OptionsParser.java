package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        for (String arg : args) {
            if (MoveDirection.fromText(arg) == MoveDirection.INVALID)
                throw new IllegalArgumentException(arg + " is an invalid argument");
        }
        return (Arrays.stream(args).map(MoveDirection::fromText).toArray(MoveDirection[]::new));
    }
}
