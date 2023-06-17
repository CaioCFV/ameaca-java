package Ameaca.Views;

import Ameaca.Entities.*;
import Ameaca.Services.*;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;

public class ListGUI extends GUI {

    private JPanel panel = new JPanel(new BorderLayout());
    private JButton menuButton = new JButton("Lista de ameaças");

    public JButton getMenuButton() {
        return menuButton;
    }

    public JPanel getPanel() {
        return panel;
    }

    public ListGUI() {
        ThreatService threatService = new ThreatService();
        List<Threat> threatList = threatService.list();
    }
}
