
package airline_reservation_system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class add_details implements ActionListener
{
    JTextField jt1,jt2,jt3,jt4,jt5;
    Font f;
    JButton b;
    JRadioButton m,fem;
    JFrame jf;
    public add_details()
    {
        
        jf=new JFrame("Add Customer Details");
        jf.setSize(778, 486);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //jf.getContentPane().setBackground(Color.WHITE);
        jf.setLayout(null);
        f=new Font("Tahoma",Font.PLAIN,17);
        JLabel name=new JLabel("Name");
        name.setFont(f);
        name.setBounds(60, 40, 150, 27);
        jf.add(name);
        jt1=new JTextField();
        jt1.setBounds(200, 40, 150, 27);
        jf.add(jt1);
        JLabel Gender=new JLabel("Gender");
        Gender.setFont(f);
        Gender.setBounds(60, 90, 150, 27);
        jf.add(Gender);
        m=new JRadioButton("MALE");
        m.setBackground(Color.WHITE);
        m.setBounds(200, 90, 60, 30);
        fem=new JRadioButton("FEMALE");
        fem.setBackground(Color.WHITE);
        fem.setBounds(300, 90, 80, 30);
        ButtonGroup group = new ButtonGroup();
        group.add(m);
        group.add(fem);
        jf.add(m);
        jf.add(fem);
        JLabel phn=new JLabel("Contact No");
        phn.setFont(f);
        phn.setBounds(60, 140, 150, 27);
        jf.add(phn);
        jt2=new JTextField();
        jt2.setBounds(200, 140, 150, 27);
        jf.add(jt2);
        JLabel nationality=new JLabel("Nationality");
        nationality.setFont(f);
        nationality.setBounds(60, 190, 150, 27);
        jf.add(nationality);
        jt3=new JTextField();
        jt3.setBounds(200, 190, 150, 27);
        jf.add(jt3);
        JLabel flightcode=new JLabel("Flight Code");
        flightcode.setFont(f);
        flightcode.setBounds(60, 240, 150, 27);
        jf.add(flightcode);
        jt4=new JTextField();
        jt4.setBounds(200, 240, 150, 27);
        jf.add(jt4);
        JLabel passport=new JLabel("Passport No");
        passport.setFont(f);
        passport.setBounds(60, 290, 150, 27);
        jf.add(passport);
        jt5=new JTextField();
        jt5.setBounds(200, 290, 150, 27);
        jf.add(jt5);
         b=new JButton("SAVE");
         b.setForeground(Color.WHITE);
         b.setBackground(Color.BLACK);
         b.setBounds(200, 350, 150, 30);
         jf.add(b);
         b.addActionListener(this);
         jf.setLocation(300,120);
        jf.setVisible(true);
    }
    
    public static void main(String[] args) 
    {
       new add_details();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b)
        {
            try {
                String getname=jt1.getText();
                String getcontact=jt2.getText();
                String getnationality=jt3.getText();
                String getflightcode=jt4.getText();
                String getpassport=jt5.getText();
                String getgender="";
                if(m.isSelected())
                    getgender="male";
                else if(fem.isSelected())
                    getgender="female";
                conn c=new conn();
                String str="INSERT INTO customer values('"+getname+"','"+getgender+"','"+getcontact+"','"+getnationality+"','"+getflightcode+"','"+getpassport+"')";
                c.st.executeUpdate(str);
                JOptionPane.showMessageDialog(jf, "Details Added Successfully!");
            }
            catch (SQLException ex) 
            {
                System.out.println(ex);
            }
        }
    }
}
