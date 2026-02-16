package duskis.physics;

import javax.swing.*;
import java.awt.*;

public class GravityComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);

        g.drawLine(0, 0, getWidth(), getHeight());
    }
}
