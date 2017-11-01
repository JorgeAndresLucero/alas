/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package personajes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author J0RGE
 */
public class Roca implements Personaje {
    Image imagen = new ImageIcon(getClass().getResource("/imagenes/hongito.png")).getImage();
    int xPos = 0;
    int yPos = 0;
   
    public Roca(){
       
        xPos = -100;
        yPos = -580;
        
        
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        int spriteHeight = imagen.getHeight(null);
        int spriteWidth = imagen.getWidth(null);
        
        

       AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate( xPos , yPos);
        affineTransform.translate(xPos, yPos);

        g2d.drawImage(imagen, affineTransform, null);
    }
    
    
    @Override
    public void update(){ 
     
        xPos = (600 + xPos) % 600;
        yPos = (400 + yPos) % 400;
    }
    @Override
    public Rectangle getRect(){
        Rectangle rect = null;
        rect = new Rectangle(xPos, yPos, imagen.getWidth(null), imagen.getHeight(null));
        return rect;
    }
    
}
