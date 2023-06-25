package Ameaca.Views;

import Ameaca.Entities.*;
import Ameaca.Services.*;
import java.awt.BorderLayout;
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
        JTextField nameField, versionField;
        JPanel titleWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titleWrapper.setBorder(new EmptyBorder(10, 50, 10, 10));
        titleWrapper.add(new JLabel("Insira os dados do produto"));

        JPanel inputWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputWrapper.setBounds(130, 310, 200, 35);
        inputWrapper.setBorder(new EmptyBorder(10, 50, 10, 10));
        nameField = createTextField(inputWrapper, "Nome do produto", 15);
        versionField = createTextField(inputWrapper, "Versão do produto", 15);

        JPanel buttonWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonWrapper.setBorder(new EmptyBorder(50, 50, 50, 50));
        JButton submit = new JButton("Enviar");
        buttonWrapper.add(submit);

        JLabel feedback = new JLabel();
        buttonWrapper.add(feedback);

        panel.add(titleWrapper);
        panel.add(inputWrapper);
        panel.add(buttonWrapper);
        panel.setVisible(true);
        submit.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    Product product = new Product();
                    String txtName = nameField.getText().trim();
                    String txtVersion = versionField.getText().toLowerCase().trim();
                    ProductService productService = new ProductService();

                    if (!productService.exists(txtName, txtVersion)) {
                        VersionService versionService = new VersionService();
                        Version v = new Version();
                        if (!versionService.exists(txtVersion)) {
                            v.setName(txtVersion);
                            v = versionService.add(v);
                        } else {
                            v = versionService.getVersion(txtVersion).get(0);
                        }
                        product.setName(txtName);
                        product.setVersionID(v.getID());
                        productService.add(product);
                        showSuccess("Sucesso", "O produto foi cadastrado com sucesso!");
                    } else {
                        showError("Erro", "O produto informado já existe!");
                    }
                }
            }
        );
    }
}
