package umsystem;

import javax.swing.*;
import javax.tools.FileObject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentAttendance extends JFrame implements ActionListener {

    Choice regi;
    JButton jBSubmit,jBCancel;
    JTextField jDay,jMonth;


    public StudentAttendance(){

        setLayout(new GridLayout(4,2,10,10));
        setBounds(400,200,500,400);
        regi=new Choice();
        getAll();
        JLabel selRegi= new JLabel("Select Registration No.");
        selRegi.setFont(new Font("",Font.BOLD,15));
        add(selRegi);
        add(regi);

        JLabel day= new JLabel("Select Day(DD)");
        day.setFont(new Font("",Font.BOLD,13));
        add(day);

        jDay=new JTextField();
        add(jDay);

        JLabel month= new JLabel("Select Month(MM)");
        month.setFont(new Font("",Font.BOLD,13));
        add(month);

        jMonth=new JTextField();
        add(jMonth);


        jBSubmit = new JButton("Submit");
        jBSubmit.setBackground(Color.BLACK);
        jBSubmit.setForeground(Color.green);
        jBSubmit.addActionListener(this);
        add(jBSubmit);

        jBCancel = new JButton("Cancel");
        jBCancel.setBackground(Color.BLACK);
        jBCancel.setForeground(Color.red);
        jBCancel.addActionListener(this);
        add(jBCancel);






    }
    void getAll(){
        try{
            conn con = new conn();
            String qurey="select * from student_values";
            ResultSet rs=con.s.executeQuery(qurey);
            while(rs.next()){
                regi.add(rs.getString("registration"));
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==jBSubmit){
            String sRegi=regi.getSelectedItem().toString();
            int sDay=Integer.parseInt(jDay.getText());
            int sMonth=Integer.parseInt(jMonth.getText());;
            try{
                conn con = new conn();
                String query="insert into student_attendance values('"+sRegi+"','"+sDay+"',' "+sMonth+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Successfully inserted new information");
                this.setVisible(false);
                this.dispose();

            }catch (Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource()==jBCancel){
            this.setVisible(false);
            this.dispose();
        }

    }

    public static void main(String[] args) {
        new StudentAttendance().setVisible(true);
    }
}
