package agh.ics.oop;

public class Grass extends AbstractWorldMapElement {

    public Grass(Vector2d position) {
        location = position;
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public String fileName() {
        return "grass.png";
    }
}
