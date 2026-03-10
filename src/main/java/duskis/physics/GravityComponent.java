package duskis.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class GravityComponent extends JComponent {
    private Force force = new Force(37.065, 28.9360);
    Projectile p = new Projectile(0, 0, force);
    private double time = 5;
    private double apexX = p.getApexX();
    private double apexY = p.getApexY();

    public void setForce(Force force) {
        this.force = force;
        p = new Projectile(0, 0, force);
        apexX = p.getApexX();
        apexY = p.getApexY();
        repaint();
    }

    public void setTime(double time) {
        this.time = time;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color lightBlue = new Color(167, 199, 231);
        g.setColor(lightBlue);
        for (int i = 20; i <= getWidth(); i += 20) {
            g.drawLine(i, 0, i, getHeight());
        }

        for (int i = 0; i <= getHeight(); i += 20) {
            g.drawLine(0, i, getWidth(), i);
        }

        g.setColor(Color.black);
        g.translate(0, getHeight());

        //for (double i = 0; i < time; i += 0.001) {
        p.apply(0.01);
        g.fillOval((int) p.getX(), (int) -p.getY(), 20, 20);
        //}

        g.setColor(Color.green);
        g.drawLine(0, 0, (int) force.getX(), (int) -force.getY());

        g.setColor(Color.magenta);
        g.fillOval((int) apexX, (int) -apexY, 10, 10);
    }
}
