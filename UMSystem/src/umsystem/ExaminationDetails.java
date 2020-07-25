package umsystem;

import jdk.nashorn.internal.ir.CatchNode;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ExaminationDetails extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private  JButton b1,b2,b3;

    public void showAll(){
        try{
            conn con = new conn();
            String sql = "select * from student_values";

            ResultSet rs=con.s.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public ExaminationDetails(){
        super("Check Result");
        setBounds(350,200,1200,475);
        contentPane= new JPanel();
        contentPane.setBackground(Color.white);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane jScrollPane= new JScrollPane();
        jScrollPane.setBounds(79,133,1080,282);
        contentPane.add(jScrollPane);

        table=new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                int clickedrow=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(clickedrow,7).toString());

            }
        });

        table.setBackground(Color.white);
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Trebuchet MS",Font.BOLD,16));
        jScrollPane.setViewportView(table);

        b1=new JButton("Result");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        b1.setBounds(564,89,138,33);
        contentPane.add(b1);
        b1.addActionListener(this);


        JLabel jLabel= new JLabel("Check Result");
        jLabel.setForeground(Color.BLACK);
        jLabel.setFont(new Font("",Font.BOLD | Font.ITALIC,30));
        jLabel.setBounds(300,15,400,47);
        contentPane.add(jLabel);


        search= new JTextField();
        search.setForeground(Color.BLACK);
        search.setFont(new Font("",Font.BOLD|Font.ITALIC,17));
        search.setBounds(189,89,357,33);
        contentPane.add(search);
        search.setColumns(10);

        JLabel back= new JLabel("Back");
        back.setForeground(Color.GRAY);
        back.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        back.setBounds(97,89,72,33);
        contentPane.add(back);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                setVisible(false);
                dispose();
            }
        });

        showAll(); ///fetching all data and showing  them in the table



    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            conn con= new conn();
            if(ae.getSource()==b1){
                new Marks(search.getText()).setVisible(true);
                this.setVisible(false);
                this.dispose();

            }
        } catch(Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new ExaminationDetails().setVisible(true);
    }

}
