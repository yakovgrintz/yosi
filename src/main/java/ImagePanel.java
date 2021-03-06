import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() {
        try {
            image = ImageIO.read(new File("profilePic.jpg"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame(),
                    ex.getMessage(),
                    "error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 600, 0, this); // see javadoc for more info on the parameters

    }

}