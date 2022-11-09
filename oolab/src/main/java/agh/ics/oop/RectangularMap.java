package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;
    private final List<Animal> animals = new ArrayList<>();

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
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getLocation())) {
            animals.add(animal);
            return true;
        }
        return false;
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
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));
    }

//    public JComponent getPane() {
//        return new JComponent() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//            }
//        }
//    }

}
