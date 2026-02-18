package duskis.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);

        Force gravity = new Force(0, -9.8);
        Force scaledGravity = gravity.scale(0.1);

        double x = 0.0;
        double y = 0.0;
        int x2;
        int y2;

        Force f1 = new Force(37.0365, 28.9360);

        for (double t = 0; t < 5; t += 0.01) {
            f1 = f1.add(scaledGravity);
            Force scaledBall = f1.scale(0.1);
            x += scaledBall.getX();
            x2 = (int) Math.round(x);
            y += scaledBall.getY();
            y2 = (int) Math.round(y);
            g.fillOval(x2, y2, 2, 2);
        }
    }
}
