package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x, y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    Vector2d substract(Vector2d other) {
        return new Vector2d(this.y - other.x, this.y - other.y);
    }

    Vector2d upperRight(Vector2d other) {
        return new Vector2d(this.x > other.x ? this.x : other.x, this.y > other.y ? this.x : this.y);
    }

    Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(this.x < other.x ? this.x : other.x, this.y < other.y ? this.x : this.y);
    }

    Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        if( this == other )
            return true;
        if( this.getClass() != other.getClass() )
            return false;

        Vector2d otherVec2d = (Vector2d) other;
        return this.x == otherVec2d.x && this.y == otherVec2d.y;
    }

}
