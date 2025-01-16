import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //rularea GUI
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });

        //conectarea la baza de date
        try {
            if(DataBaseConnection.getConnection() != null) {
                System.out.println("Conectare reușită la baza de date!");
            }
        } catch(Exception e) {
            System.out.println("Eroare la conectarea la baza de date!");
            e.printStackTrace();
        }
    }
}
