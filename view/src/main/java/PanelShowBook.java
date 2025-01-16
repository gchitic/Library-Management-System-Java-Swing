import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelShowBook extends JPanel{
    private JTable bookTable;
    private DefaultTableModel tableModel;
    private JTextField denumireField, autorField, edituraField, domeniuField, anField;

    private CarteDAO carteDAO;

    public PanelShowBook() {
        carteDAO = new CarteDAO();

        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#ced4da"));

        //Tabelul
        tableModel = new DefaultTableModel(new String[]{"ID", "Denumire", "Autor", "Editura", "Domeniu", "Anul aparitiei"}, 0);
        bookTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        add(scrollPane, BorderLayout.CENTER);

        //Formularul
        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        formPanel.setBorder(new EmptyBorder(50, 250, 50, 250));

        formPanel.add(new JLabel("Denumire:"));
        denumireField = new JTextField();
        formPanel.add(denumireField);

        formPanel.add(new JLabel("Autor:"));
        autorField = new JTextField();
        formPanel.add(autorField);

        formPanel.add(new JLabel("Editura:"));
        edituraField = new JTextField();
        formPanel.add(edituraField);

        formPanel.add(new JLabel("Domeniu:"));
        domeniuField = new JTextField();
        formPanel.add(domeniuField);

        formPanel.add(new JLabel("An aparitie:"));
        anField = new JTextField();
        formPanel.add(anField);


        //Butoanele
        JPanel buttonPanel = new JPanel();
        JButton updateButton = new JButton("Actualizează");
        JButton deleteButton = new JButton("Șterge");
            //stilizarea
        Color btnColor2 = new Color(100, 150, 250);
        updateButton.setBackground(btnColor2);
        updateButton.setForeground(Color.white);
        deleteButton.setBackground(btnColor2);
        deleteButton.setForeground(Color.white);

        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        this.add(formPanel,BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);

        //afisarea cartilor in tabel
        loadBook();



        //evenimente
        updateButton.addActionListener(e -> updateBook());
        deleteButton.addActionListener(e -> deleteBook());


        bookTable.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = bookTable.getSelectedRow();
            if (selectedRow >= 0) {
                // Obținem valorile din tabel și le plasăm în câmpurile de text
                denumireField.setText((String) tableModel.getValueAt(selectedRow, 1));
                autorField.setText((String) tableModel.getValueAt(selectedRow, 2));
                edituraField.setText(String.valueOf(tableModel.getValueAt(selectedRow, 3)));
                domeniuField.setText((String) tableModel.getValueAt(selectedRow, 4));
                anField.setText(String.valueOf(tableModel.getValueAt(selectedRow, 5)));
            }
        });
    }


    //incarcarea cartilor si afisarea lor in tab
    public void loadBook() {
        tableModel.setRowCount(0);
        List<Carte> carti = carteDAO.showBooks();
        for (Carte carte : carti) {
            tableModel.addRow(new Object[] {
                carte.getId_carte(), carte.getDenumire(), carte.getAutor(), carte.getEditura(),
                carte.getDomeniul(), carte.getAn_aparitie()
            });
        }
    }

    private void updateBook() {
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);

            String denumire = denumireField.getText();
            String autor = autorField.getText();
            String editura = edituraField.getText();
            String domeniul = domeniuField.getText();
            int an = Integer.parseInt(anField.getText());

            Carte carte = new Carte(id, denumire, autor, editura, domeniul, an);
            carteDAO.updateBooks(carte);

            // Afișează mesajul de succes
            JOptionPane.showMessageDialog(this, "Carte modificata cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);

            // Resetează câmpurile formularului
            denumireField.setText("");
            autorField.setText("");
            edituraField.setText("");
            domeniuField.setText("");
            anField.setText("");

            loadBook();
        }
    }

    private void deleteBook() {
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            carteDAO.deleteBook(id);

            // Afișează mesajul de succes
            JOptionPane.showMessageDialog(this, "Carte stearsa cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);

            // Resetează câmpurile formularului
            denumireField.setText("");
            autorField.setText("");
            edituraField.setText("");
            domeniuField.setText("");
            anField.setText("");

            loadBook();
        }
    }
}
