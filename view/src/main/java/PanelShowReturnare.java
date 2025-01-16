import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class PanelShowReturnare extends JPanel {
    private JTable returnareTable;
    private DefaultTableModel tableModel;

    private JTextField id_inchiriereField;
    private JDateChooser dateChooserInchiriere, dateChooserEstReturnare, dataChooserReturnare;

    private ReturnareDAO returnareDAO;

    public PanelShowReturnare() {
        returnareDAO = new ReturnareDAO();

        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#ced4da"));

        //Tabelul
        tableModel = new DefaultTableModel(new String[]{"ID_return","Id_inchiriere", "Id_carte", "Carte", "Id_cititor",
                "Cititor", "Nr.tel", "Adresa", "Data inchiriere", "Data estim. return", "Dara return"}, 0);
        returnareTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(returnareTable);
        add(scrollPane, BorderLayout.CENTER);

        //Formularul
        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.setBorder(new EmptyBorder(50, 250, 50, 250));

        formPanel.add(new JLabel("Id_inchiriere:"));
        id_inchiriereField = new JTextField();
        formPanel.add(id_inchiriereField);

        formPanel.add(new JLabel("Data inchirierii:"));
        dateChooserInchiriere = new JDateChooser();
        formPanel.add(dateChooserInchiriere);

        formPanel.add(new JLabel("Data estimarii returnare:"));
        dateChooserEstReturnare = new JDateChooser();
        formPanel.add(dateChooserEstReturnare);

        formPanel.add(new JLabel("Data returnarii:"));
        dataChooserReturnare = new JDateChooser();
        formPanel.add(dataChooserReturnare);


        this.add(formPanel,BorderLayout.NORTH);

        //afisarea returnarilor in tabel
        loadReturnari();


        returnareTable.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = returnareTable.getSelectedRow();
            if (selectedRow >= 0) {
                id_inchiriereField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                dateChooserInchiriere.setDate((Date) tableModel.getValueAt(selectedRow, 8));
                dateChooserEstReturnare.setDate((Date) tableModel.getValueAt(selectedRow, 9));
                dataChooserReturnare.setDate((Date) tableModel.getValueAt(selectedRow, 10));
            }
        });


    }

    public void loadReturnari() {
        tableModel.setRowCount(0);
        List<Returnare> returnari = returnareDAO.showReturnari();
        for (Returnare returnare : returnari) {
            tableModel.addRow(new Object[]{
                    returnare.getId_returnare(), returnare.getInchiriere_id(), returnare.getCarte_id(), returnare.getCarte(),
                    returnare.getCititor_id(), returnare.getCititor(), returnare.getNr_tel(), returnare.getAdresa(),
                    returnare.getData_inchiriere(), returnare.getData_estim_return(), returnare.getData_return()
            });
        }
    }
}
