package umsystem;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentAttendanceDetail extends JFrame implements ActionListener {

    JTable jt;
    JButton jprint;

    public StudentAttendanceDetail(){
        setBounds(400,200,500,500);
        jt=new JTable();
        getAll();
        jt.setFont(new Font("",Font.BOLD,15));
        JScrollPane js= new JScrollPane();
        js.setViewportView(jt);
        add(js);

        jprint=new JButton("Print");
        jprint.setFont(new Font("",Font.BOLD,18));
        jprint.setForeground(Color.green);
        jprint.setBackground(Color.BLACK);
        jprint.addActionListener(this);
        add(jprint,"South");

    }

    void getAll(){
        conn con=new conn();
        String query="select registration as Registration, day as Day, month as Month from student_attendance ";
        try {
            ResultSet rs=con.s.executeQuery(query);
            jt.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==jprint){
            try {
                jt.print();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new StudentAttendanceDetail().setVisible(true);
    }
}
