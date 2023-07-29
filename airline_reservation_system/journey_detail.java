
package airline_reservation_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class journey_detail implements ActionListener
{
    JFrame jf;
    JTextField jt;
    JButton b;
    JTable tb;
    String getfcode,getfname,src,des,dept,arrt;
    public journey_detail()
    {
        jf=new JFrame("Journey Details");
        jf.setSize(860, 624);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Font f=new Font("Tahoma",Font.PLAIN,13);
        JLabel head=new JLabel("JOURNEY DETAILS");
        head.setFont(new Font("Tahoma",Font.BOLD,31));
        head.setBounds(81, 27, 500, 39);
        jf.add(head);
        JLabel pnr=new JLabel("PNR No");
        pnr.setFont(f);
        pnr.setBounds(60, 100, 150, 26);
        jf.add(pnr);
        jt=new JTextField();
        jt.setBounds(200, 100, 150, 26);
        jf.add(jt);
        b=new JButton("SHOW");
        b.setForeground(Color.WHITE);
        b.setBackground(Color.BLACK);
        b.setBounds(200, 160, 150, 30);
        jf.add(b);
        b.addActionListener(this);
        tb=new JTable();
        tb.setBounds(23, 250, 800, 300);
        jf.add(tb);
        JLabel pn=new JLabel("PNR NO");
         pn.setFont(f);
         pn.setBounds(34, 220, 108, 26);
         jf.add(pn);
         JLabel fcode=new JLabel("FLIGHT CODE");
         fcode.setFont(f);
         fcode.setBounds(120, 220, 108, 26);
         jf.add(fcode);
         JLabel fname=new JLabel("FLIGHT NAME");
         fname.setFont(f);
         fname.setBounds(245, 220, 158, 26);
         jf.add(fname);
         JLabel src=new JLabel("SOURCE");
         src.setFont(f);
         src.setBounds(367, 220, 158, 26);
         jf.add(src);
         JLabel des=new JLabel("DESTINATION");
         des.setFont(f);
         des.setBounds(460, 220, 158, 26);
         jf.add(des);
        JLabel deptime=new JLabel("DEP TIME");
        deptime.setFont(f);
        deptime.setBounds(590, 220, 110, 26);
        jf.add(deptime);
        JLabel arrival=new JLabel("ARRIVAL TIME");
        arrival.setFont(f);
        arrival.setBounds(698, 220, 120, 26);
        jf.add(arrival);
        jf.setLocation(370, 50);
        jf.setVisible(true);
    }
    public static void main(String[] args) 
    {
       new journey_detail();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b)
        {
            String st=jt.getText();
            try 
            {
                 conn c=new conn();
                String str="select * from journey_details where pnr='"+st+"'";
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
                    getfcode=rs.getString(2);
                    getfname=rs.getString(3);
                    src=rs.getString(4);
                    des=rs.getString(5);
                    dept=rs.getString(6);
                    arrt=rs.getString(7);
                    String []row={st,getfcode,getfname,src,des,dept,arrt};
                    model.addRow(row);
                    
                }
            } 
            catch (Exception ex) 
            {
                System.out.println(ex);
            }
        }
    }
}
