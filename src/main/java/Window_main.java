import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window_main extends JFrame  {
    JPanel originImage, buttonsPanel, newImage;
//    public BufferedImage image;
    int ELEMENT_WIDTH=100;
    int ELEMENT_HEIGHT=50;

    Window_main() throws IOException {

        ImageIcon myPicture = new ImageIcon("profilePic.jpg");
        JLabel picLabel = new JLabel(myPicture);
//        picLabel.setBounds(10,10,100,100);

        picLabel.setVisible(true);

        JLabel enterProfile= new JLabel("ENTER PROFILE");
        enterProfile.setVisible(true);


        JTextField textField=new JTextField();
        textField.setBackground(Color.cyan);
        textField.setVisible(true);

        JButton button= new JButton("send");
        button.setVisible(true);




        originImage= new JPanel();
        originImage.setBounds(0,0,300,900);
        originImage.setBackground(Color.orange);
        originImage.setVisible(true);
        originImage.setLayout(null);

        originImage.add(picLabel).setBounds((originImage.getWidth()-myPicture.getIconWidth())/2,150,myPicture.getIconWidth(),myPicture.getIconHeight());

        buttonsPanel= new JPanel();
        buttonsPanel.setBounds(300,0,300,900);
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.setVisible(true);
        buttonsPanel.setLayout(null);
        buttonsPanel.add(enterProfile).setBounds((buttonsPanel.getWidth()-ELEMENT_WIDTH)/2,10,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(textField).setBounds(enterProfile.getX(),enterProfile.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button).setBounds(textField.getX(),textField.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);


        newImage= new JPanel();
        newImage.setBounds(600,0,300,900);
        newImage.setBackground(Color.GREEN);
        newImage.setVisible(true);

//        // הגדרת חלון בסיסית
        this.add(originImage);
        this.add(buttonsPanel);
        this.add(newImage);
        this.setTitle("IMAGE PROCCESSING");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //פונקצייה מובנית הבונה את גודל החלון בהתאם לגודל הפנלים
        this.setSize(900,900);
        //נראות ומיקום החלון
        this.setVisible(true);
        this.setLocationRelativeTo(null);

//        try {
//            image = ImageIO.read(new File("C:\\files2\\profilePic.jpg"));
//        } catch (IOException ex) {
//            // handle exception...
//        }






    }


    public static void main(String[] args) throws Exception {
        // יצירת חלון משחק חדש
        new Window_main();
    }
}
