/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import javax.swing.JFrame;
import personajes.Decorator;

/**
 *
 * @author made
 */
public class FormularioPrincipal extends JFrame{
    Decorator canvas;
    
    public FormularioPrincipal(){
        canvas = new Decorator();
        
        setLayout(null);
        getContentPane().add(canvas);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        addKeyListener(canvas);
        setBounds(0, 0, 1000, 1000);
        setVisible(true);

    }


}
