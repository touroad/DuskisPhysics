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

    public void updateForce(double x, double y){
        gravityComponent.setForce (
                new Force(
                        Double.parseDouble(xfield.getText()),
                        Double.parseDouble(yfield.getText())
                        )
                );
        xfield.setText(String.valueOf(gravityComponent.getX()));
        yfield.setText(String.valueOf(gravityComponent.getX()));
    }
}
