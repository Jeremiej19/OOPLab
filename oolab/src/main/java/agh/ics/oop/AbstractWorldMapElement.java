package agh.ics.oop;

public abstract class AbstractWorldMapElement {
    protected Vector2d location;

    public Vector2d getLocation() {
        return new Vector2d(location);
    }

    boolean isAt(Vector2d position) {
        return this.location.equals(position);
    }
}
