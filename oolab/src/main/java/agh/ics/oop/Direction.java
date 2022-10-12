package agh.ics.oop;

public enum Direction {
    FORWARD("f"),
    BACKWARD("b"),
    RIGHT("r"),
    LEFT("l"),
    INVALID("");

    private String value;

    Direction(String s) {
        this.value = s;
    }

    public String getText() {
        return value;
    }

    public static Direction fromText(String s) {
        for (Direction d : Direction.values()) {
            if (d.getText().equals(s.toLowerCase())) {
                return d;
            }
        }
        return INVALID;
    }

}