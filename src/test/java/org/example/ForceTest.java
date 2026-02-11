package org.example;

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
        assertEquals(0.40,  f.getRadians(), .01);
    }

    @Test
    void testGetDegrees() {
        Force f = new Force(7.0, 3.0);
        assertEquals(23.19,  f.getDegrees(), 0.01);
    }

    /*@Test
    void testAdd() {
        Force f = new Force(7.0, 3.0);
        Force f2 = new Force(-4.0, 12.0);

    }

     */
}