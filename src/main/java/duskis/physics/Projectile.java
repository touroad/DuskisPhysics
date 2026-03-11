package duskis.physics;

public class Projectile {
    public static final Force Gravity = new Force(0, -9.8);

    private double x;
    private double y;
    private Force force;

    public Projectile(double x, double y, Force force) {
        this.x = x;
        this.y = y;
        this.force = force;
    }

    public void apply(double time) {
        Force scaledGravity = Gravity.scale(time);
        force = force.add(scaledGravity);
        Force scaledForce = force.scale(time);
        x += scaledForce.x();
        y += scaledForce.y();
    }

    public double getApexY() {
        double y = force.y();
        return (y * y) / (2 * -Gravity.y());
    }

    public double getApexX() {
        double y = force.y();
        double x = force.x();
        return (x * y) / (-Gravity.y());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Force getForce() {
        return force;
    }
}
