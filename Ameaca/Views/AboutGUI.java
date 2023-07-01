package Ameaca.Views;

import java.awt.ComponentOrientation;
import java.awt.Image;
import javax.swing.*;

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

    public AboutGUI() {
        panel.setLayout(null);
        ImageIcon imgicon = new ImageIcon("logofaeterj.png");
        Image image = imgicon.getImage();
        Image newimg = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        JLabel imageWrapp = new JLabel(new ImageIcon(newimg));
        imageWrapp.setBounds(230, 20, 200, 200);
        JTextArea text = new JTextArea();
        text.setText(
            "Trabalho desenvolvido em 2023 no curso de Programação em Java, com intuito de registrar possíveis ameaças de aplicações.\n\nDesenvolvido por Caio F. Vieira"
        );
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.setEditable(false);
        text.setComponentOrientation(ComponentOrientation.UNKNOWN);

        text.setBounds(40, 220, 400, 100);
        panel.add(imageWrapp);
        panel.add(text);
    }
}
