
package service;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author HP
 */
public class ImageHandler {
    
    private static boolean downloadImage(String remoteUrl,String imagepath)
    {
        try{
            URL url=new URL(remoteUrl);
            InputStream is=url.openStream();
            OutputStream os=new FileOutputStream(imagepath);
            byte[] b=new byte[2048];
            int length=0;
            while((length=is.read(b))!=-1)
            {
                os.write(b,0,length);
            }
            is.close();
            os.close();
            File input=new File(imagepath);
            BufferedImage image=ImageIO.read(input);
            BufferedImage resized= resize(image,1280,720);
               
            File output=new File(imagepath);
            ImageIO.write(resized, "jpg" , output);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    private static boolean copyImage(String remoteUrl,String imagepath) 
    {
        try {
            FileInputStream fis= new FileInputStream(remoteUrl);
            FileOutputStream fos= new FileOutputStream(imagepath);
            BufferedInputStream bin=new BufferedInputStream(fis);
            BufferedOutputStream bou=new BufferedOutputStream(fos);
            int b=0;
            while(b!=-1)
            {
                b=bin.read();
                bou.write(b);
            }
            bin.close();
            bou.close();
            fis.close();
            fos.close();
            File input=new File(imagepath);
            BufferedImage image=ImageIO.read(input);
            BufferedImage resized= resize(image,1280,720);
            File output=new File(imagepath);
            ImageIO.write(resized, "jpg" , output);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public static boolean setImage(String remoteUrl,String imagepath)
    {
        if(remoteUrl.charAt(1)=='t'|remoteUrl.charAt(1)=='T')
            return(downloadImage(remoteUrl, imagepath));
        else
            return(copyImage(remoteUrl, imagepath));
    }
    private static BufferedImage resize(BufferedImage image, int widht, int height)
    {
        Image img=image.getScaledInstance(widht, height, Image.SCALE_SMOOTH);
        BufferedImage resized=new BufferedImage(widht, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d= resized.createGraphics();
        g2d.drawImage(img, 0,0 , null);
        g2d.dispose();
        return resized;
    }
}
