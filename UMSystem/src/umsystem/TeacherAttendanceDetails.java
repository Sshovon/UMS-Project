package umsystem;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class TeacherAttendanceDetails extends JFrame implements ActionListener {

    JTable table;
    JTextField search;
    JButton b1;


    void showAll(){
        try{
            conn con = new conn();
            String sql = "select * from faculty_info";

            ResultSet rs=con.s.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public TeacherAttendanceDetails(){
        setBounds(350,200,1200,475);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        table=new JTable();
        table.setBackground(Color.white);
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Trebuchet MS",Font.BOLD,16));
        showAll();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                int clickedrow=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(clickedrow,7).toString());

            }
        });
        JScrollPane js=new JScrollPane();
        js.setViewportView(table);
        js.setBounds(79,133,1080,282);

        add(js);

        b1=new JButton("Count");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        b1.setBounds(564,89,138,33);
        add(b1);
        b1.addActionListener(this);

        search= new JTextField();
        search.setForeground(Color.BLACK);
        search.setFont(new Font("",Font.BOLD|Font.ITALIC,17));
        search.setBounds(189,89,357,33);
        add(search);
        search.setColumns(10);



        JLabel jLabel= new JLabel("Calculate Attendance");
        jLabel.setForeground(Color.BLACK);
        jLabel.setFont(new Font("",Font.BOLD | Font.ITALIC,30));
        jLabel.setBounds(300,15,400,47);
        add(jLabel);

        JLabel back= new JLabel("Back");
        back.setForeground(Color.GRAY);
        back.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        back.setBounds(97,89,72,33);
        add(back);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                setVisible(false);
                dispose();
            }
        });


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
                String s=search.getText();
                new TabularAttendance(s).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new TeacherAttendanceDetails().setVisible(true);
    }
}
