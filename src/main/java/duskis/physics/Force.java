package duskis.physics;

import java.util.Objects;

public class Force {
    private double x;
    private double y;

    public Force(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getMagnitude() {
        double square1 = x * x;
        double square2 = y * y;
        return Math.sqrt(square1 + square2);
    }

    public double getRadians() {
        return Math.atan2(y, x);
    }

    public double getDegrees() {
        double radian = Math.atan2(y, x);
        return Math.toDegrees(radian);
    }

    public Force add(Force f) {
        return new Force(this.getX() + f.getX(), this.getY() + f.getY());
    }

    public Force normalize() {

        return new Force(this.x / getMagnitude(), this.y / getMagnitude());
    }


    public Force scale(double scale) {
        return new Force(this.x * scale, this.y * scale);
    }

    public String toString() {
        return String.format("Force(%f, %f)", getX(), getY());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Force force = (Force) o;
        return Double.compare(x, force.x) == 0 && Double.compare(y, force.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

