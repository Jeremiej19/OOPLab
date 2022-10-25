package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        return (Arrays.stream(args).map(MoveDirection::fromText).filter(x -> x != MoveDirection.INVALID)
                .toArray(MoveDirection[]::new));
    }
}
