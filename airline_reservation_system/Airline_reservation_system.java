
package airline_reservation_system;
public class Airline_reservation_system 
{
    public static void main(String[] args) 
    {
        try {
            SwingLookAndFeelUtil.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            new login();
            
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
        
    }

 }
