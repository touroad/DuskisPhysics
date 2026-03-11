package duskis.physics;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.mockito.Mockito.*;

class GravityControllerTest {

    @Test
    void updateForce() {
        GravityComponent gravityComponent = mock();
        JTextField xfield = mock();
        JTextField yfield = mock();
        JTextField timefield = mock();
        JTextField apexfield = mock();
        JLabel forceX = mock();
        JLabel forceY = mock();
        JLabel time = mock();
        JLabel apex = mock();
        JLabel angle = mock();
        JLabel magnitude = mock();

        GravityController controller = new GravityController(
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
                magnitude
        );

        controller.updateForce(7, 5);

        verify(gravityComponent).setForce(new Force(7, 5));
        verify(xfield).setText("7.0");
        verify(yfield).setText("5.0");
    }

    @Test
    void updateButtonInput() {
        GravityComponent gravityComponent = mock();
        JTextField xfield = mock();
        JTextField yfield = mock();
        JTextField timefield = mock();
        doReturn("5").when(timefield).getText();
        JTextField apexfield = mock();
        JLabel forceX = mock();
        JLabel forceY = mock();
        JLabel time = mock();
        JLabel apex = mock();
        JLabel angle = mock();
        JLabel magnitude = mock();

        GravityController controller = new GravityController(
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
                magnitude
        );

        controller.updateButtonInput(7, 5, 5);

        verify(gravityComponent).setForce(new Force(7, 5));
        verify(gravityComponent).setTime(5);
    }

    @Test
    void apexLabel() {
        GravityComponent gravityComponent = mock();
        JTextField xfield = mock();
        JTextField yfield = mock();
        JTextField timefield = mock();
        JTextField apexfield = mock();
        JLabel forceX = mock();
        JLabel forceY = mock();
        JLabel time = mock();
        JLabel apex = mock();
        JLabel angle = mock();
        JLabel magnitude = mock();

        GravityController controller = new GravityController(
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
                magnitude
        );
        controller.updateForce(7, 5);

        verify(gravityComponent).setForce(new Force(7, 5));
        verify(apexfield).setText("3.57, 1.28");
    }
}