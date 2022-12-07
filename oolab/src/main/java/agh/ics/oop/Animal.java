package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement {

    private MapDirection direction = MapDirection.NORTH;
    private final IWorldMap map;
    private final List<IPositionChangeObserver> observerList = new ArrayList<>();

    public Animal() {
        location = new Vector2d(2, 2);
        this.map = new RectangularMap(5, 5);
    }

    public Animal(IWorldMap map) {
        location = new Vector2d(2, 2);
        this.map = map;
        this.observerList.add((IPositionChangeObserver) map);
    }

    public Animal(IWorldMap map, Vector2d location) {
        this.location = location;
        this.map = map;
        this.observerList.add((IPositionChangeObserver) map);
    }

    public Animal(IWorldMap map, Vector2d location, IPositionChangeObserver observer) {
        this.location = location;
        this.map = map;
        this.observerList.add(observer);
    }

    @Override
    public String toString() {
        return direction.getChar();
    }

    void addObserver(IPositionChangeObserver o) {
        observerList.add(o);
    }

    void removeObserver(IPositionChangeObserver o) {
        observerList.remove(o);
    }

    void move(MoveDirection moveDirection) {
        switch (moveDirection) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d newLocation = this.location.add(this.direction.toUnitVector());
                if (map.canMoveTo(newLocation)) {
                    observerList.forEach(x -> x.positionChanged(this.getLocation(), new Vector2d(newLocation)));
                    this.location = newLocation;
                }
            }
            case BACKWARD -> {
                Vector2d newLocation = this.location.subtract(this.direction.toUnitVector());
                if (map.canMoveTo(newLocation)) {
                    observerList.forEach(x -> x.positionChanged(this.getLocation(), new Vector2d(newLocation)));
                    this.location = newLocation;
                }
            }
        }
    }

    @Override
    public String fileName() {
        return this.direction.getFileName();
    }
}
