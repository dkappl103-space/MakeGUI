import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Making a GUI");
        //Makes a new Jframe called window
        JFrame window = new JFrame("Making GUI");
        //window size
        window.setSize(500, 500);
        //Makes it close when you close the window
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(null);
        //New panel
        ImagePanel control = new ImagePanel("/CatLaughingMeme.jpg");
        control.setLayout(null);
        //Maximum place the panel (control) will take up
        control.setBounds(0, 0, 500, 500);
        window.add(control);

        //Funny meme stuff (Top Text)
       JLabel titleLabel = new JLabel("Get a load of this guy");
       titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
       titleLabel.setForeground(Color.WHITE);
       titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
       titleLabel.setBounds(0, 10, 500, 40);
       control.add(titleLabel);

        //Funny meme stuff (Botton Text)
        JLabel newtitleLabel = new JLabel("Clicking all over the place");
        newtitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        newtitleLabel.setForeground(Color.WHITE);
        newtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newtitleLabel.setBounds(0, 380, 500, 40);
        control.add(newtitleLabel);



        //For the buttons to be placed at random
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
        //Makes the text for the entry box
        JLabel rate = new JLabel("Rate your experience: ");
        rate.setFont(new  Font("Arial", Font.PLAIN, 16));
        rate.setForeground(Color.WHITE);
        rate.setBounds(0, 420, 200, 25);
        control.add(rate);

        //This allows you to type in a new box
        JTextField rateInput = new JTextField();
        rateInput.setBounds(150, 420, 180, 25);
        control.add(rateInput);

        //Submit the text you just entered for the rating
        JButton submit = new JButton("Submit");
        submit.setBounds(390,420, 80, 25);
        control.add(submit);

        //Prints what you type in the console
        submit.addActionListener(e -> {
           String rating = rateInput.getText();
           System.out.println("Experience rated: " + rating);
           window.dispose();
        });



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
