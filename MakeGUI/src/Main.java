import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Making a GUI");
        JFrame window = new JFrame("Making GUI");
        window.setSize(500, 500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel control = new JPanel();
        control.setLayout(new GridLayout(10, 10)); // Set layout on the panel
        control.setPreferredSize(new Dimension(400, 400));

        // Create and add 30 buttons, each with its own listener
        for (int i = 1; i <= 30; i++) {
            JButton button = new JButton("Button " + i);

            // Add action listener to remove the button when clicked
            button.addActionListener(e -> {
                control.remove(button);
                control.revalidate();
                control.repaint();
            });

            control.add(button); // Add button to the panel
        }

        window.add(control);
        window.setVisible(true);
    }
}
