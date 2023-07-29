package airline_reservation_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class login implements ActionListener
{
    JButton jb1,jb2,jb3;
    JLabel jl1,jl2;
    JTextField jt1,jt2;
    JFrame jf;
    Font f;
    public static void main(String[] args) {
        try {
            new login();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }

    public  login() throws ClassNotFoundException
    {
        jf=new JFrame("Airline reservation system");
        jf.setSize(1800, 1090);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jf.setBackground(Color.WHITE);
        jf.setLayout(null);
       f=new Font("TimesNewRoman",Font.BOLD,20);
       
        jl1=new JLabel("Username:");
        jl1.setFont(f);
        jl1.setBounds(740, 220, 120, 30);
        jf.add(jl1);
        jt1=new JTextField(16);
        jt1.setBounds(880, 220, 120, 30);
        jf.add(jt1);
        jl2=new JLabel("Password:");
        jl2.setFont(f);
        jl2.setBounds(740, 280, 120, 30);
        jf.add(jl2);
        jt2=new JPasswordField(16);
        jt2.setBounds(880, 280, 120, 30);
        jf.add(jt2);
        jb1=new JButton("LOGIN");
        jb1.setBackground(Color.BLACK);
        jb1.setForeground(Color.WHITE);
        jb1.setBounds(760, 350, 90, 40);
        jf.add(jb1);
        jb2=new JButton("SIGN UP");
        jb2.setBackground(Color.BLACK);
        jb2.setForeground(Color.WHITE);
        jb2.setBounds(900, 350, 90, 40);
        jf.add(jb2);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
       ImageIcon image=new ImageIcon(this.getClass().getResource("loginpage.jpg"));
       JLabel l5=new JLabel(image);
       l5.setSize(1300,760);
       jf.add(l5);
       jf.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try
        {   
      if(e.getSource()==jb1)
      {
          String st1=jt1.getText();
          String st2=jt2.getText();
          conn c=new conn();
          String str="select * from login where username='"+st1+"' and password='"+st2+"'";
          ResultSet rs=c.st.executeQuery(str);
          if(rs.next())
          {
               
              new mainframe();
              jf.setVisible(false);
          }
          else
          {
              JOptionPane.showMessageDialog(jf, "Try again!");
          }
      }
      }
        catch(SQLException ex)
        {
            System.out.println(ex);
        };
      if(e.getSource()==jb2)
      {
          new register();
      }
    
}
}
