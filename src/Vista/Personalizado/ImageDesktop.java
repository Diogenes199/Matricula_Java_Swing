package Vista.Personalizado;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;


public class ImageDesktop implements Border{

    public BufferedImage imagen_memoria;
    
    public ImageDesktop()
    {
        try
        {
            URL   direccion_imagen=new URL(getClass().getResource("../../Logos/Wallpaper/font2.jpeg").toString());
            imagen_memoria=ImageIO.read(direccion_imagen);
        }catch(IOException ex)
        {
            System.out.println("ERROR "+ex);
        }
    }
    
    @Override
    public void paintBorder(Component c, Graphics g, int eje_x, int eje_y, int width, int height) {
    //g.drawImage(imagen_memoria, (eje_x +(width-imagen_memoria.getWidth())/2),(eje_x +(height-imagen_memoria.getHeight())/2), null);
    
    if (imagen_memoria != null) {
            // Usar Graphics2D para manejar el escalado de la imagen
            Graphics2D g2d = (Graphics2D) g.create();
            Image imagen_escalada = imagen_memoria.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            g2d.drawImage(imagen_escalada, eje_x, eje_y, width, height, null);
            g2d.dispose();
        }

    
    }
    

    @Override
    public Insets getBorderInsets(Component c) {
       return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
    
    
}
