import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window_main extends JFrame  {
    JPanel originImage, buttonsPanel, newImage;
    public BufferedImage image;
    Window_main() throws IOException {

        ImageIcon myPicture = new ImageIcon("profilePic.jpg");
        JLabel picLabel = new JLabel(myPicture);
        picLabel.setBounds(10,10,100,100);
        picLabel.setVisible(true);

        JButton button= new JButton("send");
        button.setSize(100,50);
        button.setVisible(true);

        JTextField textField=new JTextField();
        textField.setBackground(Color.cyan);
        textField.setBounds(button.getX(),button.getY()+button.getHeight(),200,50);
        textField.setVisible(true);


        originImage= new JPanel();
        originImage.setBounds(0,0,300,900);
        originImage.setBackground(Color.orange);
        originImage.setVisible(true);
        originImage.add(picLabel);

        buttonsPanel= new JPanel();
        buttonsPanel.setBounds(300,0,300,900);
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.setVisible(true);
        buttonsPanel.add(button).setLocation(50,50);
        buttonsPanel.add(textField);

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
    public void addComponent(Component component, int x, int y, int width, int height, Font font) {
        //פקודת יישור מימין לשמאל,ויזואלית יפה יותר ל"הוסף מספר" אבל עובדת גם בתיבות טקסט...
//        component.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        component.setBounds(x, y, width, height);
        component.setFont(font);
        this.add(component);
    }


    public static void main(String[] args) throws Exception {
        // יצירת חלון משחק חדש
        new Window_main();
    }
}
