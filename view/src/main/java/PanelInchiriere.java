import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;

public class PanelInchiriere extends JPanel {
    private JTextField id_carteField, id_cititorField;
    private JDateChooser dateChooserInchiriere, dateChooserEstReturnare;

    private InchiriereDAO inchiriereDAO;
    private PanelShowInchirieri panelShowInchirieri;
    public PanelInchiriere(PanelShowInchirieri panelShowInchirieri) {
        inchiriereDAO = new InchiriereDAO();
        this.panelShowInchirieri = panelShowInchirieri;

        id_carteField = new JTextField();
        id_cititorField = new JTextField();
        dateChooserInchiriere = new JDateChooser();
        dateChooserEstReturnare = new JDateChooser();

        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#ced4da"));
        this.setBorder(new EmptyBorder(10, 250, 50, 250));

        //Titlu
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(Color.decode("#ced4da"));
        JLabel lblWelcome = new JLabel("Inchiriere carte");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 30));
        panelTitle.setBorder(new EmptyBorder(20, 50, 10, 50));
        panelTitle.add(lblWelcome);
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER));


        //Formular
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BorderLayout());

        JPanel panelCampuri = new JPanel();
        panelCampuri.setLayout(new GridLayout(4,2));
            //componente
        JButton btnInchiriaza = new JButton("Inchiriaza");


        JLabel lblCarti = new JLabel("Id carte: ");
        JLabel lblCititori = new JLabel("Id cititor: ");
        JLabel lblDataInchiriere = new JLabel("Data inchirierii: ");
        JLabel lblDataEstReturnarii = new JLabel("Data estimata a returnarii:");



            //stilizarea
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        EmptyBorder labelBorder = new EmptyBorder(0, 30, 0, 0);
        for (JLabel label : new JLabel[]{lblCarti, lblCititori, lblDataInchiriere, lblDataEstReturnarii}) {
            label.setFont(labelFont);
            label.setBorder(labelBorder);
        }

            //adaugarea in panel
        panelCampuri.add(lblCarti);    panelCampuri.add(id_carteField);
        panelCampuri.add(lblCititori);  panelCampuri.add(id_cititorField);
        panelCampuri.add(lblDataInchiriere);   panelCampuri.add(dateChooserInchiriere);
        panelCampuri.add(lblDataEstReturnarii);    panelCampuri.add(dateChooserEstReturnare);

        panelForm.add(panelCampuri, BorderLayout.CENTER);
        panelForm.add(btnInchiriaza, BorderLayout.SOUTH);

        this.add(panelTitle, BorderLayout.NORTH);
        this.add(panelForm, BorderLayout.CENTER);

        btnInchiriaza.addActionListener(e -> addInchiriere());
    }


    private void addInchiriere() {
        try {
            int id_carte = Integer.parseInt(id_carteField.getText().trim());
            int id_cititor = Integer.parseInt(id_cititorField.getText().trim());
            Date dateInchiriere = dateChooserInchiriere.getDate();
            Date dateEstReturnare = dateChooserEstReturnare.getDate();

            Inchiriere inchiriere = new Inchiriere(id_carte, id_cititor, dateInchiriere, dateEstReturnare);
            boolean success = inchiriereDAO.addInchiriere(inchiriere);

            if (success) {
                // Afișează mesajul de succes
                JOptionPane.showMessageDialog(this, "Inregistrare cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);

                // Resetează câmpurile formularului
                id_carteField.setText("");
                id_cititorField.setText("");
                dateChooserInchiriere.setDate(null);
                dateChooserEstReturnare.setDate(null);

                 //Actualizare tabel
                if (panelShowInchirieri != null) {
                    panelShowInchirieri.loadInchirieri();
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
