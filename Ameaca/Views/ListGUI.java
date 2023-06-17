package Ameaca.Views;

import Ameaca.Entities.*;
import Ameaca.Services.*;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
        TTypeService ttypeService = new TTypeService();
        ThreatService threatService = new ThreatService();
        List<Threat> threatList = threatService.list();
        JPanel wrapper = new JPanel();
        JLabel labelCVE, labelDiscoberyDate, typeLabel, criticallyLabel;
        JButton deleteBtn, updateBtn, downloadBtn;
        wrapper.setLayout(null);
        wrapper.setBorder(new EmptyBorder(30, 30, 30, 30));
        int gap = 20;

        for (Threat t : threatList) {
            labelCVE = new JLabel(t.getCVE());
            labelCVE.setBounds(30, gap, 100, 40);

            labelDiscoberyDate = new JLabel("Data da descoberta: " + t.getDiscoveryDate());
            labelDiscoberyDate.setBounds(30, gap + 25, 300, 40);

            typeLabel = new JLabel("Tipo: " + ttypeService.getType(t.getTypeID()).getName());
            typeLabel.setBounds(200, gap, 150, 40);

            criticallyLabel = new JLabel("Nível de criticidade: " + t.getCriticallyLevelID());
            criticallyLabel.setBounds(300, gap, 150, 40);

            deleteBtn = new JButton("Deletar");
            deleteBtn.setBounds(500, gap + 15, 150, 30);

            updateBtn = new JButton("Atualizar dados");
            updateBtn.setBounds(30, gap + 60, 150, 23);

            downloadBtn = new JButton("Download correção");
            downloadBtn.setBounds(200, gap + 60, 150, 23);

            wrapper.add(labelCVE);
            wrapper.add(labelDiscoberyDate);
            wrapper.add(typeLabel);
            wrapper.add(criticallyLabel);
            wrapper.add(deleteBtn);
            wrapper.add(updateBtn);
            wrapper.add(downloadBtn);
            gap += 100;
        }

        JScrollPane scrollPane = new JScrollPane(
            wrapper,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setBounds(350, 40, 250, 70);
        panel.add(scrollPane);
    }
}
