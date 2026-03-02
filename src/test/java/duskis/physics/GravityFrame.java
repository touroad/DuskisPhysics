package duskis.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GravityFrame extends JFrame {

    public GravityFrame() {
        setSize(300, 400);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //IMPORTANT, thus tells it to close when you hit the x button

        setLayout(new BorderLayout());

        JTextField xfield = new JTextField("37.065");
        JTextField yfield = new JTextField("28.9360");
        JTextField timefield = new JTextField("5");

        GravityComponent gravityComponent = new GravityComponent();
        GravityController gravityController = new GravityController();
        gravityController.gravityComponent = gravityComponent;
        gravityController.xfield = xfield;
        gravityController.yfield = yfield;
        gravityController.timefield = timefield;

        gravityComponent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gravityController.updateForce(e.getX(), (gravityComponent.getHeight() - e.getY()));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mouse pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        gravityComponent.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                gravityController.updateForce(e.getX(), (gravityComponent.getHeight() - e.getY()));
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        add(gravityComponent, BorderLayout.CENTER);

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
                gravityController.updateButton(
                        Double.parseDouble(xfield.getText()),
                        Double.parseDouble(yfield.getText()),
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
