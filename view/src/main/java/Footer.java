import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Footer extends JPanel {
    public Footer() {
        this.setLayout(new GridLayout(2, 4));
        this.setBackground(Color.decode("#adb5bd"));
        this.setBorder(new EmptyBorder(30, 20, 30, 20));

        JLabel lblTel = new JLabel("tel.076789025");
        JLabel lblOra = new JLabel("Ora:......");
        JLabel lblEmail = new JLabel("email: manuscript@gmail.com");
        JLabel lblData = new JLabel("Data:......");
        Timer timer;

            //stilizare
        Font labelFont = new Font("Arial", Font.BOLD, 17);
        for (JLabel label : new JLabel[]{lblTel, lblOra, lblEmail, lblData}) {
            label.setFont(labelFont);
        }

        lblTel.setBorder(new EmptyBorder(10, 0, 10, 10));
        lblOra.setBorder(new EmptyBorder(10, 330, 10, 0));
        lblEmail.setBorder(new EmptyBorder(10, 0, 10, 10));
        lblData.setBorder(new EmptyBorder(10, 330, 10, 0));

            //setarea orei si datii
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //actualizarea etichetelor la fiecare secunda
        timer = new Timer(1000, e -> {
            LocalDateTime now = LocalDateTime.now();
            lblOra.setText("Ora: " + now.format(timeFormatter));
            lblData.setText("Data: " + now.format(dateFormatter));
        });
        timer.start();


        this.add(lblTel);   this.add(lblOra);
        this.add(lblEmail); this.add(lblData);
    }
}
