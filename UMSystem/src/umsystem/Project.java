package umsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Project extends JFrame implements ActionListener {

    public Project(){
        super("UMS");
        setSize(1280,720);
        ImageIcon imageIcon= new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/third.jpg"));
        Image image= imageIcon.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel jLabel= new JLabel(imageIcon1);
        add(jLabel);


        JMenuBar jMenuBar= new JMenuBar(); /// creating menu bar

        ///       masters          /////
        JMenu jMenu = new JMenu("Master"); // creating menus
        JMenuItem jMenuItem = new JMenuItem("New Faculty"); // menu item in each menu
        JMenuItem jMenuItem1= new JMenuItem("New Student Admission");
        jMenu.setForeground(Color.BLUE);

        ImageIcon imageIcon2= new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon1.png"));
        Image image1= imageIcon2.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(image1);
        jMenuItem.setIcon(imageIcon3);
        jMenuItem.setMnemonic(KeyEvent.VK_A);
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        jMenuItem.setBackground(Color.WHITE);


        ImageIcon imageIcon6 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon2.png"));
        Image image3=imageIcon6.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon7=new ImageIcon(image3);
        jMenuItem1.setIcon(imageIcon7);
        jMenuItem1.setMnemonic(KeyEvent.VK_M);
        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        jMenuItem1.setBackground(Color.WHITE);

        jMenuItem.addActionListener(this);
        jMenuItem1.addActionListener(this);

        ///           masters           /////



        ////           user             ////
        JMenu user = new JMenu("User");
        JMenuItem user1 = new JMenuItem("Teacher Details");
        JMenuItem user2= new JMenuItem("Student Details");
        user.setForeground(Color.RED);

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon3.png"));
        Image image2= imageIcon4.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon5=new ImageIcon(image2);
        user1.setIcon(imageIcon5);
        user1.setMnemonic(KeyEvent.VK_P);
        user1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        user1.setBackground(Color.WHITE);


        ImageIcon imageIcon8 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon4.jpg"));
        Image image4 = imageIcon8.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon9= new ImageIcon(image4);
        user2.setIcon(imageIcon9);
        user2.setMnemonic(KeyEvent.VK_L);
        user2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        user2.setBackground(Color.white);

        user1.addActionListener(this);
        user2.addActionListener(this);


        ///      users          /////

        ///    attendance /////

        JMenu attendance = new JMenu("Attendance");
        attendance.setForeground(Color.blue);
        JMenuItem teacherAttendace = new JMenuItem("Teacher Attendance");
        JMenuItem studentAttendace= new JMenuItem("Student Attendance");

        ImageIcon imageIcon10= new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon15.png"));
        Image image5= imageIcon10.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon11=new ImageIcon(image5);
        teacherAttendace.setIcon(imageIcon11);
        teacherAttendace.setMnemonic(KeyEvent.VK_E);
        teacherAttendace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        teacherAttendace.setBackground(Color.white);


        ImageIcon imageIcon12 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon14.jpg"));
        Image image6= imageIcon12.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon13=new ImageIcon(image6);
        studentAttendace.setIcon(imageIcon13);
        studentAttendace.setMnemonic(KeyEvent.VK_B);
        studentAttendace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        studentAttendace.setBackground(Color.white);


        teacherAttendace.addActionListener(this);
        studentAttendace.addActionListener(this);

        ///    attendance /////


        /// examination /////

        JMenu exam = new JMenu("Examination");
        JMenuItem examDetails = new JMenuItem("Exam Details");
        JMenuItem enterMarks= new JMenuItem("Enter Marks");
        exam.setForeground(Color.red);


        ImageIcon imageIcon14= new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon16.png"));
        Image image7=imageIcon14.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon15= new ImageIcon(image7);
        examDetails.setIcon(imageIcon15);
        examDetails.setMnemonic(KeyEvent.VK_F);
        examDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        examDetails.setBackground(Color.white);


        ImageIcon imageIcon16 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon17.png"));
        Image image8= imageIcon16.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon17 = new ImageIcon(image8);
        enterMarks.setIcon(imageIcon17);
        enterMarks.setBackground(Color.white);
        enterMarks.setMnemonic(KeyEvent.VK_C);
        enterMarks.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));


        examDetails.addActionListener(this);
        enterMarks.addActionListener(this);

        /// examination /////


        ///Update Details ////

        JMenu updateDetails = new JMenu("Update Details");
        JMenuItem updateStudent = new JMenuItem("Update Students");
        JMenuItem updateTeacher = new JMenuItem("Update Teacher");
        updateDetails.setForeground(Color.blue);

        ImageIcon imageIcon18 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon5.png"));
        Image image9=imageIcon18.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon19 = new ImageIcon(image9);
        updateStudent.setIcon(imageIcon19);
        updateStudent.setBackground(Color.white);
        updateStudent.setMnemonic(KeyEvent.VK_S);
        updateStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));

        ImageIcon imageIcon20 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon6.png"));
        Image image10 = imageIcon20.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon21 = new ImageIcon(image10);
        updateTeacher.setIcon(imageIcon21);
        updateTeacher.setBackground(Color.white);
        updateTeacher.setMnemonic(KeyEvent.VK_T);
        updateTeacher.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));

        updateStudent.addActionListener(this);
        updateTeacher.addActionListener(this);
        ///Update Details ////


        /// fee details ///
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.red);
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        JMenuItem feeForm= new JMenuItem("Fee Form");

        ImageIcon imageIcon22 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon7.png"));
        Image image11 = imageIcon22.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon23 = new ImageIcon(image11);
        feeStructure.setIcon(imageIcon23);
        feeStructure.setBackground(Color.white);
        feeStructure.setMnemonic(KeyEvent.VK_Y);
        feeStructure.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));

        ImageIcon imageIcon24 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon8.png"));
        Image image12 = imageIcon24.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon25 = new ImageIcon(image12);
        feeForm.setIcon(imageIcon25);
        feeForm.setBackground(Color.white);
        feeForm.setMnemonic(KeyEvent.VK_U);
        feeForm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));


        feeStructure.addActionListener(this);
        feeForm.addActionListener(this);


        /// fee details ///

        /// utility ////
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.blue);
        JMenuItem notePad= new JMenuItem("NotePad");
        JMenuItem calc = new JMenuItem("Calculator");
        JMenuItem browser = new JMenuItem("Web Browser");

        ImageIcon imageIcon26 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon9.png"));
        Image image13= imageIcon26.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon27 = new ImageIcon(image13);
        notePad.setIcon(imageIcon27);
        notePad.setBackground(Color.white);
        notePad.setMnemonic(KeyEvent.VK_O);
        notePad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));

        ImageIcon imageIcon28 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon10.png"));
        Image image14= imageIcon28.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon29= new ImageIcon(image14);
        calc.setIcon(imageIcon29);
        calc.setBackground(Color.white);
        calc.setMnemonic(KeyEvent.VK_L);
        calc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));


        ImageIcon imageIcon30=  new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon11.png"));
        Image image15 = imageIcon30.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon31 = new ImageIcon(image15);
        browser.setIcon(imageIcon31);
        browser.setBackground(Color.white);
        browser.setMnemonic(KeyEvent.VK_K);
        browser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));


        notePad.addActionListener(this);
        calc.addActionListener(this);
        browser.addActionListener(this);
        /// utility ////

        ///about us////

        JMenu about = new JMenu("About");
        JMenuItem aus=new JMenuItem("About Us");
        about.setForeground(Color.red);

        ImageIcon imageIcon32 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon13.jpg"));
        Image image16=imageIcon32.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon33 = new ImageIcon(image16);
        aus.setIcon(imageIcon33);
        aus.setBackground(Color.white);
        aus.setMnemonic(KeyEvent.VK_V);
        aus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));

        aus.addActionListener(this);

        ///about us////

        ///exit///
        JMenu exit = new JMenu("Exit");
        JMenuItem ex= new JMenuItem("Exit");

        ImageIcon imageIcon34 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon12.png"));
        Image image17=imageIcon34.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon35=new ImageIcon(image17);
        ex.setIcon(imageIcon35);

        ex.addActionListener(this);

        ///exit///

        ///adding menu items in menu ///
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem1);
        user.add(user1);
        user.add(user2);
        attendance.add(teacherAttendace);
        attendance.add(studentAttendace);
        exam.add(examDetails);
        exam.add(enterMarks);
        updateDetails.add(updateStudent);
        updateDetails.add(updateTeacher);
        fee.add(feeStructure);
        fee.add(feeForm);
        utility.add(notePad);
        utility.add(calc);
        utility.add(browser);
        about.add(aus);
        exit.add(ex);


        ///adding menus in menu barr ///
        jMenuBar.add(jMenu);
        jMenuBar.add(user);
        jMenuBar.add(attendance);
        jMenuBar.add(exam);
        jMenuBar.add(updateDetails);
        jMenuBar.add(fee);
        jMenuBar.add(utility);
        jMenuBar.add(about);
        jMenuBar.add(exit);


        /// adding menu bar in frame ///
        setJMenuBar(jMenuBar);
        setLayout(new FlowLayout());





    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if(command.equals("New Student Admission")){
            new AddStudent().setVisible(true);
        }else if(command.equals("New Faculty")){
            new AddTeacher().setVisible(true);
        }else if(command.equals("Enter Marks")){
            new EnterMarks().setVisible(true);
        }else if(command.equals("Exam Details")){
            new ExaminationDetails().setVisible(true);
        }else if(command.equals("Exit")){
            System.exit(0);
        }


    }

    public static  void main(String args[]){
        new Project().setVisible(true);
    }
}
