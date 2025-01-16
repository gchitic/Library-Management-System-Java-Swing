import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class PanelShowInchirieri extends JPanel {
    private JTable inchiriereTable;
    private DefaultTableModel tableModel;

    private JTextField id_carteField, id_cititorField;
    private JDateChooser dateChooserInchiriere, dateChooserEstReturnare;

    private InchiriereDAO inchiriereDAO;

    public PanelShowInchirieri() {
        inchiriereDAO = new InchiriereDAO();

        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#ced4da"));

        //Tabelul
        tableModel = new DefaultTableModel(new String[]{"ID","Id_carte", "Carte", "Id_cititor", "Cititor","Nr.tel", "Adresa", "Data inchiriere", "Data estimarii returnare"}, 0);
        inchiriereTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(inchiriereTable);
        add(scrollPane, BorderLayout.CENTER);

        //Formularul
        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.setBorder(new EmptyBorder(50, 250, 50, 250));

        formPanel.add(new JLabel("Id_carte:"));
        id_carteField = new JTextField();
        formPanel.add(id_carteField);

        formPanel.add(new JLabel("Id_cititor:"));
        id_cititorField = new JTextField();
        formPanel.add(id_cititorField);

        formPanel.add(new JLabel("Data inchirierii:"));
        dateChooserInchiriere = new JDateChooser();
        formPanel.add(dateChooserInchiriere);

        formPanel.add(new JLabel("Data estimarii returnare:"));
        dateChooserEstReturnare = new JDateChooser();
        formPanel.add(dateChooserEstReturnare);


        this.add(formPanel,BorderLayout.NORTH);

        //afisarea imprumuturilor in tabel
        loadInchirieri();


        inchiriereTable.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = inchiriereTable.getSelectedRow();
            if (selectedRow >= 0) {
                id_carteField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                id_cititorField.setText(tableModel.getValueAt(selectedRow, 3).toString());
                dateChooserInchiriere.setDate((Date) tableModel.getValueAt(selectedRow, 7));
                dateChooserEstReturnare.setDate((Date) tableModel.getValueAt(selectedRow, 8));
            }
        });

    }

    public void loadInchirieri() {
        tableModel.setRowCount(0);
        List<Inchiriere> inchirieri = inchiriereDAO.showinchirieri();
        for (Inchiriere inchiriere : inchirieri) {
            tableModel.addRow(new Object[]{
                    inchiriere.getId_inchiriere(), inchiriere.getCarte_id(), inchiriere.getCarte(),
                    inchiriere.getCititor_id(), inchiriere.getCititor(), inchiriere.getNr_tel(), inchiriere.getAdresa(),
                    inchiriere.getData_inchiriere(), inchiriere.getData_estim_return()
            });
        }
    }

}
