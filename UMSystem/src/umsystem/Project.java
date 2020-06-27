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
        Image image= imageIcon.getImage().getScaledInstance(1200,650,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel jLabel= new JLabel(imageIcon);
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
        jMenuItem.setMnemonic('A');
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        jMenuItem.setBackground(Color.WHITE);


        ImageIcon imageIcon6 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon2.png"));
        Image image3=imageIcon6.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon7=new ImageIcon(image3);
        jMenuItem1.setIcon(imageIcon7);
        jMenuItem1.setMnemonic('B');
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
        user1.setMnemonic('C');
        user1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        user1.setBackground(Color.WHITE);


        ImageIcon imageIcon8 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon4.jpg"));
        Image image4 = imageIcon8.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon9= new ImageIcon(image4);
        user2.setIcon(imageIcon9);
        user2.setMnemonic('D');
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
        teacherAttendace.setMnemonic('N');
        teacherAttendace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        teacherAttendace.setBackground(Color.white);


        ImageIcon imageIcon12 = new ImageIcon(ClassLoader.getSystemResource("umsystem/projectsicons/icon14.jpg"));
        Image image6= imageIcon12.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon imageIcon13=new ImageIcon(image6);
        studentAttendace.setIcon(imageIcon13);
        studentAttendace.setMnemonic('M');
        studentAttendace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        studentAttendace.setBackground(Color.white);


        teacherAttendace.addActionListener(this);
        studentAttendace.addActionListener(this);

        ///    attendance /////

        ///adding menu items in menu ///
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem1);
        user.add(user1);
        user.add(user2);
        attendance.add(teacherAttendace);
        attendance.add(studentAttendace);


        ///adding menus in menu barr ///
        jMenuBar.add(jMenu);
        jMenuBar.add(user);
        jMenuBar.add(attendance);


        /// adding menu bar in frame ///
        setJMenuBar(jMenuBar);
        setLayout(new FlowLayout());





    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static  void main(String args[]){
        new Project();
    }
}
