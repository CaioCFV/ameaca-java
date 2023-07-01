package Ameaca.Views;

import Ameaca.Services.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainGUI extends JFrame {

    private static Container container;
    private static JToolBar toolbar = new JToolBar();
    private static JPanel cards = new JPanel();
    private static CardLayout layout = new CardLayout();

    public MainGUI() {
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        setTitle("Registro de ameaças");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon imgicon = new ImageIcon("logo.png");
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
        try {
            ProductGUI pGUI = new ProductGUI();
            ThreatGUI tGUI = new ThreatGUI();
            ListGUI lGUi = new ListGUI();
            AboutGUI aGUI = new AboutGUI();
            addPage(lGUi.getPanel(), lGUi.getMenuButton(), "screen1");
            addPage(pGUI.getPanel(), pGUI.getMenuButton(), "screen2");
            addPage(tGUI.getPanel(), tGUI.getMenuButton(), "screen3");
            addPage(aGUI.getPanel(), aGUI.getMenuButton(), "screen4");
        } catch (BussinesException err) {
            JOptionPane.showMessageDialog(
                null,
                err.getMessage(),
                "Erro",
                JOptionPane.WARNING_MESSAGE
            );
        } catch (Exception err) {
            JOptionPane.showMessageDialog(
                null,
                "Erro não esperado! entre em contato com os desenvolvedores\n\n" + err.getMessage(),
                "Erro Crítico",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void updatePage(int index) {
        String n = "pscreen" + index;
        JPanel p = new ListGUI().getPanel();
        cards.removeAll();
        cards.updateUI();
    }

    public static void addPage(JPanel p, JButton b, String n) {
        p.setVisible(false);

        b.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    JPanel p2;
                    p2 = new ListGUI().getPanel();
                    cards.removeAll();
                    if (n == "screen2") {
                        p2 = new ProductGUI().getPanel();
                    } else if (n == "screen3") {
                        p2 = new ThreatGUI().getPanel();
                    } else if (n == "screen4") {
                        p2 = new AboutGUI().getPanel();
                    }
                    cards.add(n, p2);
                    cards.updateUI();
                    layout.show(cards, n);
                }
            }
        );
        cards.add(n, p);
        toolbar.add(b);
        toolbar.addSeparator();
    }
}
