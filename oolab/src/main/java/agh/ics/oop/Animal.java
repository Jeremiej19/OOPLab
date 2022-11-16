package agh.ics.oop;

public class Animal extends AbstractWorldMapElement {

    private MapDirection direction = MapDirection.NORTH;
    private final IWorldMap map;

    public Animal() {
        location = new Vector2d(2, 2);
        this.map = new RectangularMap(5, 5);
    }

    public Animal(IWorldMap map) {
        location = new Vector2d(2, 2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d location) {
        this.location = location;
        this.map = map;
    }

    @Override
    public String toString() {
        return direction.getChar();
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
