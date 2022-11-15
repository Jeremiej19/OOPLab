package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private boolean isInBounds(Vector2d position) {
        return position.y < height && position.y >= 0 && position.x < width && position.x >= 0;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return isInBounds(position) && !isOccupied(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
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
        return null;
    }

    @Override
    protected MapSize getSize() {
        return new MapSize(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));
    }


//    @Override
//    public String toString() {
//        return new MapVisualizer(this).draw(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));
//    }

}
