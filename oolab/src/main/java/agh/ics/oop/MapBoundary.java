package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {

    SortedSet<Vector2d> setX = new TreeSet<>(Comparator.comparing(Vector2d::getX));
    SortedSet<Vector2d> setY = new TreeSet<>(Comparator.comparing(Vector2d::getY));

    public void add(Vector2d position) {
        setX.add(position);
        setY.add(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        setX.remove(oldPosition);
        setX.add(newPosition);
        setY.remove(oldPosition);
        setY.add(newPosition);
    }

    public MapSize getBoundaries() {
        return new MapSize(new Vector2d(setX.first().getX(),setY.first().getY()), new Vector2d(setX.last().getX(),setY.last().getY()));
    }
}
