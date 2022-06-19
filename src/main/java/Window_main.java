import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Window_main extends JFrame  {
    final int SCREEN_WIDTH=900;
    final int SCREEN_HEIGHT=900;

    static JPanel originImagePanel, buttonsPanel, newImagePanel;

    JButton searchFacebookProfile,tryButton;
    public BufferedImage image;
    int ELEMENT_WIDTH=150;
    int ELEMENT_HEIGHT=50;
    static ImageIcon myPicture,copyOfPicture;
    static JLabel picLabel,picLabel2;
    ChromeDriver driver ;
    static BufferedImage scanImage, scanImage2;


    Window_main()  {







        JLabel enterProfile= new JLabel("ENTER PROFILE");
        JLabel originImageText= new JLabel("Original Image");
        JLabel newImageText= new JLabel("New Image");


        JTextField textField=new JTextField();

        searchFacebookProfile= new JButton("send");
        searchFacebookProfile.setBackground(new Color(3,168,36));

        //add these buttons after the image was loaded











        originImagePanel = new JPanel();
        originImagePanel.setBounds(0,0,SCREEN_WIDTH/3,SCREEN_HEIGHT);
        originImagePanel.setBackground(Color.orange);
        originImagePanel.setVisible(true);
        originImagePanel.setLayout(null);
        originImagePanel.add(originImageText).setBounds((originImagePanel.getWidth()-ELEMENT_WIDTH)/2,10,ELEMENT_WIDTH,ELEMENT_HEIGHT);

//        originImagePanel.add(picLabel).setBounds((originImagePanel.getWidth()-myPicture.getIconWidth())/2,150,myPicture.getIconWidth(),myPicture.getIconHeight());

        buttonsPanel= new JPanel();
        buttonsPanel.setBounds(originImagePanel.getX()+originImagePanel.getWidth(),0,SCREEN_WIDTH/3,SCREEN_HEIGHT);
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.setVisible(true);
        buttonsPanel.setLayout(null);
        buttonsPanel.add(enterProfile).setBounds((buttonsPanel.getWidth()-ELEMENT_WIDTH)/2,10,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(textField).setBounds(enterProfile.getX(),enterProfile.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        buttonsPanel.add(searchFacebookProfile).setBounds(textField.getX(),textField.getY()+ELEMENT_HEIGHT,ELEMENT_WIDTH,ELEMENT_HEIGHT);

        tryButton= new JButton("TRY");
        tryButton.setBackground(new Color(3,168,36));


        newImagePanel = new JPanel();
        newImagePanel.setBounds(buttonsPanel.getX()+buttonsPanel.getWidth(),0,SCREEN_WIDTH/3,SCREEN_HEIGHT);
        newImagePanel.setBackground(Color.GREEN);
        newImagePanel.setVisible(true);
        newImagePanel.setLayout(null);
        newImagePanel.add(newImageText).setBounds((newImagePanel.getWidth()-ELEMENT_WIDTH)/2,10,ELEMENT_WIDTH,ELEMENT_HEIGHT);
        this.add(newImagePanel).setBounds(600,0,300,900);
        this.add(buttonsPanel).setBounds(300,0,300,900);

        this.add(originImagePanel).setBounds(0,0,300,900);
//        originImagePanel.add(tryButton).setBounds((originImagePanel.getWidth()-ELEMENT_WIDTH)/2,500,ELEMENT_WIDTH,ELEMENT_HEIGHT);





        searchFacebookProfile.addActionListener( (event) -> {
            String profileName = textField.getText();
            try {
                downloadImage(profileName);


            } catch (IOException e) {
                e.printStackTrace();
            }
        });



//        // הגדרת חלון בסיסית




        this.setTitle("IMAGE PROCCESSING");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //פונקצייה מובנית הבונה את גודל החלון בהתאם לגודל הפנלים
        this.setSize(900,900);
        this.setLayout(null);
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

        originImagePanel.removeAll();
        driver = new ChromeDriver();
        driver.get("https://facebook.com/"+profileName);
        // find the element of the profile photo and store it in folder PC - optional - I guss there is another ways

//        List<WebElement> elements = driver.findElements(By.tagName("img"));
//        //צריך לשנות לתמונה הזו
////        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='b3onmgus e5nlhep0 ph5uu5jm ecm0bbzt spb7xbtv bkmhp75w emlxlaya s45kfl79 cwj9ozl2']//div[@class='q9uorilb l9j0dhe7 pzggbiyp du4w35lb']//*[name()='svg']//*[name()='g' and contains(@mask,'url(#jsc_c')]//*[name()='image' and contains(@x,'0')]"));
//
//        for(WebElement element: elements){
//            String s = element.getAttribute("data-imgperflogname");
//            if (s!= null) {
//                String src = element.getAttribute("src");
//                URL imageUrl = new URL(src);
//                image = ImageIO.read(imageUrl);
//                File file = new File("C:\\files2\\profilePic.jpg");
//                ImageIO.write(image, "jpg", file);
//                File copy= new File("C:\\files2\\profilePicCopy.jpg");
//                ImageIO.write(image, "jpg", copy);
//            }
//        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//div[@class='b3onmgus e5nlhep0 ph5uu5jm ecm0bbzt spb7xbtv bkmhp75w emlxlaya s45kfl79 cwj9ozl2']//div[@class='q9uorilb l9j0dhe7 pzggbiyp du4w35lb']//*[name()='svg']//*[name()='g' and contains(@mask,'url(#jsc_c')]//*[name()='image' and contains(@x,'0')]"));
        String src = element.getAttribute("xlink:href");
        URL imageUrl = new URL(src);
        scanImage = ImageIO.read(imageUrl);
        scanImage2 = ImageIO.read(imageUrl);
//        image = ImageIO.read(url);
//        File file = new File("C:\\files2\\profilePic.jpg");
//        ImageIO.write(scanImage, "jpg", file);
        File copy= new File("C:\\files2\\profilePicCopy.jpg");
        ImageIO.write(scanImage, "jpg", copy);
//        if (enter1())
//           textField.setVisible(false);
        driver.quit();

        addButtons();

    }
    public void addButtons() throws IOException {
        myPicture = new ImageIcon(scanImage);
        copyOfPicture= new ImageIcon(scanImage2);
        picLabel = new JLabel(myPicture);
        picLabel2=new JLabel(copyOfPicture);
        newImagePanel.removeAll();
        //אפשר לעשות מערך של כפתורים במקום
        originImagePanel.add(picLabel).setBounds((originImagePanel.getWidth()-myPicture.getIconWidth())/2,150,myPicture.getIconWidth(),myPicture.getIconHeight());
        originImagePanel.revalidate();


        newImagePanel.add(picLabel2).setBounds((newImagePanel.getWidth()-myPicture.getIconWidth())/2,150,myPicture.getIconWidth(),myPicture.getIconHeight());
        newImagePanel.revalidate();

        //שלושת השורות האלו זה רק נסיון ליצור BufferedImage מה copy כדי לשלוח לפונקציות
        File test= new File("C:\\files2\\profilePicCopy.jpg");
        BufferedImage imgToTest= ImageIO.read(test);
        ImageIO.write(imgToTest, "jpg", test);





        JButton button1= new JButton("Grayscale");
        button1.addActionListener( (event) -> {

            try {
                //זה קורא לפונקציה אבל נופל שם בסוף בתהליך כתיבת הקובץ
//                Actions.grey(imgToTest);
//                Actions.grayScale(imgToTest);
//                Actions.Grayscale(scanImage2);
                  Actions.Grayscale(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        JButton button2= new JButton("Color Shift Right");
        JButton button3= new JButton("Color Shift Left");
        JButton button4= new JButton("Mirror");
        button4.addActionListener( (event) -> {

            try {
                //זה קורא לפונקציה אבל נופל שם בסוף בתהליך כתיבת הקובץ
//                Actions.grey(imgToTest);
//                Actions.grayScale(imgToTest);
//                Actions.Grayscale(scanImage2);
                Actions.mirror(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        JButton button5= new JButton("Show Borders");
        JButton button6= new JButton("Eliminate Red/Green/Blue");
        JButton button7= new JButton("Negative");
        button7.addActionListener( (event) -> {

            try {
                //זה קורא לפונקציה אבל נופל שם בסוף בתהליך כתיבת הקובץ
//                Actions.grey(imgToTest);
//                Actions.grayScale(imgToTest);
//                Actions.Grayscale(scanImage2);
                Actions.negative(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
        JButton button8= new JButton("Contract");
        JButton button9= new JButton("Sepia");
        button9.addActionListener( (event) -> {

            try {
                //זה קורא לפונקציה אבל נופל שם בסוף בתהליך כתיבת הקובץ
//                Actions.grey(imgToTest);
//                Actions.grayScale(imgToTest);
//                Actions.Grayscale(scanImage2);
                Actions.sepia(scanImage2);

            } catch (Exception e) {
                System.out.println("nothing");
            }
        });
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
    //    public static void Grayscale(BufferedImage img){
//        //get image width and height
//        int width = img.getWidth();
//        int height = img.getHeight();
//
//        //convert to grayscale
//        for(int y = 0; y < height; y++){
//            for(int x = 0; x < width; x++){
//                int p = img.getRGB(x,y);
//
//                int a = (p>>24)&0xff;
//                int r = (p>>16)&0xff;
//                int g = (p>>8)&0xff;
//                int b = p&0xff;
//
//                //calculate average
//                int avg = (r+g+b)/3;
//
//                //replace RGB value with avg
//                p = (a<<24) | (avg<<16) | (avg<<8) | avg;
//
//                img.setRGB(x, y, p);
//            }
//        }
//
//        try{
//        File output =new File("C:\\files2\\027.png");
//        ImageIO.write(img,"png",output);
//        updatePhoto();
//
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
    public static void updatePhoto(){
        newImagePanel.removeAll();
//        ImageIcon copyOfPicture2= new ImageIcon("C:\\files2\\027.jpg");
        JLabel picLabel3=new JLabel(new ImageIcon( scanImage2));



        try{
            newImagePanel.add(picLabel3).setBounds((newImagePanel.getWidth()-copyOfPicture.getIconWidth())/2,150,copyOfPicture.getIconWidth(),myPicture.getIconHeight());
            newImagePanel.setLayout(null);
            newImagePanel.revalidate();
            picLabel3.setVisible(true);
        }catch (Exception e){
            System.out.println("dont add");
        }







    }




    public static void main(String[] args) throws Exception {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\files2\\chromedriver.exe");

        // יצירת חלון משחק חדש
        new Window_main();
    }
}
