import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Window_main extends JFrame  {
    JPanel originImage, buttonsPanel, newImage;
    JButton searchFacebookProfile;
    public BufferedImage image;
    int ELEMENT_WIDTH=100;
    int ELEMENT_HEIGHT=50;
    ImageIcon myPicture;
    JLabel picLabel;
    ChromeDriver driver ;


    Window_main() throws IOException {

//        ImageIcon myPicture = new ImageIcon("profilePic.jpg");






        JLabel enterProfile= new JLabel("ENTER PROFILE");
        JLabel originImageText= new JLabel("Original Image");
        JLabel newImageText= new JLabel("New Image");


        JTextField textField=new JTextField();

        searchFacebookProfile= new JButton("send");
        searchFacebookProfile.setBackground(new Color(3,168,36));

        //add these buttons after the image was loaded











        originImage= new JPanel();
        originImage.setBounds(0,0,300,900);
        originImage.setBackground(Color.orange);
        originImage.setVisible(true);
        originImage.setLayout(null);
        originImage.add(originImageText).setBounds((originImage.getWidth()-ELEMENT_WIDTH)/2,10,ELEMENT_WIDTH,ELEMENT_HEIGHT);

//        originImage.add(picLabel).setBounds((originImage.getWidth()-myPicture.getIconWidth())/2,150,myPicture.getIconWidth(),myPicture.getIconHeight());

        buttonsPanel= new JPanel();
        buttonsPanel.setBounds(300,0,300,900);
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.setVisible(true);
        buttonsPanel.setLayout(null);
        buttonsPanel.add(enterProfile).setBounds((buttonsPanel.getWidth()-ELEMENT_WIDTH)/2,10,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(textField).setBounds(enterProfile.getX(),enterProfile.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(searchFacebookProfile).setBounds(textField.getX(),textField.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);


        newImage= new JPanel();
        newImage.setBounds(600,0,300,900);
        newImage.setBackground(Color.GREEN);
        newImage.setVisible(true);
        newImage.setLayout(null);

        searchFacebookProfile.addActionListener( (event) -> {
            String profileName = textField.getText();
            try {
               downloadImage(profileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });



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
    public void downloadImage(String profileName) throws IOException {


        driver = new ChromeDriver();
        driver.get("https://facebook.com/"+profileName);
        // find the element of the profile photo and store it in folder PC - optional - I guss there is another ways

        List<WebElement> elements = driver.findElements(By.tagName("img"));
        //צריך לשנות לתמונה הזו
//        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='b3onmgus e5nlhep0 ph5uu5jm ecm0bbzt spb7xbtv bkmhp75w emlxlaya s45kfl79 cwj9ozl2']//div[@class='q9uorilb l9j0dhe7 pzggbiyp du4w35lb']//*[name()='svg']//*[name()='g' and contains(@mask,'url(#jsc_c')]//*[name()='image' and contains(@x,'0')]"));

        for(WebElement element: elements){
            String s = element.getAttribute("data-imgperflogname");
            if (s!= null) {
                String src = element.getAttribute("src");
                URL imageUrl = new URL(src);
                image = ImageIO.read(imageUrl);
                File file = new File("C:\\files2\\profilePic.jpg");
                ImageIO.write(image, "jpg", file);
            }
        }
        if (enter1())
//           textField.setVisible(false);
            addButtons();

    }
    public void addButtons(){
        myPicture = new ImageIcon("C:\\files2\\profilePic.jpg");
        picLabel = new JLabel(myPicture);
        //אפשר לעשות מערך של כפתורים במקום
        originImage.add(picLabel).setBounds((originImage.getWidth()-myPicture.getIconWidth())/2,150,myPicture.getIconWidth(),myPicture.getIconHeight());

        JButton button1= new JButton("Grayscale");
        JButton button2= new JButton("Color Shift Right");
        JButton button3= new JButton("Color Shift Left");
        JButton button4= new JButton("Mirror");
        JButton button5= new JButton("Show Borders");
        JButton button6= new JButton("Eliminate Red/Green/Blue");
        JButton button7= new JButton("Negative");
        JButton button8= new JButton("Contract");
        JButton button9= new JButton("Sepia");
        JButton button10= new JButton("Ligher");
        JButton button11= new JButton("Darker");
        buttonsPanel.add(button1).setBounds(searchFacebookProfile.getX(),searchFacebookProfile.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button2).setBounds(button1.getX(),button1.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button3).setBounds(button2.getX(),button2.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button4).setBounds(button3.getX(),button3.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button5).setBounds(button4.getX(),button4.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button6).setBounds(button5.getX(),button5.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button7).setBounds(button6.getX(),button6.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button8).setBounds(button7.getX(),button7.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button9).setBounds(button8.getX(),button8.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button10).setBounds(button9.getX(),button9.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(button11).setBounds(button10.getX(),button10.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);

        buttonsPanel.revalidate();

    }
    public static boolean enter1(){
        System.out.println("enter number 1");
        Scanner s= new Scanner(System.in);
        if(s.nextInt()==1){
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws Exception {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\files2\\chromedriver.exe");

        // יצירת חלון משחק חדש
        new Window_main();
    }
}
