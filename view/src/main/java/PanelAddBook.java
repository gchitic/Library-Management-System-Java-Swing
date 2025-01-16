import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAddBook extends JPanel {

    private JTextField denumireField, autorField, edituraField, domeniuField, anField;
    private CarteDAO carteDAO;
    private PanelShowBook panelShowBook;

    public PanelAddBook(PanelShowBook panelShowBook) {
        carteDAO = new CarteDAO();
        this.panelShowBook = panelShowBook;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#ced4da"));

        //Titlu
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(Color.decode("#ced4da"));
        JLabel lblAddBook = new JLabel("Adaugare carte");
        lblAddBook.setFont(new Font("Arial", Font.BOLD, 30));
        panelTitle.setBorder(new EmptyBorder(20, 50, 10, 50));
        panelTitle.add(lblAddBook);




        //Formular
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(6, 2));
        panelForm.setBackground(Color.decode("#ced4da"));
        panelForm.setBorder(new EmptyBorder(10, 250, 50, 250));

        JLabel lblDenumire = new JLabel("Denumire:");
        JLabel lblAutor = new JLabel("Autor:");
        JLabel lblEditura = new JLabel("Editura:");
        JLabel lblDomeniul = new JLabel("Domeniu:");
        JLabel lblAn = new JLabel("Anul aparitiei:");

        denumireField = new JTextField();
        autorField = new JTextField();
        edituraField = new JTextField();
        domeniuField = new JTextField();
        anField = new JTextField();

        JButton cancelBtn = new JButton("Anuleaza");
        JButton addBtn = new JButton("Adauga");

            //stilizarea
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        EmptyBorder labelBorder = new EmptyBorder(0, 30, 0, 0);
        for (JLabel label : new JLabel[]{lblDenumire, lblAutor, lblEditura, lblDomeniul, lblAn}) {
            label.setFont(labelFont);
            label.setBorder(labelBorder);
        }

        Dimension tfSize = new Dimension(100, 20);
        Font tfFont = new Font("Arial", Font.ITALIC, 14);
        for (JTextField tf : new JTextField[]{denumireField, autorField, edituraField, domeniuField, anField}) {
            tf.setPreferredSize(tfSize);
            tf.setFont(tfFont);
        }

        Color btnColor2 = new Color(100, 150, 250);
        cancelBtn.setBackground(btnColor2);
        cancelBtn.setForeground(Color.white);
        addBtn.setBackground(btnColor2);
        addBtn.setForeground(Color.white);

            //adăugarea în panel
        panelForm.add(lblDenumire); panelForm.add(denumireField);
        panelForm.add(lblAutor);    panelForm.add(autorField);
        panelForm.add(lblEditura);  panelForm.add(edituraField);
        panelForm.add(lblDomeniul); panelForm.add(domeniuField);
        panelForm.add(lblAn);   panelForm.add(anField);
        panelForm.add(cancelBtn);   panelForm.add(addBtn);

        this.add(panelTitle, BorderLayout.NORTH);
        this.add(panelForm, BorderLayout.CENTER);

        //evenimente
        addBtn.addActionListener(e -> addBook());
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Resetează câmpurile formularului
                denumireField.setText("");
                autorField.setText("");
                edituraField.setText("");
                domeniuField.setText("");
                anField.setText("");
            }
        });
    }

    private void addBook() {
        try {
            String denumire = denumireField.getText().trim();
            String autor = autorField.getText().trim();
            String editura = edituraField.getText().trim();
            String domeniu = domeniuField.getText().trim();
            int an = Integer.parseInt(anField.getText().trim());

            Carte carte = new Carte(denumire, autor, editura, domeniu, an);
            boolean success = carteDAO.addCarte(carte);

            if (success) {
                // Afișează mesajul de succes
                JOptionPane.showMessageDialog(this, "Carte înregistrată cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);

                // Resetează câmpurile formularului
                denumireField.setText("");
                autorField.setText("");
                edituraField.setText("");
                domeniuField.setText("");
                anField.setText("");

                // Actualizare tabel
                if (panelShowBook != null) {
                    panelShowBook.loadBook();
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
