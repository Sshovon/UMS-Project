package umsystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TabularAttendance extends JFrame implements ActionListener {
    JTable jt;
    JButton jprint;
    JButton jb;

    public TabularAttendance(){};

    public TabularAttendance(String s){
        jt=new JTable();
        setBounds(400,200,500,500);
        jt=new JTable();
        getAll(s);
        jt.setFont(new Font("",Font.BOLD,15));
        JScrollPane js= new JScrollPane();
        js.setViewportView(jt);
        add(js,"Center");

        jprint=new JButton("Print");
        jprint.setFont(new Font("",Font.BOLD,18));
        jprint.setForeground(Color.green);
        jprint.setBackground(Color.BLACK);
        jprint.addActionListener(this);
        add(jprint,"South");

        int res=getAll2(s);
        jb=new JButton(Integer.toString(res));
        jb.setFont(new Font("",Font.BOLD,18));
        jb.setForeground(Color.green);
        jb.setBackground(Color.BLACK);
        jb.addActionListener(this);
        add(jb,"North");


    }

    void getAll(String s){
        conn con=new conn();
        String query="Select * from Faculty_attendance where id= '"+s+"'";
        try {
            ResultSet rs=con.s.executeQuery(query);
            jt.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    int getAll2(String s){
        conn con=new conn();
        String query="Select COUNT(id) from Faculty_attendance where id= '"+s+"'";
        try {
            ResultSet rss=con.s.executeQuery(query);
            if(rss.next())
                return rss.getInt("COUNT(id)");
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new TabularAttendance().setVisible(true);
    }
}
