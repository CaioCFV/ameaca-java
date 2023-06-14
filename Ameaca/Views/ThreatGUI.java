package Ameaca.Views;

import Ameaca.Entities.*;
import Ameaca.Services.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

class JTextFieldNumbers extends JTextField {

    private int max = 0;

    public JTextFieldNumbers(int max) {
        super();
        this.max = max;
        addKeyListener(
            new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    jTextFieldKeyTyped(evt);
                }
            }
        );
    }

    private void jTextFieldKeyTyped(KeyEvent evt) {
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        if ((getText().length() >= max) && (max > 0)) {
            evt.consume();
        }
    }
}

public class ThreatGUI extends GUI {

    private JPanel panel = new JPanel();
    private JButton menuButton = new JButton("Registrar ameaça");

    public JButton getMenuButton() {
        return menuButton;
    }

    public JPanel getPanel() {
        return panel;
    }

    public static void submitForm() {}

    public ThreatGUI() {
        panel.setLayout(null);
        JLabel pTitle = new JLabel("Insira os dados da ameaça");
        pTitle.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        // pTitle.setOpaque(true);
        // pTitle.setBackground(Color.red);
        pTitle.setBounds(20, 20, 170, 15);

        JLabel labelCVE = new JLabel("CVE -");
        labelCVE.setBounds(20, 60, 50, 15);

        JTextFieldNumbers cveFieldCode = new JTextFieldNumbers(4);
        cveFieldCode.setBounds(60, 55, 45, 30);
        cveFieldCode.setHorizontalAlignment(JTextField.CENTER);

        JLabel cveSeparator = new JLabel(" - ");
        cveSeparator.setBounds(107, 60, 50, 15);

        JTextFieldNumbers cveFieldYear = new JTextFieldNumbers(5);
        cveFieldYear.setBounds(120, 55, 50, 30);
        cveFieldYear.setHorizontalAlignment(JTextField.CENTER);

        panel.add(pTitle);
        panel.add(labelCVE);
        panel.add(cveFieldCode);
        panel.add(cveSeparator);
        panel.add(cveFieldYear);

        // DATE
        JLabel labelDate = new JLabel("Data da descoberta");
        labelDate.setBounds(20, 130, 130, 15);

        JTextFieldNumbers dateFieldDay = new JTextFieldNumbers(2);
        dateFieldDay.setBounds(140, 123, 30, 30);
        dateFieldDay.setHorizontalAlignment(JTextField.CENTER);

        JLabel dateSeparator1 = new JLabel(" / ");
        dateSeparator1.setBounds(175, 130, 10, 15);

        JTextFieldNumbers dateFieldMonth = new JTextFieldNumbers(2);
        dateFieldMonth.setBounds(190, 123, 30, 30);
        dateFieldMonth.setHorizontalAlignment(JTextField.CENTER);

        JLabel dateSeparator2 = new JLabel(" / ");
        dateSeparator2.setBounds(223, 130, 10, 15);

        JTextFieldNumbers dateFieldYear = new JTextFieldNumbers(4);
        dateFieldYear.setBounds(235, 123, 50, 30);
        dateFieldYear.setHorizontalAlignment(JTextField.CENTER);
        panel.add(labelDate);
        panel.add(dateFieldDay);
        panel.add(dateSeparator1);
        panel.add(dateFieldMonth);
        panel.add(dateSeparator2);
        panel.add(dateFieldYear);

        //TYPES
        JLabel labelCritic = new JLabel("Nível de criticidade");
        labelCritic.setBounds(20, 175, 150, 15);
        panel.add(labelCritic);

        ButtonGroup radioGroup = new ButtonGroup();
        JRadioButton r;
        String[] critically = { "BAIXA", "MÉDIA", "ALTA" };
        int gap = 0;
        for (int i = 0; i < critically.length; i++) {
            gap = i * 30;
            r = new JRadioButton(critically[i]);
            r.setBounds(20, 195 + gap, 100, 30);
            radioGroup.add(r);
            panel.add(r);
        }
        //throw new BussinesException("Teste");
        //         TTypeService typeService = new TTypeService();
        // List<TType> types = typeService.listar();
        // System.err.println(types);
        //date

        // submit.addActionListener(
        //     new ActionListener() {
        //         public void actionPerformed(ActionEvent ae) {
        //             cve = "CVE-" + s.nextString();
        //             //validar se tem 4 digitos
        //             System.out.println("Digite o codigo de 5 digitos ameaca: ");
        //             //validar se tem 5 digitos
        //             cve += "-" + s.nextString();
        //             System.out.println("Digite o dia da descoberta: ");
        //             discovery_date = s.nextString() + '/';
        //             System.out.println("Digite o mes da descoberta: ");
        //             discovery_date += s.nextString() + '/';
        //             System.out.println("Digite o ano da descoberta: ");
        //             discovery_date += s.nextString();
        //             System.out.println(
        //                 "Digite o nivel de criticidade:  1 - LOW, 2 - MEDIUM, 3 - HIGH"
        //             );
        //             cnumb = s.nextInt();
        //             System.out.println("Selecione um tipo de ameaça:");
        //             TTypeService tt_service = new TTypeService();
        //             List<TType> colecao = tt_service.listar();
        //             index = 0;
        //             for (TType d : colecao) {
        //                 System.out.println(index + 1 + " - " + d.getName());
        //                 index++;
        //             }

        //             System.out.println("Quais produtos essa ameça afeta ?:");
        //             ProductService productService = new ProductService();
        //             List<Product> pColecao = productService.list();
        //             index = 0;
        //             for (Product d : pColecao) {
        //                 System.out.println(index + 1 + " - " + d.getName());
        //                 index++;
        //             }
        //             pid = s.nextInt() - 1;
        //             System.out.println("Quais versões desse produto a ameaça está presente ?:");
        //             List<Version> versions = productService.getVersionsByProduct(pColecao.get(pid));
        //             index = 0;
        //             for (Version v2 : versions) {
        //                 System.out.println(index + 1 + " - " + v2.getName());
        //                 index++;
        //             }
        //             versionsV = s.nextString();
        //             Threat t = new Threat();
        //             t.setCVE(cve);
        //             t.setDiscoveryDate(discovery_date);
        //             t.setCriticallyLevelID(cnumb);
        //             t.setTypeID(index - 1);
        //             th_service.add(t);
        //             break;

        //         String txtName = nameField.getText().trim();
        //         String txtVersion = versionField.getText().toLowerCase().trim();

        //         Product product = new Product();
        //         product.setName(txtName);

        //         Version version = new Version();
        //         version.setName(txtVersion);

        //         ProductService productService = new ProductService();
        //         VersionService versionService = new VersionService();
        //         List<Product> foundedproducts = productService.findByName(txtName);
        //         List<Version> foundedversions = versionService.findByName(txtVersion);

        //         if (foundedproducts.isEmpty()) {
        //             productService.insert(product);
        //             foundedproducts = productService.findByName(product.getName());
        //             product.setID(foundedproducts.get(0).getID());
        //         } else {
        //             product.setID(foundedproducts.get(0).getID());
        //         }

        //         foundedversions = productService.getVersionsByProduct(product);
        //         boolean found = false;
        //         for (Version v : foundedversions) {
        //             if (v.getName().contains(txtVersion)) {
        //                 found = true;
        //             }
        //         }
        //         System.out.println(found);
        //         if (!found) {
        //             foundedversions = versionService.findByName(txtVersion);
        //             if (foundedversions.isEmpty()) {
        //                 version.setName(versionField.getText());
        //                 versionService.insert(version);
        //                 foundedversions = versionService.findByName(versionField.getText());
        //             } else {
        //                 version.setID(foundedversions.get(0).getID());
        //             }
        //             productService.addVersion(product, version);
        //             feedback.setText("Produto inserido com sucesso");
        //         } else {
        //             feedback.setText("Este produto já está configurado!");
        //         }
        //     }
        // }
        //);
    }
}
