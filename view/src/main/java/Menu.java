import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JMenuBar menuBar;

    private JMenu acasaMenu;
    private JMenu cartiMenu;
    private JMenu cititoriMenu;
    private JMenu inchirieriMenu;
    private JMenu returnMenu;
    private JMenu iesireMenu;
    private JMenu iesireSpace;

    private JMenuItem menuFileAcasa;
    private JMenuItem menuFileExit;
    private JMenuItem menuCartiAdaugare;
    private JMenuItem menuCartiAfisare;
    private JMenuItem menuCititAdaugare;
    private JMenuItem menuCititAfisare;
    private JMenuItem menuInchiriereImprumut;
    private JMenuItem menuInchiriereAfisare;
    private JMenuItem menuReturnCarte;
    private JMenuItem menuReturnAfisare;

    private JMenuItem menuIesireApp;
    private JMenuItem menuIesirePag;

    public Menu(MainFrame mainFrame) {
        menuBar = new JMenuBar();
        acasaMenu = new JMenu("File");
        cartiMenu = new JMenu("Carti");
        cititoriMenu = new JMenu("Cititori");
        inchirieriMenu = new JMenu("Inchirieri");
        returnMenu = new JMenu("Returnari");
        iesireMenu = new JMenu("Iesire");
        iesireSpace = new JMenu();

        menuFileAcasa = new JMenuItem("Acasa");
        menuFileExit = new JMenuItem("EXIT");
        menuCartiAdaugare = new JMenuItem("Adaugare carti");
        menuCartiAfisare = new JMenuItem("Afisare carti");
        menuCititAdaugare = new JMenuItem("Adaugare cititori");
        menuCititAfisare = new JMenuItem("Afisare cititori");
        menuInchiriereImprumut = new JMenuItem("Imprumutare carte");
        menuInchiriereAfisare = new JMenuItem("Afisare imprumuturi");
        menuReturnCarte = new JMenuItem("Returnare carte");
        menuReturnAfisare = new JMenuItem("Afisare ruturnari");


        menuIesireApp = new JMenuItem("Iesire din aplicatie");
        menuIesirePag = new JMenuItem("Iesire din pagina");

        //stilizarea meniului
        for (JMenu menu : new JMenu[]{acasaMenu, cartiMenu, cititoriMenu, inchirieriMenu, returnMenu}) {
            menu.setFont(new Font("Arial", Font.PLAIN, 18));
            menu.setBorder(new EmptyBorder(10, 20, 10, 20));
        }
        iesireSpace.setBorder(new EmptyBorder(10, 20, 10, 350));

        //adaugarea in meniu
        acasaMenu.add(menuFileAcasa);
        acasaMenu.addSeparator();
        acasaMenu.add(menuFileExit);
        cartiMenu.add(menuCartiAdaugare);
        cartiMenu.add(menuCartiAfisare);
        cititoriMenu.add(menuCititAdaugare);
        cititoriMenu.add(menuCititAfisare);
        inchirieriMenu.add(menuInchiriereImprumut);
        inchirieriMenu.add(menuInchiriereAfisare);
        returnMenu.add(menuReturnCarte);
        returnMenu.add(menuReturnAfisare);
        iesireMenu.add(menuIesireApp);
        iesireMenu.add(menuIesirePag);

        menuBar.add(acasaMenu);
        menuBar.add(cartiMenu);
        menuBar.add(cititoriMenu);
        menuBar.add(inchirieriMenu);
        menuBar.add(returnMenu);
        menuBar.add(iesireSpace);
        menuBar.add(iesireMenu);

        //EVENUMENTE
            //file
        menuFileAcasa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showWelcomePanel();
            }
        });
        menuFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

            //carti
        menuCartiAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showAddBookPanel();
            }
        });
        menuCartiAfisare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showShowBook();
            }
        });

            //cititori
        menuCititAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showAddReaderPanel();
            }
        });
        menuCititAfisare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showShowReader();
            }
        });

            //inchiriere
        menuInchiriereImprumut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showInchirierePanel();
            }
        });
        menuInchiriereAfisare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showShowInchirierePanel();
            }
        });

            //returnare
        menuReturnCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showReturnarePanel();
            }
        });
        menuReturnAfisare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showShowReturnarePanel();
            }
        });

            //iesire
        menuIesirePag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showWelcomePanel();
            }
        });
        menuIesireApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
