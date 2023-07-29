/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline_reservation_system;

/**
 *
 * @author Ayan
 */
import javax.swing.UIManager;

public class SwingLookAndFeelUtil {
    public static void setLookAndFeel(String lookAndFeelClassName) {
        try {
            UIManager.setLookAndFeel(lookAndFeelClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

