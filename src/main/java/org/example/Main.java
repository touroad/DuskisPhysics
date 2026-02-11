package org.example;

public class Main {
    public static void main(String[] args) {
        Force f = new Force(7.0, 3.0);
        Force f2 = new Force(-4.0, 12.0);
        System.out.println("x: " + f.getX() + " the y: " + f.getY() + " magnitude: " + f.getMagnitude() + " radians: " + f.getRadians() + " degrees: " + f.getDegrees());
        System.out.println("x: " + f2.getX() + " the y: " + f2.getY() + " magnitude: " + f2.getMagnitude() + " radians: " + f2.getRadians() + " degrees: " + f2.getDegrees());
    }
}