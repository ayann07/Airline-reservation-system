package airline_reservation_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class register implements ActionListener
{
    JFrame jf;
    JTextField jt1,jt2,jt3,jt5;
    JPasswordField jt4;
    JButton b;
    public register()
    {
        jf=new JFrame();
        jf.setSize(700,500);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.setLayout(null);
        Font f=new Font("Tahoma",Font.PLAIN,17);
        JLabel l1=new JLabel("SIGN UP");
        l1.setFont(new Font("Tahoma",Font.BOLD,31));
        l1.setBounds(165, 24, 260, 38);
        jf.add(l1);
        JLabel name=new JLabel("First Name");
        name.setFont(f);
        name.setBounds(60, 110, 150, 27);
        jf.add(name);
        jt1=new JTextField();
        jt1.setBounds(200, 110, 150, 27);
        jf.add(jt1);
        JLabel lastname=new JLabel("Last Name");
        lastname.setFont(f);
        lastname.setBounds(60, 160, 150, 27);
        jf.add(lastname);
        jt2=new JTextField();
        jt2.setBounds(200, 160, 150, 27);
        jf.add(jt2);
        
        JLabel email=new JLabel("Email");
        email.setFont(f);
        email.setBounds(60, 210, 150, 27);
        jf.add(email);
        jt3=new JTextField();
        jt3.setBounds(200, 210, 150, 27);
        jf.add(jt3);
        JLabel username=new JLabel("Username");
        username.setFont(f);
        username.setBounds(60, 260, 150, 27);
        jf.add(username);
        jt5=new JTextField();
        jt5.setBounds(200, 260, 150, 27);
        jf.add(jt5);
        
        
        JLabel pw=new JLabel("Password");
        pw.setFont(f);
        pw.setBounds(60, 310, 150, 27);
        jf.add(pw);
        jt4=new JPasswordField();
        jt4.setBounds(200, 310, 150, 27);
        jf.add(jt4);
        b=new JButton("SIGN UP");
        b.setForeground(Color.WHITE);
         b.setBackground(Color.BLACK);
         b.setBounds(200, 360, 150, 30);
         jf.add(b);
         b.addActionListener(this);
        jf.setLocation(300,120);
        jf.setVisible(true);
    }
    public static void main(String[] args) 
    {
       new register();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
      if(e.getSource()==b)
      {
          String st1=jt5.getText();
          char[] st2=jt4.getPassword();
          String st3=new String(st2);
          try 
          {
              if(jt1.getText().isEmpty() || jt2.getText().isEmpty() || jt3.getText().isEmpty() ||  st3.isEmpty() || jt5.getText().isEmpty())
              {
                  JOptionPane.showMessageDialog(jf, "Fill all the fields!");
              }
              else
              {
              conn c=new conn();
              String str="INSERT INTO login values('"+st1+"','"+st3+"')";
              c.st.executeUpdate(str);
              JOptionPane.showMessageDialog(jf, "Successful!");
              }
          } 
          catch (Exception ex) {
              System.err.println(ex);
          }
      }
    
     }
}
