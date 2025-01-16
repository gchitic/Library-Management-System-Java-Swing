import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;

public class PanelReturnare extends JPanel {

    private JTextField id_inchiriereField;
    private JDateChooser dateChooserReturnare;

    private ReturnareDAO returnareDAO;
    private PanelShowReturnare panelShowReturnare;

    public PanelReturnare(PanelShowReturnare panelShowReturnare) {
        returnareDAO = new ReturnareDAO();
        this.panelShowReturnare = panelShowReturnare;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#ced4da"));
        this.setBorder(new EmptyBorder(10, 250, 50, 250));

        //Titlu
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(Color.decode("#ced4da"));
        JLabel lblWelcome = new JLabel("Returnare carte");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 30));
        panelTitle.setBorder(new EmptyBorder(20, 50, 10, 50));
        panelTitle.add(lblWelcome);
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER));


        //Formular
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BorderLayout());

        JPanel panelCampuri = new JPanel();
        panelCampuri.setLayout(new GridLayout(2,2));
        //componente
        JButton btnReturneaza = new JButton("Returneaza");

        JLabel lblidInchiriere = new JLabel("Id inchiriere: ");
        JLabel lblDataReturnarii = new JLabel("Data returnarii:");

        id_inchiriereField = new JTextField();
        dateChooserReturnare = new JDateChooser();

        //stilizarea
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        EmptyBorder labelBorder = new EmptyBorder(0, 30, 0, 0);
        for (JLabel label : new JLabel[]{lblidInchiriere, lblDataReturnarii}) {
            label.setFont(labelFont);
            label.setBorder(labelBorder);
        }

        //adaugarea in panel
        panelCampuri.add(lblidInchiriere);    panelCampuri.add(id_inchiriereField);
        panelCampuri.add(lblDataReturnarii);    panelCampuri.add(dateChooserReturnare);

        panelForm.add(panelCampuri, BorderLayout.CENTER);
        panelForm.add(btnReturneaza, BorderLayout.SOUTH);

        this.add(panelTitle, BorderLayout.NORTH);
        this.add(panelForm, BorderLayout.CENTER);

        btnReturneaza.addActionListener(e -> addReturnare());

    }

    private void addReturnare() {
        try {
            int idInchirie = Integer.parseInt(id_inchiriereField.getText().trim());
            Date dateReturnare = dateChooserReturnare.getDate();

            Returnare returnare = new Returnare(idInchirie, dateReturnare);
            boolean success = returnareDAO.addReturnare(returnare);

            if (success) {
                // Afișează mesajul de succes
                JOptionPane.showMessageDialog(this, "Returnare cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);

                // Resetează câmpurile formularului
                id_inchiriereField.setText("");
                dateChooserReturnare.setDate(null);

                // Actualizare tabel
                if (panelShowReturnare != null) {
                    panelShowReturnare.loadReturnari();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Eroare la înregistrarea cărții.", "Eroare", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Anul apariției trebuie să fie un număr valid.", "Eroare", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "A apărut o eroare: " + e.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);
        }

    }
}
