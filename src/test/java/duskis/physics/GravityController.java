package duskis.physics;

import javax.swing.*;

public class GravityController {
    GravityComponent gravityComponent;
    JTextField xfield;
    JTextField yfield;
    JTextField timefield;

    JLabel forceX;
    JLabel forceY;
    JLabel time;
    JLabel angle;
    JLabel magnitude;

    public void updateForce(double x, double y) {
        gravityComponent.setForce(new Force(x, y));
        xfield.setText(String.valueOf(x));
        yfield.setText(String.valueOf(y));
    }

    public void updateButton(double x, double y, double time) {
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