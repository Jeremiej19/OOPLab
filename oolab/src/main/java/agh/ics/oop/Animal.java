package agh.ics.oop;

public class Animal {

    private MapDirection direction = MapDirection.NORTH;
    private Vector2d location = new Vector2d(2, 2);

    @Override
    public String toString() {
        return "Animal{" +
                "direction=" + direction.name() +
                ", location=" + location +
                '}';
    }

    boolean isAt(Vector2d position) {
        return this.location.equals(position);
    }

    void move(MoveDirection moveDirection) {
        switch (moveDirection) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d newLocation = this.location.add(this.direction.toUnitVector());
                if (checkLocation(newLocation)) {
                    this.location = newLocation;
                }
            }
            case BACKWARD -> {
                Vector2d newLocation = this.location.subtract(this.direction.toUnitVector());
                if (checkLocation(newLocation)) {
                    this.location = newLocation;
                }
            }
        }
    }

    private boolean checkLocation(Vector2d location) {
        return new Vector2d(0, 0).precedes(location) && new Vector2d(4, 4).follows(location);
    }

}
