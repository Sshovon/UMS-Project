/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umsystem;

/**
 *
 * @author SHOVON
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField jTF1;
    JPasswordField jPF1;
    JButton jB1,jB2;
    
    Login(){
        super("Login");
        
        setLayout(null); /// custom layout 
         getContentPane().setBackground(Color.WHITE); ///getContentPane is used to apply something in the whole frame
         l1 =new JLabel ("ID" );
         l1.setBounds(40, 20, 100, 30);
         add(l1);
         
         l2= new JLabel("Password");
         l2.setBounds(40,70,100,30);
         add(l2);
         
         jTF1 = new JTextField();
         jTF1.setBounds(150,20,150,30);
         add(jTF1);
         
         jPF1= new JPasswordField();
         jPF1.setBounds(150,70,150,30);
         add(jPF1);
         
         ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/second.jpg"));
         Image image= imageIcon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
         ImageIcon imageIcon2 = new ImageIcon(image);
         
         JLabel jLabel = new JLabel(imageIcon2);
         jLabel.setBounds(350,20,150,150);
         add(jLabel);
         
         jB1= new JButton("Login");
         jB1.setBounds(40,140,120,30);
         jB1.setFont(new Font("serif",Font.BOLD,15));
         jB1.addActionListener(this);
         jB1.setBackground(Color.BLACK);
         jB1.setForeground(Color.WHITE);
         add(jB1);
         
         jB2= new JButton("Cancel");
         jB2.setBounds(180,140,120,30);
         jB2.setFont(new Font("serif",Font.BOLD,15));
         jB2.addActionListener(this);
         jB2.setBackground(Color.BLACK);
         jB2.setForeground(Color.WHITE);
         add(jB2);
         
         setVisible(true);
         setSize(600,300);
         setLocation(500,300);
         
         
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==jB1){
            try{
                    conn c1 = new conn();
                    String userID= jTF1.getText();
                    String password =jPF1.getText();
                    
                    String q = "select * from login where username='"+userID+"' and password='"+password+"';";
                    
                    ResultSet rs= c1.s.executeQuery(q);
                    if(rs.next()){
                        //System.out.println("YO boys");
                        new Project().setVisible(true);
                        this.setVisible(false);
                        this.dispose();
                        
                    }else{
                       JOptionPane.showMessageDialog(null, "Invaid");
                       this.setVisible(false);
                       System.exit(0);
                    }
             
            }catch(Exception e){

             }
        }else if (ae.getSource()==jB2){
            try{
                   System.exit(0);
            }catch(Exception e){
                    
             }
        }
       
    }
    
    public static void main(String args[]){
        new Login();
    }
   
}
