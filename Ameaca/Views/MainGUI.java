package Ameaca.Views;

import Ameaca.Services.BussinesException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainGUI extends JFrame {

    private static Container container;
    private static JToolBar toolbar = new JToolBar();
    private static JPanel cards = new JPanel();
    private static CardLayout layout = new CardLayout();

    public MainGUI() {
        setDefaultLookAndFeelDecorated(true);
        setTitle("Registro de ameaças");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon imgicon = new ImageIcon("/assets/logo.png");
        setIconImage(imgicon.getImage());
        container = getContentPane();
        cards.setLayout(layout);
        container.setLayout(new BorderLayout());
        container.add(toolbar, BorderLayout.NORTH);
        container.add(cards, BorderLayout.CENTER);
        toolbar.setRollover(true);
        toolbar.setFloatable(false);
    }

    public void init() {
        this.setVisible(true);

        ProductGUI pGUI = new ProductGUI();
        ThreatGUI tGUI = new ThreatGUI();

        addPage(pGUI.getPanel(), pGUI.getMenuButton(), "screen1");
        addPage(tGUI.getPanel(), tGUI.getMenuButton(), "screen2");
    }

    public static void addPage(JPanel p, JButton b, String n) {
        p.setVisible(false);
        b.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    layout.show(cards, n);
                }
            }
        );
        cards.add(n, p);
        toolbar.add(b);
        toolbar.addSeparator();
    }
}
