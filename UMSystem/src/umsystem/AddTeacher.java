package umsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddTeacher extends JFrame implements ActionListener {



    JButton jBSubmit,jBCancel;
    JComboBox subComboBox,courseComboBox;
    JTextField tfName,tfFatherName,tfDOB,tf_present_address,tfEmail,tfRegi,tfssc,tfHsc,jtPhone,tfcgpa;

    Random ran = new Random();
    long first4 = ((ran.nextLong() % 100));
    long first = (first4+100) % 100; /// handle negative

    public AddTeacher(){
        super("New Faculty");
        //setLayout(null);
        setSize(900,700);
        setLocation(400,200);
        setVisible(true);
        getContentPane().setBackground(Color.white);


        ///frame background as jlabel
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/fifth.jpg"));
        Image image=imageIcon.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
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

        JLabel registration = new JLabel("Faculty ID");
        registration.setForeground(Color.BLACK);
        registration.setBounds(400,300,200,30);
        registration.setFont(new Font("",Font.BOLD,20));
        jl.add(registration);

        tfRegi = new JTextField();
        tfRegi.setBounds(600,300,150,30);
        tfRegi.setText("1800"+ first);
        jl.add(tfRegi);

        JLabel ssc= new JLabel("SSC GPA");
        ssc.setForeground(Color.BLACK);
        ssc.setBounds(50,350,100,30);
        ssc.setFont(new Font("",Font.BOLD,20));
        jl.add(ssc);

        tfssc=new JTextField();
        tfssc.setBounds(150,350,100,30);
        jl.add(tfssc);

        JLabel hsc = new JLabel("HSC GPA");
        hsc.setForeground(Color.BLACK);
        hsc.setBounds(325,350,100,30);
        hsc.setFont(new Font("",Font.BOLD,20));
        jl.add(hsc);

        tfHsc = new JTextField();
        tfHsc.setBounds(425,350,100,30);
        jl.add(tfHsc);

        JLabel cgpa = new JLabel("CGPA");
        cgpa.setForeground(Color.BLACK);
        cgpa.setBounds(600,350,100,30);
        cgpa.setFont(new Font("",Font.BOLD,20));
        jl.add(cgpa);

        tfcgpa = new JTextField();
        tfcgpa.setBounds(700,350,100,30);
        jl.add(tfcgpa);

        JLabel selCourse = new JLabel("Education");
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

        JLabel subjecs= new JLabel("Department");
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



    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==jBSubmit){
            String sname = tfName.getText();
            String sfname = tfFatherName.getText();
            String sdob=tfDOB.getText();
            String sphone=jtPhone.getText();
            String semail=tfEmail.getText();
            String sregi=tfRegi.getText();
            String sssc=tfssc.getText();
            String shsc=tfHsc.getText();
            String scgpa=tfcgpa.getText();
            String spa=tf_present_address.getText();
            String scourse=(String)courseComboBox.getSelectedItem();
            String ssubject=(String)subComboBox.getSelectedItem();

            try{
                conn con = new conn();
                String query="insert into faculty_info (name,fname,dob,phone,address,email,registration,ssc,hsc,cgpa,education,dept) " +
                        "values ('" +sname+ "', '"+sfname+"' , '"+sdob +"' , '"+sphone+"' , '"+spa+"', '"+semail+"' , '"+sregi +"' , '"+ sssc+"' , '"+shsc + "' , '"+ scgpa +"' , '"+ scourse+"' , '"+ ssubject +"')";

                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Successfully inserted new faculty information");
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
        new AddTeacher().setVisible(true);
    }
}
