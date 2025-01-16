import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAddReader extends JPanel {
    private JTextField numeField, prenumeField, telField, adresaField;
    private CititorDAO cititorDAO;
    private PanelShowReader panelShowReader;

    public PanelAddReader(PanelShowReader panelShowReader) {
        cititorDAO = new CititorDAO();
        this.panelShowReader = panelShowReader;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#ced4da"));

        //Titlu
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(Color.decode("#ced4da"));
        JLabel lblAddBook = new JLabel("Adaugare cititor");
        lblAddBook.setFont(new Font("Arial", Font.BOLD, 30));
        panelTitle.setBorder(new EmptyBorder(20, 50, 10, 50));
        panelTitle.add(lblAddBook);



        //Formular
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(6,2));
        panelForm.setBackground(Color.decode("#ced4da"));
        panelForm.setBorder(new EmptyBorder(10, 250, 50, 250));
        panelForm.revalidate();
        panelForm.repaint();

        JLabel lblNume = new JLabel("Nume:");
        JLabel lblPrenume = new JLabel("Prenume:");
        JLabel lblTel = new JLabel("Nr.tel:");
        JLabel lblAdresa = new JLabel("Adresa:");

        numeField = new JTextField();
        prenumeField = new JTextField();
        telField = new JTextField();
        adresaField = new JTextField();

        JButton cancelBtn = new JButton("Anuleaza");
        JButton addBtn = new JButton("Adauga");

            //stilizarea
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        EmptyBorder labelBorder = new EmptyBorder(0, 30, 0, 0);
        for (JLabel label : new JLabel[]{lblNume, lblPrenume, lblTel, lblAdresa}) {
            label.setFont(labelFont);
            label.setBorder(labelBorder);
        }

        Dimension tfSize = new Dimension(100, 20);
        Font tfFont = new Font("Arial", Font.ITALIC, 14);
        for(JTextField tf : new JTextField[]{numeField, prenumeField, telField, adresaField}) {
            tf.setPreferredSize(tfSize);
            tf.setFont(tfFont);
        }

        Color btnColor = new Color(100, 150, 250);
        cancelBtn.setBackground(btnColor);
        cancelBtn.setForeground(Color.white);
        addBtn.setBackground(btnColor);
        addBtn.setForeground(btnColor.white);

            //adaugarea in panelform
        panelForm.add(lblNume); panelForm.add(numeField);
        panelForm.add(lblPrenume);    panelForm.add(prenumeField);
        panelForm.add(lblTel);    panelForm.add(telField);
        panelForm.add(lblAdresa);    panelForm.add(adresaField);
        panelForm.add(cancelBtn);    panelForm.add(addBtn);


        this.add(panelTitle, BorderLayout.NORTH);
        this.add(panelForm, BorderLayout.CENTER);


        //evenimente
        addBtn.addActionListener(e -> addReader());
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Resetează câmpurile formularului
                numeField.setText("");
                prenumeField.setText("");
                telField.setText("");
                adresaField.setText("");
            }
        });
    }

    private void addReader() {
        try {
            String nume = numeField.getText().trim();
            String prenume = prenumeField.getText().trim();
            String tel = telField.getText().trim();
            String adresa = adresaField.getText().trim();

            Cititor cititor = new Cititor(nume, prenume, tel, adresa);

            // Adaugă cartea în baza de date
            boolean success = cititorDAO.addCititor(cititor);

            if (success) {
                // Afișează mesajul de succes
                JOptionPane.showMessageDialog(this, "Carte înregistrată cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);

                // Resetează câmpurile formularului
                numeField.setText("");
                prenumeField.setText("");
                telField.setText("");
                adresaField.setText("");

                // Actualizare tabel
                if (panelShowReader != null) {
                    panelShowReader.loadReaders();
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
