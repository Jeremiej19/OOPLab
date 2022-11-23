package agh.ics.oop;

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
        return animals.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    protected MapSize getSize() {
        return new MapSize(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));
    }



}
