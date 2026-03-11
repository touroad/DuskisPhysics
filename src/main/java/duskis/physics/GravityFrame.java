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

        add(gravityComponent, BorderLayout.CENTER);

        JButton button = new JButton("Draw");

        JPanel westPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints;

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        westPanel.add(forceX, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        westPanel.add(xfield, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        westPanel.add(forceY, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        westPanel.add(yfield, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        westPanel.add(time, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 2;
        westPanel.add(timefield, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        westPanel.add(angle, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        westPanel.add(magnitude, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 5;
        westPanel.add(apex, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 5;
        westPanel.add(apexfield, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        westPanel.add(button, constraints);


        angle.setVisible(false);
        magnitude.setVisible(false);
        add(westPanel, BorderLayout.WEST);

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
