package duskis.physics;

import javax.swing.*;

public class GravityController {
    private final GravityComponent gravityComponent;
    private final JTextField xfield;
    private final JTextField yfield;
    private final JTextField timefield;
    private final JTextField apexfield;

    private final JLabel forceX;
    private final JLabel forceY;
    private final JLabel time;
    private final JLabel angle;
    private final JLabel magnitude;
    private final JLabel apex;

    public GravityController(
            GravityComponent gravityComponent,
            JTextField xfield,
            JTextField yfield,
            JTextField timefield,
            JTextField apexfield,
            JLabel forceX,
            JLabel forceY,
            JLabel time,
            JLabel apex,
            JLabel angle,
            JLabel magnitude
    ) {
        this.gravityComponent = gravityComponent;
        this.xfield = xfield;
        this.yfield = yfield;
        this.timefield = timefield;
        this.apexfield = apexfield;
        this.forceX = forceX;
        this.forceY = forceY;
        this.time = time;
        this.apex = apex;
        this.angle = angle;
        this.magnitude = magnitude;
    }

    public void updateForce(double x, double y) {
        gravityComponent.setForce(new Force(x, y));
        xfield.setText(String.valueOf(x));
        yfield.setText(String.valueOf(y));
        Projectile temp = new Projectile(0, 0, new Force(x, y));
        apexfield.setText(String.format("%.2f", temp.getApexX()) + ", " + String.format("%.2f", temp.getApexY()));
    }

    public void updateButtonInput(double x, double y, double time) {
        gravityComponent.setForce(new Force(x, y));
        xfield.setText(String.valueOf(x));
        yfield.setText(String.valueOf(y));
        Projectile temp = new Projectile(0, 0, new Force(x, y));
        apexfield.setText(String.format("%.2f", temp.getApexX()) + ", " + String.format("%.2f", temp.getApexY()));
        gravityComponent.setTime(time);
    }
}


/*
    double X = Double.parseDouble(x);
    double Y = Double.parseDouble(y);
    this.time = Double.parseDouble(time);

is this dumb to persue?
 */