package agh.ics.oop;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    @Override
    public String toString() {
        return switch (this) {
            case NORTH -> "północ";
            case SOUTH -> "południe";
            case WEST -> "zachód";
            case EAST -> "wschód";
        };
    }

    MapDirection next() {
        return values()[(this.ordinal() + 1) % values().length];
    }

    MapDirection previous() {
        return values()[(this.ordinal() + 3) % values().length];
    }

    Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
        };
    }

}
