import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Making a GUI");
        JFrame window = new JFrame("Making GUI");
        window.setVisible(true);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel control = new JPanel();
        JButton button = new JButton("Button 1");
        JButton newButton = new JButton("Button 2");
        control.add(button);
        window.add(control);
        button.addActionListener(e -> {
            System.out.println("Did you push the button?");
            JPanel panel = new JPanel();
            panel.setLayout(BoxLayout.Y_AXIS);
        });

    }

}