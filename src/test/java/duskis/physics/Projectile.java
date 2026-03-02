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
        x += scaledForce.getX();
        y += scaledForce.getY();
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
