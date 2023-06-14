package Ameaca.Views;

import Ameaca.Entities.*;
import Ameaca.Services.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProductGUI extends GUI {

    private JPanel panel = new JPanel(new BorderLayout());
    private JButton menuButton = new JButton("Adicionar novo produto");

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

    public static void submitForm() {}

    public ProductGUI() {
        JTextField nameField, versionField;
        JPanel titleWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titleWrapper.setBorder(new EmptyBorder(10, 50, 10, 10));
        titleWrapper.add(new JLabel("Insira os dados do produto"));

        JPanel inputWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputWrapper.setBorder(new EmptyBorder(10, 50, 10, 10));
        nameField = createTextField(inputWrapper, "Nome do produto", 15);
        versionField = createTextField(inputWrapper, "Versão do produto", 15);

        JPanel buttonWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonWrapper.setBorder(new EmptyBorder(50, 50, 50, 50));
        JButton submit = new JButton("Enviar");
        buttonWrapper.add(submit);

        JLabel feedback = new JLabel();
        buttonWrapper.add(feedback);

        panel.add(titleWrapper, BorderLayout.NORTH);
        panel.add(inputWrapper, BorderLayout.CENTER);
        panel.add(buttonWrapper, BorderLayout.SOUTH);

        submit.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    try {
                        String txtName = nameField.getText().trim();
                        String txtVersion = versionField.getText().toLowerCase().trim();

                        Product product = new Product();
                        product.setName(txtName);

                        Version version = new Version();
                        version.setName(txtVersion);

                        ProductService productService = new ProductService();
                        VersionService versionService = new VersionService();
                        List<Product> foundedproducts = productService.findByName(txtName);
                        List<Version> foundedversions = versionService.findByName(txtVersion);

                        if (foundedproducts.isEmpty()) {
                            productService.insert(product);
                            foundedproducts = productService.findByName(product.getName());
                            product.setID(foundedproducts.get(0).getID());
                        } else {
                            product.setID(foundedproducts.get(0).getID());
                        }

                        foundedversions = productService.getVersionsByProduct(product);
                        boolean found = false;
                        for (Version v : foundedversions) {
                            if (v.getName().contains(txtVersion)) {
                                found = true;
                            }
                        }
                        System.out.println(found);
                        if (!found) {
                            foundedversions = versionService.findByName(txtVersion);
                            if (foundedversions.isEmpty()) {
                                version.setName(versionField.getText());
                                versionService.insert(version);
                                foundedversions = versionService.findByName(versionField.getText());
                            } else {
                                version.setID(foundedversions.get(0).getID());
                            }
                            productService.addVersion(product, version);
                            feedback.setText("Produto inserido com sucesso");
                        } else {
                            throw new BussinesException("Já existe um produt com essa versão");
                        }
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
                            "Erro não esperado! entre em contato com os desenvolvedores\n\n" +
                            err.getMessage(),
                            "Erro Crítico",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            }
        );
    }
}
