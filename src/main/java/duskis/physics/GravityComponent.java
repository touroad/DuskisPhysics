package duskis.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {
    private Force force = new Force(37.065, 28.9360);
    private double time = 5;

    public void setForce(Force force) {
        this.force = force;
        repaint();
    }

    public void setTime(double time) {
        this.time = time;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);

        Projectile p = new Projectile(0, 0, force);

        g.translate(0, getHeight());
        for (double i = 0; i < time; i += 0.001) {
            p.apply(0.001);
            System.out.println(p.getX() + " " + p.getY() + " " + p.getForce());
            g.fillOval((int) p.getX(), (int) -p.getY(), 2, 2);
        }

        g.setColor(Color.green);
        g.drawLine(0, 0, (int) force.getX(), (int) -force.getY());
    }
}
