package Ameaca.Views;

import Ameaca.Entities.*;
import Ameaca.Services.*;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AboutGUI extends GUI {

    private JPanel panel = new JPanel();
    ImageIcon imgicon = new ImageIcon("icone-sobre.png");
    Image image = imgicon.getImage();
    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    private JButton menuButton = new JButton(new ImageIcon(newimg));

    public JButton getMenuButton() {
        return menuButton;
    }

    public JPanel getPanel() {
        return panel;
    }

    public AboutGUI() {}
}
