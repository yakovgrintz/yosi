import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Actions {

    public static void grey(BufferedImage img){


        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();

        //convert to grayscale
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int p = img.getRGB(x,y);

                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                //calculate average
                int avg = (r+g+b)/3;

                //replace RGB value with avg
                p = (a<<24) | (avg<<16) | (avg<<8) | avg;

                img.setRGB(x, y, p);
            }
        }

        //write image
        try{
           File f = new File("D:\\files2\\Output.png");
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println("the problem is here");
            System.out.println(e);
        }

    }
    public static void grayScale(BufferedImage image){
        int width;
        int height;



            try {
                File input = new File("digital_image_processing.jpg");
                image = ImageIO.read(input);
                width = image.getWidth();
                height = image.getHeight();

                for(int i=0; i<height; i++) {

                    for(int j=0; j<width; j++) {

                        Color c = new Color(image.getRGB(j, i));
                        int red = (int)(c.getRed() * 0.299);
                        int green = (int)(c.getGreen() * 0.587);
                        int blue = (int)(c.getBlue() *0.114);
                        Color newColor = new Color(red+green+blue,

                                red+green+blue,red+green+blue);

                        image.setRGB(j,i,newColor.getRGB());
                    }
                }

                File ouptut = new File("C:\\files2\\grayScale.jpg");
                ImageIO.write(image, "jpg", ouptut);

            } catch (Exception e) {
                System.out.println("cant write");
            }
        }

}
