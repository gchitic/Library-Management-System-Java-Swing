import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelWelcome extends JPanel {
    public PanelWelcome(MainFrame mainFrame) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#ced4da"));

        //TITLU
        JLabel lblWelcome = new JLabel("Bine ati venit la biblioteca MANUSCRIPT!");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 40));
        this.setBorder(new EmptyBorder(100, 100, 10, 50));

        //BUTOANE
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());
        panelButtons.setBackground(Color.decode("#ced4da"));
        JButton btnAddBook = new JButton("Adauga carte");
        JButton btnAddReader = new JButton("Adauga cititor");
        JButton btnRentBook = new JButton("Imprumuta carte");
        JButton btnReturnBook = new JButton("Returneaza carte");

        //setarea culorii si marimii butoanelor
        Dimension btnSize = new Dimension(200, 100);
        Color btnColor = new Color(100, 150, 250);
        for (JButton button : new JButton[]{btnAddBook, btnAddReader, btnRentBook, btnReturnBook}) {
            button.setPreferredSize(btnSize);
            button.setBackground(btnColor);
            button.setForeground(Color.WHITE);
        }

        panelButtons.add(btnRentBook);
        panelButtons.add(btnReturnBook);
        panelButtons.add(btnAddBook);
        panelButtons.add(btnAddReader);

        this.add(lblWelcome, BorderLayout.NORTH);
        this.add(panelButtons, BorderLayout.CENTER);



        //EVENIMENTE
        btnRentBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showInchirierePanel();
            }
        });
        btnReturnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showReturnarePanel();
            }
        });
        btnAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showAddBookPanel();
            }
        });
        btnAddReader.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showAddReaderPanel();
            }
        });

    }
}
