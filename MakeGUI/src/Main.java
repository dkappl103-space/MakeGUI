import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Making a GUI");
        //Makes a new Jframe called window to make a GUI to mess with
        JFrame window = new JFrame("Making GUI");
        //Sets the window size
        window.setSize(500, 500);
        //Makes it close when you close the window
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //New panel called control
        JPanel control = new JPanel();
        //Changes the layout to a grid layout (With 10 rows and 10 columns)
        control.setLayout(new GridLayout(10, 10));
        control.setPreferredSize(new Dimension(400, 400));

        //Add 30 buttons to press :)
        for (int i = 1; i <= 30; i++) {
            JButton button = new JButton("Button " + i);
            //Action thingy
            button.addActionListener(e -> {
                control.remove(button);
                control.revalidate();
                control.repaint();
            });
            //Adds a button to the screen
            control.add(button);
        }
        //Makes a panel called control inside the window
        window.add(control);
        //Makes the window visible, so you can actually mess with it
        window.setVisible(true);
    }
}
