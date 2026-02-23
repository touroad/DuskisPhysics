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

        JTextField xfield = new JTextField("37.065");
        JTextField yfield = new JTextField("28.9360");
        JTextField timefield = new JTextField("5");

        JLabel ForceX = new JLabel("Force X: ");
        JLabel ForceY = new JLabel("Force Y: ");
        JLabel Time = new JLabel("Time: ");

        JButton button = new JButton("Draw");

        JPanel northPanel = new JPanel();
        northPanel.add(ForceX);
        northPanel.add(xfield);
        northPanel.add(ForceY);
        northPanel.add(yfield);
        northPanel.add(Time);
        northPanel.add(timefield);
        northPanel.add(button);

        JLabel Angle = new JLabel("Angle: ");
        JLabel Magnitude = new JLabel("Magnitude: ");
        northPanel.add(Angle);
        northPanel.add(Magnitude);
        Angle.setVisible(false);
        Magnitude.setVisible(false);
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

                Angle.setVisible(true);
                Magnitude.setVisible(true);
            }
        });

        add(gravityComponent, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}
