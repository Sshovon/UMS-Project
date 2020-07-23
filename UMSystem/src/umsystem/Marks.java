package umsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Marks extends JFrame {
    JTextArea jt;
    JPanel jp;

    public Marks(){};
    public Marks(String text) {
        setBounds(450,200,500,600);
        setLayout(new BorderLayout());
        jp=new JPanel();
        jt=new JTextArea(50,15);
        jt.setFont(new Font("",Font.BOLD,18));
        JScrollPane jsp = new JScrollPane(jt);
        add(jp,"North");
        add(jsp,"Center");

        getResult(text);


    }
    public void getResult(String s){
        try{
            conn con= new conn();
            jt.setText("\tResult of Examination\n\nSubject\n");
            ResultSet rs=con.s.executeQuery("select * from subjects where registration="+s);
            if(rs.next()){
                jt.append("\n\t"+rs.getString("sub1"));
                jt.append("\n\t"+rs.getString("sub2"));
                jt.append("\n\t"+rs.getString("sub3"));
                jt.append("\n\n\n");
            }
            ResultSet rs2=con.s.executeQuery("select * from marks where registration="+s);
            jt.setFont(new Font("",Font.ITALIC,17));
            jt.append("Marks of corresponding Subjects\n");
            if(rs2.next()){
                jt.append("\n\t"+rs2.getString("mark1"));
                jt.append("\n\t"+rs2.getString("mark2"));
                jt.append("\n\t"+rs2.getString("mark3"));
                jt.append("\n\n");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        //new Marks("123").setVisible(true);
    }
}
