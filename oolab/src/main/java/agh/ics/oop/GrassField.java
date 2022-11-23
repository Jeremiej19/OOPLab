package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap {
    private final List<Grass> grassFields = new ArrayList<>();
    private final int size;

    public GrassField(int grassCount) {
        if (grassCount < 1)
            grassCount = 1;
        size = (int) Math.ceil(Math.sqrt(grassCount * 10));
        for (int i = 0; i < grassCount; ++i) {
            grassFields.add(new Grass(randomVec2d()));
        }
    }

    private Vector2d nextPostion(Vector2d vec) {
        if (vec.x + 1 < size)
            return new Vector2d(vec.x + 1, vec.y);

        if (vec.y + 1 < size) {
            return new Vector2d(0, vec.y + 1);
        } else {
            return new Vector2d(0, 0);
        }
    }

    private Vector2d randomVec2d() {
        var a = new Vector2d(ThreadLocalRandom.current().nextInt(0, size), ThreadLocalRandom.current().nextInt(0, size));
        while (isOccupied(a)) {
            a = nextPostion(a);
        }
        return a;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Object o = objectAt(newPosition);
        if (o != null && o.getClass().equals(Grass.class)) {
            grassFields.remove(o);
            super.positionChanged(oldPosition, newPosition);
            grassFields.add(new Grass(randomVec2d()));
        } else {
            super.positionChanged(oldPosition, newPosition);
        }

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (animals.containsKey(position)) {
            return true;
        }
        for (Grass grass : grassFields) {
            if (grass.isAt(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        for (Grass grass : grassFields) {
            if (grass.isAt(position)) {
                return grass;
            }
        }
        return null;
    }

    @Override
    protected MapSize getSize() {
        var grassPos = grassFields.stream().map(Grass::getLocation).toList();
        Vector2d minPos = grassPos.stream().reduce(grassPos.get(0), Vector2d::lowerLeft);
        Vector2d maxPos = grassPos.stream().reduce(grassPos.get(0), Vector2d::upperRight);

        if (!animals.isEmpty()) {
            var animalsPos = animals.keySet().stream().toList();
            Vector2d minPosAnimal = animalsPos.stream().reduce(animalsPos.get(0), Vector2d::lowerLeft);
            Vector2d maxPosAnimal = animalsPos.stream().reduce(animalsPos.get(0), Vector2d::upperRight);
            minPos = minPos.lowerLeft(minPosAnimal);
            maxPos = maxPos.upperRight(maxPosAnimal);
        }
        return new MapSize(minPos, maxPos);
    }

}
