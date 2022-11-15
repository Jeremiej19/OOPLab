package agh.ics.oop;

public class Grass {
    private Vector2d location;

    public Grass(Vector2d position) {
        location = position;
    }

    public Vector2d getLocation() {
        return new Vector2d(location);
    }

    @Override
    public String toString() {
        return "*";
    }

    boolean isAt(Vector2d position) {
        return this.location.equals(position);
    }
}
