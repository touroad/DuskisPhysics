package duskis.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GravityFrame extends JFrame {

    public GravityFrame() {
        setSize(300, 400);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //IMPORTANT, thus tells it to close when you hit the x button

        setLayout(new BorderLayout());

        GravityComponent gravityComponent = new GravityComponent();
        add(gravityComponent, BorderLayout.CENTER);

        JTextField xfield = new JTextField("37.065");
        JTextField yfield = new JTextField("28.9360");
        JTextField timefield = new JTextField("5");

        JLabel forceX = new JLabel("Force X: ");
        JLabel forceY = new JLabel("Force Y: ");
        JLabel time = new JLabel("Time: ");

        JButton button = new JButton("Draw");

        JPanel northPanel = new JPanel();
        northPanel.add(forceX);
        northPanel.add(xfield);
        northPanel.add(forceY);
        northPanel.add(yfield);
        northPanel.add(time);
        northPanel.add(timefield);
        northPanel.add(button);

        JLabel angle = new JLabel("Angle: ");
        JLabel magnitude = new JLabel("Magnitude: ");
        northPanel.add(angle);
        northPanel.add(magnitude);
        angle.setVisible(false);
        magnitude.setVisible(false);
        add(northPanel, BorderLayout.NORTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravityComponent.setForce(
                        new Force(
                                Double.parseDouble(xfield.getText()),
                                Double.parseDouble(yfield.getText())
                        ));
                gravityComponent.setTime(
                        Double.parseDouble(timefield.getText())
                );

                angle.setVisible(true);
                magnitude.setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}
