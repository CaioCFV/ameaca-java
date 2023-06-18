package Ameaca.Views;

import Ameaca.Entities.*;
import Ameaca.Services.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;
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

    public static void updateThreat(Threat threat) {
        ThreatService threatService = new ThreatService();
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame, "Atualiar ameaça | " + threat.getCVE());
        dialog.setLayout(null);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(null);

        JLabel labelCVE = new JLabel("CVE -");
        labelCVE.setBounds(20, 20, 50, 15);

        JTextFieldNumbers cveFieldYear = new JTextFieldNumbers(4);
        cveFieldYear.setText(threat.getCVE().split("-")[1]);
        cveFieldYear.setBounds(55, 15, 45, 30);
        cveFieldYear.setHorizontalAlignment(JTextField.CENTER);

        JLabel cveSeparator = new JLabel(" - ");
        cveSeparator.setBounds(100, 20, 50, 15);

        JTextFieldNumbers cveFieldCode = new JTextFieldNumbers(5);
        cveFieldCode.setText(threat.getCVE().split("-")[2]);
        cveFieldCode.setBounds(113, 15, 55, 30);
        cveFieldCode.setHorizontalAlignment(JTextField.CENTER);

        dialog.add(labelCVE);
        dialog.add(cveFieldCode);
        dialog.add(cveSeparator);
        dialog.add(cveFieldYear);

        // DATE
        JLabel labelDate = new JLabel("Data da descoberta:");
        labelDate.setBounds(20, 63, 130, 15);

        JTextFieldNumbers dateFieldDay = new JTextFieldNumbers(2);
        dateFieldDay.setText(threat.getDiscoveryDate().split("/")[0]);
        dateFieldDay.setBounds(140, 58, 30, 30);
        dateFieldDay.setHorizontalAlignment(JTextField.CENTER);

        JLabel dateSeparator1 = new JLabel("/");
        dateSeparator1.setBounds(175, 63, 10, 15);

        JTextFieldNumbers dateFieldMonth = new JTextFieldNumbers(2);
        dateFieldMonth.setText(threat.getDiscoveryDate().split("/")[1]);
        dateFieldMonth.setBounds(185, 58, 30, 30);
        dateFieldMonth.setHorizontalAlignment(JTextField.CENTER);

        JLabel dateSeparator2 = new JLabel("/");
        dateSeparator2.setBounds(220, 63, 10, 15);

        JTextFieldNumbers dateFieldYear = new JTextFieldNumbers(4);
        dateFieldYear.setText(threat.getDiscoveryDate().split("/")[2]);
        dateFieldYear.setBounds(230, 58, 50, 30);
        dateFieldYear.setHorizontalAlignment(JTextField.CENTER);

        dialog.add(labelDate);
        dialog.add(dateFieldDay);
        dialog.add(dateSeparator1);
        dialog.add(dateFieldMonth);
        dialog.add(dateSeparator2);
        dialog.add(dateFieldYear);

        //CRITICALLY
        JLabel labelCritic = new JLabel("Nível de criticidade");
        labelCritic.setBounds(20, 100, 150, 15);
        dialog.add(labelCritic);

        ButtonGroup criticallyField = new ButtonGroup();
        JRadioButton r;
        String[] critically = { "BAIXA", "MÉDIA", "ALTA" };
        int gap = 0;
        for (int i = 0; i < critically.length; i++) {
            gap = i * 30;
            r = new JRadioButton(critically[i]);
            if (threat.getCriticallyLevelID() == i) {
                r.setSelected(true);
            }
            r.setActionCommand("" + i);
            r.setBounds(15, 120 + gap, 100, 30);
            criticallyField.add(r);
            dialog.add(r);
        }

        //TYPES
        JPanel wrapperOptions = new JPanel();
        wrapperOptions.setLayout(new BoxLayout(wrapperOptions, BoxLayout.Y_AXIS));
        wrapperOptions.setVisible(true);
        ButtonGroup typeField = new ButtonGroup();
        TTypeService typeService = new TTypeService();
        List<TType> types = typeService.list();
        JRadioButton tBox;

        for (TType t : types) {
            tBox = new JRadioButton(t.getName());
            System.out.println(threat.getTypeID() + " - " + t.getID());
            if (threat.getTypeID() == t.getID()) {
                tBox.setSelected(true);
            }
            tBox.setActionCommand("" + t.getID());
            //tBox.setBorder(new EmptyBorder(5, 10, 5, 10));
            typeField.add(tBox);
            wrapperOptions.add(tBox);
        }

        JScrollPane scrollPane = new JScrollPane(
            wrapperOptions,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setBounds(300, 10, 150, 100);
        dialog.add(scrollPane);

        //PRODUCTS
        JLabel labelProduct = new JLabel("Quais produtos essa ameaça afeta ?");
        labelProduct.setBounds(300, 130, 150, 15);
        wrapperOptions = new JPanel();
        wrapperOptions.setLayout(new BoxLayout(wrapperOptions, BoxLayout.Y_AXIS));
        List<JCheckBox> buttons = new ArrayList<>();
        ProductService productService = new ProductService();
        List<Product> products = productService.list();
        JCheckBox b;
        List<Product> listProducts = threatService.getProducts(threat.getID());

        for (Product p : products) {
            Version v = productService.getProductVersion(p);
            b = new JCheckBox(p.getName() + " - " + v.getName());
            for (Product p2 : listProducts) {
                if (p.getID() == p2.getID()) {
                    b.setSelected(true);
                }
            }
            b.setActionCommand("" + p.getID());
            b.setBorder(new EmptyBorder(5, 10, 5, 10));
            buttons.add(b);
            wrapperOptions.add(b);
        }

        scrollPane =
            new JScrollPane(
                wrapperOptions,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
            );
        scrollPane.setBounds(300, 130, 150, 150);
        dialog.add(scrollPane);
        dialog.setVisible(true);

        JButton update = new JButton("Atualizar");
        update.setBounds(20, 300, 200, 30);
        dialog.add(update);
        update.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    Threat t = new Threat();
                    String cveYear = cveFieldYear.getText(), cveCode = cveFieldCode.getText(), dateDay = dateFieldDay.getText(), dateMonth = dateFieldMonth.getText(), dateYear = dateFieldYear.getText();
                    int criticallyID = Integer.parseInt(
                        (criticallyField.getSelection().getActionCommand())
                    );

                    int typeID = Integer.parseInt((typeField.getSelection().getActionCommand()));

                    t.setID(threat.getID());
                    t.setCVE("CVE-" + cveYear + "-" + cveCode);
                    t.setDiscoveryDate(dateDay + "/" + dateMonth + "/" + dateYear);
                    t.setCriticallyLevelID(criticallyID);
                    t.setTypeID(typeID);

                    ThreatService threatService = new ThreatService();
                    threatService.update(t);
                    threatService.removeProducts(t);
                    MainGUI.updatePage(1);
                    for (JCheckBox checkbox : buttons) {
                        if (checkbox.isSelected()) {
                            int productID = Integer.parseInt((checkbox.getActionCommand()));
                            threatService.addProduct(t, productID);
                        }
                    }
                }
            }
        );
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
            criticallyLabel.setBounds(340, gap, 150, 40);

            deleteBtn = new JButton("Deletar");
            deleteBtn.setBounds(500, gap + 15, 150, 30);

            updateBtn = new JButton("Atualizar dados");
            updateBtn.setBounds(30, gap + 60, 150, 23);

            downloadBtn = new JButton("Download correção");
            downloadBtn.setBounds(200, gap + 60, 150, 23);

            deleteBtn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        MainGUI.updatePage(1);
                        threatService.delete(t.getID());
                        showSuccess("Sucesso!", "Ameaça deletada da base de dados com sucesso!");
                    }
                }
            );

            updateBtn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        updateThreat(t);
                    }
                }
            );

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
