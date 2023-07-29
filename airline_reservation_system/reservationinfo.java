package airline_reservation_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class reservationinfo implements ActionListener
{
    JTable tb;
    JComboBox cb;
    JButton b;
    String getfcode,getfname,src,des,dept,arrt;
    public static void main(String[] args) 
    {
      new reservationinfo();
    }
    public reservationinfo()
    {
        JFrame jf=new JFrame("Flight details");
        Font f=new Font("Tahoma",Font.PLAIN,13);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.setSize(860, 624);
        jf.setLayout(null);
        JLabel flightdetails=new JLabel("FLIGHT INFORMATION");
        flightdetails.setFont(new Font("Tahoma",Font.BOLD,31));
        flightdetails.setBounds(50, 20, 570, 40);
        jf.add(flightdetails);
        JLabel flightcode=new JLabel("FLIGHT CODE");
        flightcode.setFont(new Font("Tahoma",Font.PLAIN,17));
        flightcode.setBounds(50, 100, 200, 30);
        jf.add(flightcode);
        String[] items={"SQ305" ,"QR101","AA523","BA469","DL786","AF205","SG303","AI601","6E981"};
        cb=new JComboBox(items);
        cb.setBounds(200, 100, 200, 30);
        jf.add(cb);
        b=new JButton("SHOW");
        b.setForeground(Color.WHITE);
        b.setBackground(Color.BLACK);
        b.setBounds(200, 155, 100, 30);
        b.addActionListener(this);
        jf.add(b);
        tb=new JTable();
        tb.setBounds(23, 250, 800, 300);
        jf.add(tb);
        JLabel fc=new JLabel("FLIGHT CODE");
        fc.setFont(f);
        fc.setBounds(23, 220, 126, 14);
        jf.add(fc);
        JLabel fname=new JLabel("FLIGHT NAME");
        fname.setFont(f);
        fname.setBounds(165, 220, 120, 14);
        jf.add(fname);
        JLabel s=new JLabel("SOURCE");
        s.setFont(f);
        s.setBounds(293, 220, 104, 14);
        jf.add(s);
        JLabel d=new JLabel("DESTINATION");
        d.setFont(f);
        d.setBounds(407, 220, 120, 14);
        jf.add(d);
        JLabel deptime=new JLabel("DEP TIME");
        deptime.setFont(f);
        deptime.setBounds(547, 220, 110, 14);
        jf.add(deptime);
        JLabel arrival=new JLabel("ARRIVAL TIME");
        arrival.setFont(f);
        arrival.setBounds(659, 220, 120, 14);
        jf.add(arrival);
//        JLabel clname=new JLabel("");
//        clname.setFont(f);
//        clname.setBounds(729, 220, 120, 14);
//        jf.add(clname);
        jf.setLocation(370, 50);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource()==b)
       {
           String selectedValue = (String) cb.getSelectedItem();
           try 
           {
                conn c=new conn();
                String str="select * from flight_information where flight_code='"+selectedValue+"'";
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
                    getfcode=rs.getString(1);
                    getfname=rs.getString(2);
                    src=rs.getString(3);
                    des=rs.getString(4);
                    dept=rs.getString(5);
                    arrt=rs.getString(6);
                    String []row={getfcode,getfname,src,des,dept,arrt};
                    model.addRow(row);
                    
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

       }
    }
}
