package agh.ics.oop;

public enum MoveDirection {
    FORWARD("f"),
    BACKWARD("b"),
    RIGHT("r"),
    LEFT("l"),
    INVALID("");

    private String value;

    MoveDirection(String s) {
        this.value = s;
    }

    public String getText() {
        return value;
    }

    public static MoveDirection fromText(String s) {
        for (MoveDirection d : MoveDirection.values()) {
            if (d.getText().equals(s.toLowerCase())) {
                return d;
            }
        }
        return INVALID;
    }

}