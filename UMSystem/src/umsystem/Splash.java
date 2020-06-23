/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umsystem;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author SHOVON
 */
public class Splash {
        public static void main(String args[]){
            Frame frame = new Frame();
            frame.setVisible(true);
            
            for(int i=2,x=1;i<=600;i+=4,x++){ 
                frame.setLocation(800-(i+x)/2, 300-x/2);
                frame.setSize(i+3*x , i+x /2 );
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
    }
}


class Frame extends JFrame implements Runnable{
    Thread t1;
    public Frame (){
        super("UMS"); /// this mainly shows the tilte of frame 
        setLayout(new FlowLayout());
        ImageIcon imageIcon1= new ImageIcon( ClassLoader.getSystemResource("umsystem/projectsicons/splashscreen.jpg"));
        Image image1= imageIcon1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2= new ImageIcon(image1);
        
        JLabel jLabel = new JLabel(imageIcon2);
        add(jLabel);
//        Runnable r= new Frame();
//        t1= new Thread(r);
//        t1.start();
          t1= new Thread(this);
          t1.start();
        
    }
     @Override
    public void run() {
        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
    
    
    
}
