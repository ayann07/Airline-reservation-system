package airline_reservation_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


public class cancellation implements ActionListener
{
    JTextField jt1,jt2;
    JButton b;
    JFrame jf;
    public static void main(String args[])
    {
        new cancellation();
    }
    public cancellation()
    {
        jf=new JFrame("Cancel Ticket");
        //jf.getContentPane().setBackground(Color.WHITE);
        jf.setLayout(null);
        jf.setSize(560,500);
        Font f=new Font("Tahoma",Font.PLAIN,17);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JLabel cancel=new JLabel("CANCELLATION");
        cancel.setFont(new Font("Tahoma",Font.BOLD,31));
        cancel.setBounds(165, 24, 260, 38);
        jf.add(cancel);
        JLabel pnr=new JLabel("PNR Number");
        pnr.setFont(f);
        pnr.setBounds(60,100,130,26);
        jf.add(pnr);
        jt1=new JTextField();
        jt1.setBounds(220, 100, 170, 27);
        jf.add(jt1);
        JLabel flightcode=new JLabel("Flight Code");
        flightcode.setFont(f);
        flightcode.setBounds(60,160,130,26);
        jf.add(flightcode);
        jt2=new JTextField();
        jt2.setBounds(220, 160, 170, 27);
        jf.add(jt2);
        b=new JButton("Cancel");
        b.setForeground(Color.WHITE);
         b.setBackground(Color.BLACK);
         b.setBounds(220, 220, 150, 30);
         jf.add(b);
         b.addActionListener(this);
        jf.setLocation(300,120);
        jf.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource()==b)
       {
           try 
           {
               String p=jt1.getText();
               String fc=jt2.getText();
               if(jt1.getText().isEmpty() || jt2.getText().isEmpty() )
                   JOptionPane.showMessageDialog(jf, "Try again!");
               else
               {
               conn c=new conn();
               String str="INSERT INTO cancellation values(' "+p+"', '"+fc+"')";
               c.st.executeUpdate(str);
               JOptionPane.showMessageDialog(jf, "Ticket Canceled!");
               }
           } 
           catch (SQLException ex) 
           {
               System.err.println(ex);
           }
           
    }
}
}
