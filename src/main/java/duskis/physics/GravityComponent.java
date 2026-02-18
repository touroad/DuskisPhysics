package duskis.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);

        Projectile p = new Projectile(0, 0, new Force(37.065, 28.9360));

        g.translate(0, getHeight());
        for (double i = 0; i < 5; i += 0.001) {
            p.apply(0.001);
            g.fillOval((int) p.getX(), (int) -p.getY(), 2, 2);
        }
    }
}
