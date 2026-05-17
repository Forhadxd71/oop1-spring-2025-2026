package parkingmanagementsystem;

import parkingmanagementsystem.gui.ParkingGUI;

import javax.swing.SwingUtilities;
public class Start {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ParkingGUI::new);
    }
}