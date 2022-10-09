package agh.ics.oop;

public enum Direction {
    FORWARD("f"),
    BACKWARD("b"),
    RIGHT("r"),
    LEFT("l");

    private String value;

    public String getText() {
        return value;
    }

    public static Direction fromText(String s) {
        for (Direction d : Direction.values()) {
            if (d.getText().equals(s)) {
                return d;
            }
        }
        return null;
    }

    Direction(String s) {
        this.value = s;
    }
}