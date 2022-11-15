package agh.ics.oop;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private final List<Grass> grassFields = new ArrayList<>();
    private final int grassCount;
    public GrassField(int grassCount) {
        if( grassCount < 1 )
            grassCount = 1;
        this.grassCount = grassCount;
        for( int i = 0 ; i < grassCount; ++i) {
            grassFields.add(new Grass(randomVec2d()));
        }
        System.out.println(grassFields);
    }

    private Vector2d randomVec2d(){
        int size = (int) Math.ceil(Math.sqrt(grassCount*10));
        var a = new Vector2d(ThreadLocalRandom.current().nextInt(0, size),ThreadLocalRandom.current().nextInt(0, size));
        System.out.println(a);
        while (isOccupied(a)) {
            a = new Vector2d(a.x , a.y+1);
            System.out.println("ASDASDASDASDASDASDASD");
        }
        System.out.println(a);
        return a;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return false;
            }
        }

        Object o = objectAt(position);
        if( o != null && o.getClass().equals(Grass.class) ) {
            grassFields.remove(o);
            grassFields.add(new Grass(randomVec2d()));
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return true;
            }
        }
        for(Grass grass : grassFields) {
            if (grass.isAt(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        for(Grass grass : grassFields) {
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

        if( !animals.isEmpty() ) {
            var animalsPos = animals.stream().map(Animal::getLocation).toList();
            Vector2d minPosAnimal = animalsPos.stream().reduce(animalsPos.get(0), Vector2d::lowerLeft);
            Vector2d maxPosAnimal = animalsPos.stream().reduce(animalsPos.get(0), Vector2d::upperRight);
            minPos = minPos.lowerLeft(minPosAnimal);
            maxPos = maxPos.upperRight(maxPosAnimal);
        }
        return new MapSize(minPos , maxPos);
    }


//    @Override
//    public String toString() {
//        var grassPos = grassFields.stream().map(Grass::getLocation).toList();
//        Vector2d minPos = grassPos.stream().reduce(grassPos.get(0), Vector2d::lowerLeft);
//        Vector2d maxPos = grassPos.stream().reduce(grassPos.get(0), Vector2d::upperRight);
//
//        if( !animals.isEmpty() ) {
//            var animalsPos = animals.stream().map(Animal::getLocation).toList();
//            Vector2d minPosAnimal = animalsPos.stream().reduce(animalsPos.get(0), Vector2d::lowerLeft);
//            Vector2d maxPosAnimal = animalsPos.stream().reduce(animalsPos.get(0), Vector2d::upperRight);
//            minPos = minPos.lowerLeft(minPosAnimal);
//            maxPos = maxPos.upperRight(maxPosAnimal);
//        }
//
//        return new MapVisualizer(this).draw( minPos , maxPos );
//    }

}
