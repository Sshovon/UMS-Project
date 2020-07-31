package umsystem;

import javax.swing.*;
import java.awt.*;

public class AboutUS extends JFrame {

    public AboutUS(){
        super("About Us");
        setBounds(400,200,550,550);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("umsystem\\projectsicons\\thumbsup.png"));
        Image image=imageIcon.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel jl = new JLabel(imageIcon1);
        add(jl);
    }

    public static void main(String[] args) {
        new AboutUS().setVisible(true);
    }
}
