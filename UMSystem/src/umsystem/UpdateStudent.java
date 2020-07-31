package umsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStudent extends JFrame implements ActionListener {

    JButton jBSubmit,jBCancel;
    JComboBox subComboBox,courseComboBox;
    private JTextField tfName,tfFatherName,tfDOB,tf_present_address,tfEmail,tfssc,tfHsc,jtPhone;
    JTextField tfRegi;
    final String regi;

    public UpdateStudent(String ss) {
        setSize(900,700);
        setLocation(400,200);
        setVisible(true);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/fourth.jpg"));
        Image image=imageIcon.getImage().getScaledInstance(1400,700,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel jl = new JLabel(imageIcon1);
        add(jl);
        JLabel stName= new JLabel("Name");
        stName.setForeground(Color.BLACK);
        stName.setBounds(50,150,100,30);
        stName.setFont(new Font("",Font.BOLD,20));
        jl.add(stName);

        tfName = new JTextField();
        tfName.setBounds(200,150,150,30);
        jl.add(tfName);

        JLabel fatherName= new JLabel("Father's Name");
        fatherName.setForeground(Color.BLACK);
        fatherName.setBounds(400,150,200,30);
        fatherName.setFont(new Font("",Font.BOLD,20));
        jl.add(fatherName);

        tfFatherName = new JTextField();
        tfFatherName.setBounds(600,150,150,30);
        jl.add(tfFatherName);

        JLabel dob = new JLabel("Date of Birth");
        dob.setForeground(Color.BLACK);
        dob.setFont(new Font("",Font.BOLD,20));
        dob.setBounds(50,200,150,30);
        jl.add(dob);

        tfDOB = new JTextField();
        tfDOB.setBounds(200,200,150,30);
        jl.add(tfDOB);

        JLabel phone = new JLabel("Phone");
        phone.setForeground(Color.BLACK);
        phone.setFont(new Font("",Font.BOLD,20));
        phone.setBounds(400,200,150,30);
        jl.add(phone);

        jtPhone = new JTextField();
        jtPhone.setBounds(600,200,150,30);
        jl.add(jtPhone);

        JLabel present_address = new JLabel("Present Address");
        present_address.setForeground(Color.BLACK);
        present_address.setFont(new Font("",Font.BOLD,20));
        present_address.setBounds(50,250,200,30);
        jl.add(present_address);

        tf_present_address = new JTextField();
        tf_present_address.setBounds(250,250,500,30);
        jl.add(tf_present_address);


        JLabel email = new JLabel("Email");
        email.setForeground(Color.BLACK);
        email.setBounds(50,300,150,30);
        email.setFont(new Font("",Font.BOLD,20));
        jl.add(email);

        tfEmail = new JTextField();
        tfEmail.setBounds(200,300,150,30);
        jl.add(tfEmail);


        JLabel registration = new JLabel("Registration No.");
        registration.setForeground(Color.BLACK);
        registration.setBounds(400,300,200,30);
        registration.setFont(new Font("",Font.BOLD,20));
        jl.add(registration);


        tfRegi = new JTextField();
        tfRegi.setBounds(600,300,150,30);
        jl.add(tfRegi);

        JLabel ssc= new JLabel("SSC GPA");
        ssc.setForeground(Color.BLACK);
        ssc.setBounds(50,350,150,30);
        ssc.setFont(new Font("",Font.BOLD,20));
        jl.add(ssc);

        tfssc=new JTextField();
        tfssc.setBounds(200,350,150,30);
        jl.add(tfssc);


        JLabel hsc = new JLabel("HSC GPA");
        hsc.setForeground(Color.BLACK);
        hsc.setBounds(400,350,150,30);
        hsc.setFont(new Font("",Font.BOLD,20));
        jl.add(hsc);

        tfHsc = new JTextField();
        tfHsc.setBounds(600,350,150,30);
        jl.add(tfHsc);

        JLabel selCourse = new JLabel("Courses");
        selCourse.setForeground(Color.BLACK);
        selCourse.setFont(new Font("",Font.BOLD,20));
        selCourse.setBounds(50,400,150,30);
        jl.add(selCourse);

        String courses[] ={
                "B.Tech",
                "BBA",
                "MBA",
                "B.sc",
                "M.sc"
        };
        courseComboBox = new JComboBox(courses);
        courseComboBox.setBackground(Color.white);
        courseComboBox.setBounds(200,400,150,30);
        jl.add(courseComboBox);

        JLabel subjecs= new JLabel("Subjects");
        subjecs.setBounds(400,400,150,30);
        subjecs.setFont(new Font("",Font.BOLD,20));
        subjecs.setForeground(Color.BLACK);
        jl.add(subjecs);


        String subs[]={
                "CSE",
                "EEE",
                "ME",
                "Economics",
                "LAW",
                "Mechanical"
        };
        subComboBox = new JComboBox(subs);
        subComboBox.setBounds(600,400,150,30);
        subComboBox.setBackground(Color.white);
        jl.add(subComboBox);


        jBSubmit = new JButton("Submit");
        jBSubmit.setBackground(Color.BLACK);
        jBSubmit.setForeground(Color.white);
        jBSubmit.setBounds(250,500,150,30);
        jBSubmit.addActionListener(this);
        jl.add(jBSubmit);

        jBCancel = new JButton("Cancel");
        jBCancel.setBackground(Color.BLACK);
        jBCancel.setForeground(Color.white);
        jBCancel.setBounds(500,500,150,30);
        jBCancel.addActionListener(this);
        jl.add(jBCancel);

        getInfo(ss);
        regi = ss;
    }

    void getInfo(String s){
        conn con= new conn();
        System.out.println(s);
        String q1="Select * from student_values where registration='"+s+"'";
        try {
            ResultSet rs=con.s.executeQuery(q1);
            if(rs.next()){
                tfName.setText(rs.getString("name"));
                tfFatherName.setText(rs.getString("fname"));
                tfDOB.setText(rs.getString("dob"));
                jtPhone.setText(rs.getString("phone"));
                tf_present_address.setText(rs.getString("address"));
                tfEmail.setText(rs.getString("email"));
                tfssc.setText(rs.getString("ssc"));
                tfHsc.setText(rs.getString("hsc"));
                tfRegi.setText(rs.getString("registration"));

                Object obj= rs.getString("course");
                courseComboBox.setSelectedItem(obj);
                obj = rs.getString("sub");
                subComboBox.setSelectedItem(obj);
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==jBCancel){
            this.setVisible(false);
            this.dispose();
        }else if(ae.getSource()==jBSubmit){
            conn con = new conn();
            //System.out.println(tfRegi.getText());
            String qq="update student_values set name = '"+tfName.getText()+"', fname= '"+tfFatherName.getText()+"', dob= '"+tfDOB.getText()+"', phone=  '"+jtPhone.getText()+"', address= '"+tf_present_address.getText()+"', email= '"+ tfEmail.getText()+"', ssc= '"+tfssc.getText()+"', hsc ='"+tfHsc.getText()+"', course = '"+courseComboBox.getSelectedItem().toString()+"', sub = '"+subComboBox.getSelectedItem().toString()+"' where registration = '"+ regi +"' ";
            try {
                con.s.executeUpdate(qq);
                JOptionPane.showMessageDialog(null,"Successfully Updated new values");

            } catch (SQLException e) {
                System.out.println(e);
            }
            this.setVisible(true);
            this.dispose();
            new StudentDetails().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new UpdateStudent("123").setVisible(true);
    }
}
