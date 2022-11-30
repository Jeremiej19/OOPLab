package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();
    protected MapBoundary mapBoundary;

    @Override
    public Map<Vector2d, Animal> getAnimals() {
        return animals;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        animals.put(newPosition,animals.remove(oldPosition));
    }

    @Override
    public boolean place(Animal animal) {
        if( animals.get(animal.getLocation()) != null )
            throw new IllegalArgumentException("Pole " + animal.getLocation() + " jest już zajęte. Nie można ustawić tam drugiego zwierzęcia");
        return animals.putIfAbsent(animal.getLocation(), animal) == null;
    }

    protected abstract MapSize getSize();

    @Override
    public String toString() {
        MapSize size = getSize();
        return new MapVisualizer(this).draw(size.lowerPoint, size.upperPoint);
    }

}
