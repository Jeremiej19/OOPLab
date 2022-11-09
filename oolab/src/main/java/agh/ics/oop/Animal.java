package agh.ics.oop;

public class Animal {

    private MapDirection direction = MapDirection.NORTH;
    private Vector2d location = new Vector2d(2, 2);
    private final IWorldMap map;

    public Animal() {
        this.map = new RectangularMap(5,5);
    }

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d location) {
        this.location = location;
        this.map = map;
    }

    public Vector2d getLocation() {
        return new Vector2d(location);
    }

    @Override
    public String toString() {
        return direction.getChar();
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
                if (map.canMoveTo(newLocation)) {
                    this.location = newLocation;
                }
            }
            case BACKWARD -> {
                Vector2d newLocation = this.location.subtract(this.direction.toUnitVector());
                if (map.canMoveTo(newLocation)) {
                    this.location = newLocation;
                }
            }
        }
    }

}
