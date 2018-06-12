
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TOE extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

        public static void main(String args[])throws IOException{
            BufferedImage img = null;
            File f = null;
            //test case
            String caseSelect ="1";
            new TOE().setVisible(true);

            //image is from my desktop for this example
            try{
                f = new File("C:\\Users\\tim\\Desktop\\Toe.jpg");
                img = ImageIO.read(f);
            }catch(IOException e){
                System.out.println(e);
            }

            //get image width and height
            int width = img.getWidth();
            int height = img.getHeight();

            //checking
            System.out.println("height: " + height);
            System.out.println("Width;" + width);

            /*
                This is a proof of concept. future version will have
                selectable cases for different color options
             */
            if (caseSelect == "1") {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        //get pixel value at current height and width
                        int p = img.getRGB(j, i);

                        //get alpha
                        int a = (p >> 24) & 0xff;

                        //get red
                        int r = (p >> 16) & 0xff;

                        //get green
                        int g = (p >> 8) & 0xff;

                        //get blue
                        int b = p & 0xff;

                        //dont touch alpha
                        a = 255;

                        int temp = 0 & 0xff;
                        temp = r;
                        r = g;
                        g = b;
                        b = temp;

                        //set the pixel value
                        p = (a << 24) | (r << 16) | (g << 8) | b;
                        //and place change at current height and width
                        img.setRGB(j, i, p);
                    }
                }
            }


            //write image to desktop
            try{
                f = new File("C:\\Users\\tim\\Desktop\\Toe4.jpg");
                ImageIO.write(img, "jpg", f);
            }catch(IOException e){
                System.out.println(e);
            }

            System.out.println("out" + caseSelect);
        }

        ////////////////////////////////////////////////////////////////////////////////
        //buttons do nothing as of now
        private TOE() {
            super("title bar");
            setSize(320,240);
            setResizable(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new FlowLayout());

            JButton button1 = new JButton("RGB to GBR");
            JButton button2 = new JButton("RGB to BGR");
            JButton button3 = new JButton("RGB to BRG");
            button1.addActionListener(this);
            button2.addActionListener(this);
            button3.addActionListener(this);

            add(button1);
            add(button2);
            add(button3);
        }

        //check when button is clicked
        public void actionPerformed(ActionEvent e){

            System.out.println("color switch selected");
        }
        
    //class ends here
}
