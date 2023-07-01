package Ameaca.Views;

import Ameaca.Entities.*;
import Ameaca.Services.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProductGUI extends GUI {

    private JPanel panel = new JPanel();
    ImageIcon imgicon = new ImageIcon("icone-registro-produto.png");
    Image image = imgicon.getImage();
    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    private JButton menuButton = new JButton(new ImageIcon(newimg));

    private JTextField createTextField(JPanel p, String rotulo, int largura) {
        JPanel pnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnl.setPreferredSize(new Dimension(600, 30));
        JLabel lbl = new JLabel(rotulo);
        lbl.setPreferredSize(new Dimension(150, 30));
        JTextField tbx = new JTextField(largura);
        pnl.add(lbl);
        pnl.add(tbx);
        p.add(pnl);
        return tbx;
    }

    public JButton getMenuButton() {
        return menuButton;
    }

    public JPanel getPanel() {
        return panel;
    }

    public ProductGUI() {
        panel.setLayout(null);
        JLabel titleWrapper = new JLabel("Insira os dados do produto");
        titleWrapper.setBounds(30, 20, 170, 15);

        JLabel labelProductName = new JLabel("Nome do produto");
        labelProductName.setBounds(30, 60, 170, 15);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 53, 150, 30);

        JLabel labelVersion = new JLabel("Versão do produto");
        labelVersion.setBounds(30, 106, 170, 15);

        JTextField versionField = new JTextField();
        versionField.setBounds(150, 103, 150, 30);

        JButton submit = new JButton("CADASTRAR");
        submit.setBounds(210, 180, 250, 30);

        panel.add(titleWrapper);
        panel.add(labelProductName);
        panel.add(nameField);
        panel.add(labelVersion);
        panel.add(versionField);
        panel.add(submit);

        submit.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    String txtName = nameField.getText().trim();
                    String txtVersion = versionField.getText().toLowerCase().trim();

                    if (txtName.isEmpty() || txtVersion.isEmpty()) {
                        showError("Campos vazios", "Por favor, preencha todos os campos");
                    } else {
                        Product product = new Product();
                        ProductService productService = new ProductService();
                        product.setName(txtName);
                        productService.add(product, txtVersion);
                    }
                }
            }
        );
    }
}
