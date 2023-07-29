
package airline_reservation_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainframe implements ActionListener
{
    JMenuItem getinfo,addDetails,cancel,journey,pay;
    public static void main(String[] args) 
    {
        new mainframe();
    }
  
   public mainframe()
   {
       JFrame jf=new JFrame("Airline Reservation");
       jf.setLayout(null);
       jf.setSize(1850,1090);
       ImageIcon image=new ImageIcon(this.getClass().getResource("mainb.jpg"));
       JLabel l5=new JLabel(image);
       l5.setSize(1290,760);
       jf.add(l5);
       JMenuBar menuBar=new JMenuBar();
       jf.setJMenuBar(menuBar);
       JMenu flight_info=new JMenu("Flight");
       menuBar.add(flight_info);
       getinfo=new JMenuItem("Get Details");
       flight_info.add(getinfo);
       JMenu customerdetails=new JMenu("Customer");
       menuBar.add(customerdetails);
       addDetails=new JMenuItem("Add Customer details");
       customerdetails.add(addDetails);
       cancel=new JMenuItem("Cancel Ticket");
       customerdetails.add(cancel);
       JMenu journeydetails=new JMenu("Journey");
       menuBar.add(journeydetails);
       journey=new JMenuItem("Journey Details");
       journeydetails.add(journey);
       JMenu paydetails=new JMenu("Payment");
       menuBar.add(paydetails);
       pay=new JMenuItem("Payment Details");
       paydetails.add(pay);
       
       getinfo.addActionListener(this);
       addDetails.addActionListener(this);
       cancel.addActionListener(this);
       journey.addActionListener(this);
       pay.addActionListener(this);
       SwingLookAndFeelUtil.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
       jf.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
         if(e.getSource()==addDetails)
           new add_details();
         if(e.getSource()==cancel)
           new cancellation();
         if(e.getSource()==pay)
           new makepayment();  
         if(e.getSource()==getinfo)
           new reservationinfo();    
        if(e.getSource()==journey)
           new journey_detail();
              
    }

    
    }
