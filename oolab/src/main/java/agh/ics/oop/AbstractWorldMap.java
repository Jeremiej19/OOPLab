package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap {
    protected final List<Animal> animals = new ArrayList<>();

    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getLocation())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    protected abstract MapSize getSize();

    @Override
    public String toString() {
        MapSize size = getSize();
        return new MapVisualizer(this).draw(size.lowerPoint, size.upperPoint);
    }

}
