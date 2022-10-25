package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public enum MoveDirection {
    FORWARD(new ArrayList<>(List.of(new String[]{"f","forward"}))),
    BACKWARD(new ArrayList<>(List.of(new String[]{"b","backward"}))),
    RIGHT(new ArrayList<>(List.of(new String[]{"r","right"}))),
    LEFT(new ArrayList<>(List.of(new String[]{"l","left"}))),
    INVALID(new ArrayList<>(List.of(new String[]{})));

    private final List<String> value;

    MoveDirection(List<String> s) {
        this.value = s;
    }

    public List<String> getTextArray() {
        return value;
    }

    public static MoveDirection fromText(String s) {
        for (MoveDirection d : MoveDirection.values()) {
            if (d.getTextArray().contains(s.toLowerCase())) {
                return d;
            }
        }
        return INVALID;
    }

}