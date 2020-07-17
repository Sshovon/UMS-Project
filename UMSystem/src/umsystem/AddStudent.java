package umsystem;

import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {

    JButton jBSubmit,jBCancel;
    JComboBox subComboBox,courseComboBox;
    JTextField tfName,tfFatherName,tfDOB,tf_present_address,tfEmail,tfRegi,tfssc,tfHsc,jtPhone;



    Random ran = new Random();
    long first4 = ((ran.nextLong() % 9999));
    long first = (first4+9999) % 9999; /// handle negative

    public AddStudent(){
        super("New Student Admission");
        //setLayout(null); /// custom layout
        getContentPane().setBackground(Color.white);
        setSize(900,700);
        setLocation(400,200);
        setVisible(true);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/fourth.jpg"));
        Image image=imageIcon.getImage().getScaledInstance(1400,700,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel jl = new JLabel(imageIcon1);
        add(jl);

        JLabel stDetails = new JLabel("New Student Details");
        //stDetails.setBackground(Color.black);
        //stDetails.setForeground(Color.black);
        //stDetails.setBounds(320,30,500,50);
        //stDetails.setFont(new Font("",Font.ROMAN_BASELINE,28));
        //jl.add(stDetails);

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
        tfRegi.setText("201733"+ first);
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
            String spa=tf_present_address.getText();
            String scourse=(String)courseComboBox.getSelectedItem();
            String ssubject=(String)subComboBox.getSelectedItem();

            try{
                conn c=new conn();
                String query="insert into student_values ('"+sname+"', '"+sfname+"' , '"+sdob +"' , '"+sphone+"' , '"+spa+"', '"+semail+"' , '"+sregi +"' , '"+ sssc+"' , '"+shsc + "' , '"+ scourse+"' , '"+ ssubject +"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Successfully inserted new information");
                this.setVisible(false);
                this.dispose();


            } catch (Exception e){
                System.out.println(e);

            }


        }else if(ae.getSource()==jBCancel){
            this.setVisible(false);
            this.dispose();
        }

    }

    public  static void main(String args[]){
        new AddStudent().setVisible(true);
    }

}
