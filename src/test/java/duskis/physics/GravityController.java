package duskis.physics;

import javax.swing.*;

public class GravityController {
    private GravityComponent gravityComponent;
    private JTextField xfield;
    private JTextField yfield;
    private JTextField timefield;

    private JLabel forceX;
    private JLabel forceY;
    private JLabel time;
    private JLabel angle;
    private JLabel magnitude;

    public GravityController(
            GravityComponent gravityComponent,
            JTextField xfield,
            JTextField yfield,
            JTextField timefield,
            JLabel forceX,
            JLabel forceY,
            JLabel time,
            JLabel angle,
            JLabel magnitude
    ) {
        this.gravityComponent = gravityComponent;
        this.xfield = xfield;
        this.yfield = yfield;
        this.timefield = timefield;
        this.forceX = forceX;
        this.forceY = forceY;
        this.time = time;
        this.angle = angle;
        this.magnitude = magnitude;
    }


    public void updateForce(double x, double y) {
        gravityComponent.setForce(new Force(x, y));
        xfield.setText(String.valueOf(x));
        yfield.setText(String.valueOf(y));
    }

    public void updateButtonInput(double x, double y, double time) {
        gravityComponent.setForce(new Force(x, y));
        gravityComponent.setTime(time);
    }
}


/*
    double X = Double.parseDouble(x);
    double Y = Double.parseDouble(y);
    this.time = Double.parseDouble(time);

is this dumb to persue?
 */