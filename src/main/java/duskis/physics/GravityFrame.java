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

        JButton button = new JButton("Draw");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravityComponent.setForce(
                        new Force(
                                Double.parseDouble(xfield.getText()),
                                Double.parseDouble(yfield.getText())
                        ));
            }
        });

        JPanel northPanel = new JPanel();
        northPanel.add(xfield);
        northPanel.add(yfield);
        northPanel.add(button);
        add(northPanel, BorderLayout.NORTH);

        add(gravityComponent, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}
