package duskis.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForceTest {


    @Test
    void testGetX() {
        Force f = new Force(7.0, 3.0);
        assertEquals(7.0, f.getX());
    }

    @Test
    void testGetY() {
        Force f = new Force(7.0, 3.0);
        assertEquals(3.0, f.getY());
    }

    @Test
    void testGetMagnitude() {
        Force f = new Force(7.0, 3.0);
        assertEquals(7.62, f.getMagnitude(), .01);
    }

    @Test
    void testGetRadians() {
        Force f = new Force(7.0, 3.0);
        assertEquals(0.40, f.getRadians(), .01);
    }

    @Test
    void testGetDegrees() {
        Force f = new Force(7.0, 3.0);
        assertEquals(23.19, f.getDegrees(), 0.01);
    }

    @Test
    void testAdd() {
        Force f = new Force(7.0, 3.0);
        Force f2 = new Force(-4.0, 12.0);
        Force add = f.add(f2);

        assertEquals(3, add.getX(), 0.01);
        assertEquals(15, add.getY(), 0.01);
    }


    @Test
    void testNormalize() {
        Force f = new Force(4.0, 3.0);
        Force norm = f.normalize();

        assertEquals(1, norm.getMagnitude(), 0.01);
        assertEquals(0.8, norm.getX(), 0.01);
        assertEquals(0.6, norm.getY(), 0.01);
    }

    @Test
    void testScale() {
        Force f = new Force(7.0, 3.0);
        Force scale = f.scale(10);

        assertEquals(70, scale.getX(), 0.01);
        assertEquals(30, scale.getY(), 0.01);
    }

    @Test
    void testGravity() {
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
}
