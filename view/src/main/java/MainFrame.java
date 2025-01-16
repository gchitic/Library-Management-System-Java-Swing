import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Menu menu;
    private PanelWelcome panelWelcome;
    private PanelAddBook panelAddBook;
    private PanelShowBook panelShowBook;
    private PanelAddReader panelAddReader;
    private PanelShowReader panelShowReader;
    private PanelInchiriere panelInchiriere;
    private PanelShowInchirieri panelShowInchirieri;
    private PanelReturnare panelReturnare;
    private PanelShowReturnare panelShowReturnare;
    private Footer footer;

    public MainFrame() {
        this.setTitle("Biblioteca");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLayout(new BorderLayout());

        //Initializarea obiectelor
        menu = new Menu(this);
        panelWelcome = new PanelWelcome(this);
        panelShowBook = new PanelShowBook();
        panelAddBook = new PanelAddBook(panelShowBook);
        panelShowReader =  new PanelShowReader();
        panelAddReader = new PanelAddReader(panelShowReader);
        panelShowInchirieri = new PanelShowInchirieri();
        panelInchiriere = new PanelInchiriere(panelShowInchirieri);
        panelShowReturnare = new PanelShowReturnare();
        panelReturnare = new PanelReturnare(panelShowReturnare);
        footer = new Footer();

        //Adăugarea componentelor de bază
        this.setJMenuBar(menu.getMenuBar());
        this.add(panelWelcome, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);

        this.setVisible(true);
    }


    public void showWelcomePanel() {
        this.getContentPane().removeAll();
        this.add(panelWelcome, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    //carti
    public void showAddBookPanel() {
        this.getContentPane().removeAll();
        this.add(panelAddBook, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void showShowBook() {
        this.getContentPane().removeAll();
        this.add(panelShowBook, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    //cititori
    public void showAddReaderPanel() {
        this.getContentPane().removeAll();
        this.add(panelAddReader, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }
    public void showShowReader() {
        this.getContentPane().removeAll();
        this.add(panelShowReader, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    //inchiriere
    public void showInchirierePanel() {
        this.getContentPane().removeAll();
        this.add(panelInchiriere, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }
    public void showShowInchirierePanel() {
        this.getContentPane().removeAll();
        this.add(panelShowInchirieri, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    //returnare
    public void showReturnarePanel() {
        this.getContentPane().removeAll();
        this.add(panelReturnare, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }
    public void showShowReturnarePanel() {
        this.getContentPane().removeAll();
        this.add(panelShowReturnare, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}

