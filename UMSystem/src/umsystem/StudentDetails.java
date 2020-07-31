package umsystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDetails extends JFrame implements ActionListener {

    void getAll(){
        conn con=new conn();
        String qurey="select * from student_values";
        try {
            ResultSet rs=con.s.executeQuery(qurey);
            jt.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    JTable jt;
    JButton addd,del,update;
    JTextField setRegi;

    public StudentDetails(){
        setLayout(null);
        setBounds(400,200,1200,600);
        getContentPane().setBackground(Color.white);

        JLabel title= new JLabel("Student Info");
        title.setBounds(500,50,200,30);
        title.setFont(new Font("",Font.ITALIC|Font.BOLD,25));
        title.setForeground(Color.blue);
        add(title);


        jt= new JTable();
        getAll();
        JScrollPane js= new JScrollPane();
        js.setViewportView(jt);
        js.setBounds(50,100,1100,280);
        add(js);



        JLabel delStudent= new JLabel("Enter Registration No.");
        delStudent.setFont(new Font("",Font.BOLD,18));
        delStudent.setBounds(50,400,200,30);
        add(delStudent);

        setRegi= new JTextField();
        setRegi.setBounds(300,400,250,30);
        add(setRegi);

        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                int selrow=jt.getSelectedRow();
                setRegi.setText(jt.getModel().getValueAt(selrow,7).toString());
            }
        });

        del= new JButton("Delete");
        del.setBounds(560,400,200,30);
        del.setBackground(Color.RED);
        del.setForeground(Color.white);
        del.addActionListener(this);
        add(del);

        addd= new JButton("Add new Student");
        addd.setBounds(300,450,200,30);
        addd.setBackground(Color.GREEN);
        addd.setForeground(Color.BLACK);
        addd.setFont(new Font("",Font.BOLD,18));
        addd.addActionListener(this);
        add(addd);

        update = new JButton("Update Student");
        update.setBounds(550,450,200,30);
        update.setBackground(Color.GREEN);
        update.setForeground(Color.BLACK);
        update.setFont(new Font("",Font.BOLD,18));
        update.addActionListener(this);
        add(update);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()==del){
             String regi=setRegi.getText();
             String q="delete from student_values where registration="+"'"+regi+"'";
             conn con= new conn();
             try {
                 con.s.executeUpdate(q);
                 JOptionPane.showMessageDialog(null,"Successfully Deleted student info");
                 this.setVisible(false);
                 this.dispose();
                 new StudentDetails().setVisible(true);
             } catch (SQLException e) {
                 System.out.println(e);
             }


         }else if(ae.getSource()==addd){
            this.setVisible(false);
            this.dispose();
            new AddStudent().setVisible(true);

         }else if(ae.getSource()==update){
            new UpdateStudent(setRegi.getText()).setVisible(true);
            this.setVisible(false);
            this.dispose();
         }

    }


    public static void main(String[] args) {
        new StudentDetails().setVisible(true);
    }

}
