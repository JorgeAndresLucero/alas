/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package personajes;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;



/**
 *
 * @author made
 */
public class Decorator extends Canvas implements KeyListener{
    Universo universo;
    Humano human;
    HumanoDecorado alitas;
    ArrayList<Personaje> hongo;
    Image imgBuffer;
    Graphics miG;
    Timer timer;
    
    public Decorator(){
        universo = new Universo();
        human = new Humano();
        hongo = new ArrayList<Personaje>();
        
        
        for(int i=0; i<2; i++)
            hongo.add(new Hongo());
        
        timer = new Timer();
        setBounds(0, 0, 1000, 1000);
        imgBuffer = new BufferedImage(1000, 1000, BufferedImage.OPAQUE);
        timer.schedule(new Actualizador(), 0, 100);
        
    }
    
    @Override
    public void update(Graphics g){
        paint(g);
    }
    
    @Override
    public void paint(Graphics g){
        Iterator<Personaje> it = hongo.iterator();
        miG = imgBuffer.getGraphics();
	universo.draw(miG);
        	
        while(it.hasNext()){
            it.next().draw(miG);
            
        }
        
        human.draw(miG);
        
        g.drawImage(imgBuffer, 0, 0, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        human.update(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class Actualizador extends TimerTask{

        @Override
        public void run() {
            Iterator<Personaje> it = hongo.iterator();
            human.update();           
            while(it.hasNext()){
                Personaje r = it.next();
                r.update();
            }
            
            Iterator<Personaje> it2 = hongo.iterator();
            while(it2.hasNext()){
                Personaje r = it2.next();
                if(r.getRect().intersects(human.getRect())){
                    hongo.remove(r);
                   
                   
                    r.update();
                    break;
                }   
         
    //volar personaje
                
                    
            }
            
            repaint();
        }
    }
}
        
    
            
    

    
