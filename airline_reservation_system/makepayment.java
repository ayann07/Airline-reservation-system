package airline_reservation_system;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class makepayment implements ActionListener
{
    JTextField jt;
    JLabel pn,paid_amt,pay_day,Phn;
    JTable tb;
    JButton b;
    JFrame jf;
    String getpn,getpaid,getday,getphn,prev;
    public makepayment()
    {
         jf=new JFrame("Payment details");
        //jf.getContentPane().setBackground(Color.WHITE);
        jf.setSize(760, 556);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Font f1=new Font("Tahoma",Font.PLAIN,17);
        Font f2=new Font("Tahoma",Font.PLAIN,14);
        JLabel head=new JLabel("PAYMENT DETAILS");
        head.setFont(new Font("Tahoma",Font.BOLD,31));
        head.setBounds(81, 17, 500, 39);
        jf.add(head);
        JLabel pnr=new JLabel("PNR NO");
        pnr.setFont(f1);
        pnr.setBounds(60, 140, 150, 26);
        jf.add(pnr);
        jt=new JTextField();
        jt.setBounds(200, 140, 150, 26);
        jf.add(jt);
        b=new JButton("SHOW");
         b.setForeground(Color.WHITE);
         b.setBackground(Color.BLACK);
         b.setBounds(200, 195, 150, 30);
         jf.add(b);
         tb=new JTable();
         tb.setBounds(45, 330, 556, 168);
         jf.add(tb);
         pn=new JLabel("PNR NO");
         pn.setFont(f2);
         pn.setBounds(64, 290,108, 26);
         jf.add(pn);
         paid_amt=new JLabel("PAID AMOUNT");
         paid_amt.setFont(f2);
         paid_amt.setBounds(174, 292, 158, 26);
         jf.add(paid_amt);
         pay_day=new JLabel("PAYMENT DATE");
         pay_day.setFont(f2);
         pay_day.setBounds(310, 292, 158, 26);
         jf.add(pay_day);
         Phn=new JLabel("CONTACT");
         Phn.setFont(f2);
         Phn.setBounds(470, 292, 158, 26);
         jf.add(Phn);
         b.addActionListener(this);
         jf.setLocation(300,110);
        jf.setVisible(true);
            
    }
    public static void main(String[] args) {
        new makepayment();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b)
        {
            try {
                String code=jt.getText();
                conn c=new conn();
                String str="select * from payment where pnr='"+code+"'";
                ResultSet rs=c.st.executeQuery(str);
                ResultSetMetaData rsmd=rs.getMetaData();
                DefaultTableModel model=(DefaultTableModel)tb.getModel();
                tb.setRowHeight(40);
                int cols=rsmd.getColumnCount();
                String colname[]=new String[cols];
                for(int i=0;i<cols;i++)
                    colname[i]=rsmd.getColumnName(i+1);
                model.setColumnIdentifiers(colname);
                while(rs.next())
                {
                    getpn=rs.getString(1);
                    getpaid=rs.getString(2);
                    getday=rs.getString(3);
                    getphn=rs.getString(4);
                    String []row={getpn,getpaid,getday,getphn};
                    model.addRow(row);
                    
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

       }
        }
    }

