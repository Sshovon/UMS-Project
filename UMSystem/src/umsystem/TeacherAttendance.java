package umsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;

public class TeacherAttendance extends JFrame implements ActionListener {
    Choice regi;
    JButton jBSubmit,jBCancel;
    JTextField jDay,jMonth;


    public TeacherAttendance(){

        setLayout(new GridLayout(4,2,10,10));
        setBounds(400,200,500,400);
        regi=new Choice();
        getAll();
        JLabel selRegi= new JLabel("Select Faculty ID.");
        selRegi.setFont(new Font("",Font.BOLD,15));
        add(selRegi);
        add(regi);

        int dd=new java.util.Date().getDate();
        JLabel day= new JLabel("Day");
        day.setFont(new Font("",Font.BOLD,13));
        add(day);
        jDay=new JTextField();
        jDay.setText(Integer.toString(dd));
        add(jDay);

        int mm=new java.util.Date().getMonth();
        JLabel month= new JLabel("Select Month(MM)");
        month.setFont(new Font("",Font.BOLD,13));
        add(month);

        jMonth=new JTextField();
        jMonth.setText(Integer.toString(mm));
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==jBSubmit){
            String sRegi=regi.getSelectedItem().toString();
            int sDay=Integer.parseInt(jDay.getText());
            int sMonth=Integer.parseInt(jMonth.getText());;
            try{
                conn con = new conn();
                String query="insert into faculty_attendance values('"+sRegi+"','"+sDay+"',' "+sMonth+"')";
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
    void getAll(){
        try{
            conn con = new conn();
            String qurey="select * from faculty_info";
            ResultSet rs=con.s.executeQuery(qurey);
            while(rs.next()){
                regi.add(rs.getString("registration"));
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        new TeacherAttendance().setVisible(true);
    }
}
