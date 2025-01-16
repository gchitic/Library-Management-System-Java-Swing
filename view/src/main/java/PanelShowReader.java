import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelShowReader extends JPanel{
    private JTable readerTable;
    private DefaultTableModel tableModel;
    private JTextField numeField, prenumeField, telField, adresaField;

    private CititorDAO cititorDAO;

    public PanelShowReader() {
        cititorDAO = new CititorDAO();

        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#ced4da"));

        //Tabelul
        tableModel = new DefaultTableModel(new String[]{"ID", "Nume", "Prenume", "Nr.tel", "Adresa"}, 0);
        readerTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(readerTable);
        add(scrollPane, BorderLayout.CENTER);

        //Formularul
        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        formPanel.setBorder(new EmptyBorder(50, 250, 50, 250));

        formPanel.add(new JLabel("Nume:"));
        numeField = new JTextField();
        formPanel.add(numeField);

        formPanel.add(new JLabel("Prenume:"));
        prenumeField = new JTextField();
        formPanel.add(prenumeField);

        formPanel.add(new JLabel("Nr.tel:"));
        telField = new JTextField();
        formPanel.add(telField);

        formPanel.add(new JLabel("Adresa:"));
        adresaField = new JTextField();
        formPanel.add(adresaField);


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

        //afisarea cititorilor in tabel
        loadReaders();

        //evenimente
        updateButton.addActionListener(e -> updateReaders());
        deleteButton.addActionListener(e -> deleteReader());


        readerTable.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = readerTable.getSelectedRow();
            if (selectedRow >= 0) {
                // Obținem valorile din tabel și le plasăm în câmpurile de text
                numeField.setText((String) tableModel.getValueAt(selectedRow, 1));
                prenumeField.setText((String) tableModel.getValueAt(selectedRow, 2));
                telField.setText(String.valueOf(tableModel.getValueAt(selectedRow, 3)));
                adresaField.setText((String) tableModel.getValueAt(selectedRow, 4));
            }
        });
    }

    //incarcarea cititorilor si afisarea lor in tab
    public void loadReaders() {
        tableModel.setRowCount(0);
        List<Cititor> cititori = cititorDAO.showReaders();
        for (Cititor cititor : cititori) {
            tableModel.addRow(new Object[] {
                    cititor.getId_cititor(), cititor.getNume(), cititor.getPrenume(), cititor.getNr_tel(),
                    cititor.getAdresa()
            });
        }
    }

    private void updateReaders() {
        int selectedRow = readerTable.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);

            String nume = numeField.getText();
            String prenume = prenumeField.getText();
            String tel = telField.getText();
            String adresa = adresaField.getText();


            Cititor cititor = new Cititor(id, nume, prenume, tel, adresa);
            cititorDAO.updateReader(cititor);

            // Afișează mesajul de succes
            JOptionPane.showMessageDialog(this, "Cititor modificat cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);

            // Resetează câmpurile formularului
            numeField.setText("");
            prenumeField.setText("");
            telField.setText("");
            adresaField.setText("");

            loadReaders();
        }
    }

    private void deleteReader() {
        int selectedRow = readerTable.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            cititorDAO.deleteReader(id);

            // Afișează mesajul de succes
            JOptionPane.showMessageDialog(this, "Cititor sters cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);

            // Resetează câmpurile formularului
            numeField.setText("");
            prenumeField.setText("");
            telField.setText("");
            adresaField.setText("");

            loadReaders();
        }
    }
}
