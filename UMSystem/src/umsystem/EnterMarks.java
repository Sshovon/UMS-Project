package umsystem;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterMarks extends JFrame implements ActionListener {

    JLabel title,regiNo,marks,subs;
    JTextField tfregi,s1,s2,s3,m1,m2,m3;
    JButton submit;
    public EnterMarks(){
        super("Enter Marks");
            setSize(500,550);
            setLocation(400,200);
            setLayout(null);
            getContentPane().setBackground(Color.WHITE);

            title= new JLabel("Enter marks ");
            title.setFont(new Font("",Font.BOLD,25));
            title.setBounds(50,0,200,50);
            add(title);

            regiNo= new JLabel("Enter Registration No.");
            regiNo.setBounds(50,100,150,30);
            add(regiNo);

            tfregi= new JTextField();
            tfregi.setBounds(200,100,250,30);
            add(tfregi);

            subs= new JLabel("Enter Subjects");
            subs.setBounds(100,150,100,30);
            add(subs);


            marks= new JLabel("Enter Marks");
            marks.setBounds(250,150,100,30);
            add(marks);

            s1 = new JTextField();
            s1.setBounds(50,200,200,30);
            add(s1);

            m1= new JTextField();
            m1.setBounds(250,200,200,30);
            add(m1);

            s2 = new JTextField();
            s2.setBounds(50,250,200,30);
            add(s2);

            m2= new JTextField();
            m2.setBounds(250,250,200,30);
            add(m2);



            s3 = new JTextField();
            s3.setBounds(50,300,200,30);
            add(s3);

            m3= new JTextField();
            m3.setBounds(250,300,200,30);
            add(m3);

            submit=new JButton("Submit");
            submit.setForeground(Color.white);
            submit.setBackground(Color.BLACK);
            submit.setBounds(200,400,100,50);
            submit.setFont(new Font("",Font.BOLD,15));
            add(submit);
            submit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            String sregi= tfregi.getText();
            System.out.println(sregi);
            String ss1=s1.getText();
            String ss2=s2.getText();
            String ss3=s3.getText();
            String sm1=m1.getText();
            String sm2=m2.getText();
            String sm3=m3.getText();
            try{
                conn con= new conn();
                String query1="insert into subjects values('"+sregi+ "' , '"+ss1+"' , '" +ss2+"' , '"+ss3+ "' ) ";
                String query2="insert into marks values('"+sregi+ "' , '"+sm1+"' , '" +sm2+"' , '"+sm3+ "' ) ";
                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
                this.setVisible(false);
                this.dispose();

            }catch (Exception e){
                System.out.println(e);
            }


        }

    }

    public static void main(String[] args) {
        new EnterMarks().setVisible(true);
    }
}
