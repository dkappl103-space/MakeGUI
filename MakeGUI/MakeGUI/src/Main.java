import javax.swing.*;
import java.awt.*;
import java.util.Random;

//Let me document my current plans for this, first I want to generate a lot of buttons that take up the screen
//Then I need to make all but 1 button invisible, after you click it, it will be removed, and a new one will appear
//This will be random hopefully, to make it different everytime you play the window.
public class Main {
    public static void main(String[] args) {
        System.out.println("Making a GUI");
        //Makes a new Jframe called window to make a GUI to mess with
        JFrame window = new JFrame("Making GUI");
        //Sets the window size
        window.setSize(500, 500);
        //Makes it close when you close the window
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(null);
        //New panel called control
        ImagePanel control = new ImagePanel("/CatLaughingMeme.jpg");

        control.setLayout(null);
        //Maximum place the panel (control) will take up
        control.setBounds(0, 0, 500, 500);
        window.add(control);

        //Sets the panels preferred size
        //control.setPreferredSize(new Dimension(400, 400));

        //Wanted to spice things up a bit with something random
        Random rando = new Random();

        //Add 30 buttons to press :)
        for (int i = 1; i <= 30; i++) {
            JButton button = new JButton("Button " + i);

            //Fixed sizee of the buttons
            int width = 125;
            int height = 50;

            //Random position for the button within the set bounds
            int x = rando.nextInt(450-width);
            int y = rando.nextInt(450-height);

            //this whole section just auto-completed, so I'm going with it
            button.setBounds(x, y, width, height);

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

class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(String imagepath) {
        backgroundImage = new ImageIcon(getClass().getResource("/CatLaughingMeme.jpg")).getImage();


    }
    //This also auto-filled in, I was trying to get an image working
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
