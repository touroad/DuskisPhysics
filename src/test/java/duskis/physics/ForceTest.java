package duskis.physics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;

class ForceTest {


    @Test
    void getMagnitude() {
        Force f = new Force(7.0, 3.0);
        Assertions.assertEquals(7.62, f.getMagnitude(), .01);
    }

    @Test
    void getRadians() {
        Force f = new Force(7.0, 3.0);
        Assertions.assertEquals(0.40, f.getRadians(), .01);
    }

    @Test
    void getDegrees() {
        Force f = new Force(7.0, 3.0);
        Assertions.assertEquals(23.19, f.getDegrees(), 0.01);
    }

    @Test
    void add() {
        Force f = new Force(7.0, 3.0);
        Force f2 = new Force(-4.0, 12.0);
        Force add = f.add(f2);

        Assertions.assertEquals(3, add.getX(), 0.01);
        Assertions.assertEquals(15, add.getY(), 0.01);
    }


    @Test
    void normalize() {
        Force f = new Force(4.0, 3.0);
        Force norm = f.normalize();

        Assertions.assertEquals(1, norm.getMagnitude(), 0.01);
        Assertions.assertEquals(0.8, norm.getX(), 0.01);
        Assertions.assertEquals(0.6, norm.getY(), 0.01);
    }

    @Test
    void scale() {
        Force f = new Force(7.0, 3.0);
        Force scale = f.scale(10);

        Assertions.assertEquals(70, scale.getX(), 0.01);
        Assertions.assertEquals(30, scale.getY(), 0.01);
    }

    @Test
    void gravity() {
        /* double perse = 47;
        double angle = 38;
        double y1 = (Math.cos(angle)) * perse;
        double x1 =  (Math.sin(angle)) * perse;
        System.out.println("x1: " + x1 + " y1: " + y1 + " perse: " + perse);

         */


        Force gravity = new Force(0, -9.8);
        Force scaledGravity = gravity.scale(0.1);

        double x = 0.0;
        double y = 0.0;
        Force f1 = new Force(37.0365, 28.9360);

        for (double i = 0; i < 5; i += 0.1) {
            f1 = f1.add(scaledGravity);
            Force scaledBall = f1.scale(0.1);
            x += scaledBall.getX();
            y += scaledBall.getY();
            System.out.println("at " + i + " seconds the x is " + x + " the y is " + y);
        }
    }

    @Test
    void apply() {
        Force force = new Force(37.065, 28.936);
        Projectile p = new Projectile(0, 0, force);
        p.apply(0.001);

        Assertions.assertEquals(0.037065, p.getX(), 0.0001);
        Assertions.assertEquals(0.028926, p.getY(), 0.0001);
    }
}