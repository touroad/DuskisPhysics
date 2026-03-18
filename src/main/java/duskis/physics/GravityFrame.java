package duskis.physics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GravityFrame extends JFrame {

    public GravityFrame() {
        setSize(300, 400);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //IMPORTANT, thus tells it to close when you hit the x button

        setLayout(new GridBagLayout());

        JTextField xfield = new JTextField("37.065");
        JTextField yfield = new JTextField("28.9360");
        JTextField timefield = new JTextField("5");
        JTextField apexfield = new JTextField("109.44, 42.71");

        JLabel forceX = new JLabel("Force X: ");
        JLabel forceY = new JLabel("Force Y: ");
        JLabel time = new JLabel("Time: ");

        JLabel angle = new JLabel("Angle: ");
        JLabel magnitude = new JLabel("Magnitude: ");
        JLabel apex = new JLabel("Apex: ");

        GravityComponent gravityComponent = new GravityComponent();
        GravityController gravityController = new GravityController(
                gravityComponent,
                xfield,
                yfield,
                timefield,
                apexfield,
                forceX,
                forceY,
                time,
                apex,
                angle,
                magnitude);

        gravityComponent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gravityController.updateForce(e.getX(), (gravityComponent.getHeight() - e.getY()));
            }

            @Override
            public void mousePressed(MouseEvent e) {

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

        JButton button = new JButton("Draw");

        GridBagConstraints constraints;

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(forceX, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(xfield, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(forceY, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(yfield, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(time, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(timefield, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        add(angle, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        add(magnitude, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 5;
        add(apex, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 5;
        add(apexfield, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.NORTH;
        add(button, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 7;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        add(gravityComponent, constraints);


        angle.setVisible(false);
        magnitude.setVisible(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravityController.updateButtonInput(
                        Double.parseDouble(xfield.getText()),
                        Double.parseDouble(yfield.getText()),
                        Double.parseDouble(timefield.getText())
                );
                angle.setVisible(true);
                magnitude.setVisible(true);
            }
        });

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    gravityComponent.repaint();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }


    public static void main(String[] args) {
        GravityFrame frame = new GravityFrame();
        frame.setVisible(true);
    }
}
