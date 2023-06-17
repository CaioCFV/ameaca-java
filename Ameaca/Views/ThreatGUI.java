package Ameaca.Views;

import Ameaca.Entities.*;
import Ameaca.Services.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
        pTitle.setBounds(30, 20, 170, 15);

        JLabel labelCVE = new JLabel("CVE -");
        labelCVE.setBounds(30, 80, 50, 15);

        JTextFieldNumbers cveFieldYear = new JTextFieldNumbers(4);
        cveFieldYear.setBounds(70, 75, 45, 30);
        cveFieldYear.setHorizontalAlignment(JTextField.CENTER);

        JLabel cveSeparator = new JLabel(" - ");
        cveSeparator.setBounds(117, 80, 50, 15);

        JTextFieldNumbers cveFieldCode = new JTextFieldNumbers(5);
        cveFieldCode.setBounds(130, 75, 50, 30);
        cveFieldCode.setHorizontalAlignment(JTextField.CENTER);

        panel.add(pTitle);
        panel.add(labelCVE);
        panel.add(cveFieldCode);
        panel.add(cveSeparator);
        panel.add(cveFieldYear);

        // DATE
        JLabel labelDate = new JLabel("Data da descoberta");
        labelDate.setBounds(30, 140, 130, 15);

        JTextFieldNumbers dateFieldDay = new JTextFieldNumbers(2);
        dateFieldDay.setBounds(150, 133, 30, 30);
        dateFieldDay.setHorizontalAlignment(JTextField.CENTER);

        JLabel dateSeparator1 = new JLabel(" / ");
        dateSeparator1.setBounds(185, 140, 10, 15);

        JTextFieldNumbers dateFieldMonth = new JTextFieldNumbers(2);
        dateFieldMonth.setBounds(200, 133, 30, 30);
        dateFieldMonth.setHorizontalAlignment(JTextField.CENTER);

        JLabel dateSeparator2 = new JLabel(" / ");
        dateSeparator2.setBounds(233, 140, 10, 15);

        JTextFieldNumbers dateFieldYear = new JTextFieldNumbers(4);
        dateFieldYear.setBounds(245, 133, 50, 30);
        dateFieldYear.setHorizontalAlignment(JTextField.CENTER);
        panel.add(labelDate);
        panel.add(dateFieldDay);
        panel.add(dateSeparator1);
        panel.add(dateFieldMonth);
        panel.add(dateSeparator2);
        panel.add(dateFieldYear);

        //CRITICALLY
        JLabel labelCritic = new JLabel("Nível de criticidade");
        labelCritic.setBounds(30, 185, 150, 15);
        panel.add(labelCritic);

        ButtonGroup criticallyField = new ButtonGroup();
        JRadioButton r;
        String[] critically = { "BAIXA", "MÉDIA", "ALTA" };
        int gap = 0;
        for (int i = 0; i < critically.length; i++) {
            gap = i * 30;
            r = new JRadioButton(critically[i]);
            if (i == 0) {
                r.setSelected(true);
            }
            r.setActionCommand("" + (i + 1));
            r.setBounds(30, 205 + gap, 100, 30);
            criticallyField.add(r);
            panel.add(r);
        }

        //TYPES
        JPanel wrapperOptions = new JPanel();
        wrapperOptions.setLayout(new BoxLayout(wrapperOptions, BoxLayout.Y_AXIS));

        JLabel labeType = new JLabel("Selecione o tipo da ameaça");
        labeType.setBounds(350, 20, 200, 15);
        panel.add(labeType);
        ButtonGroup typeField = new ButtonGroup();
        TTypeService typeService = new TTypeService();
        List<TType> types = typeService.list();
        JRadioButton tBox;
        gap = 0;

        for (TType t : types) {
            tBox = new JRadioButton(t.getName());
            if (gap == 0) {
                tBox.setSelected(true);
            }
            tBox.setActionCommand("" + t.getID());
            tBox.setBounds(350, 45 + gap, 100, 30);
            tBox.setBorder(new EmptyBorder(5, 10, 5, 10));
            typeField.add(tBox);
            wrapperOptions.add(tBox);
            gap += 30;
        }
        JScrollPane scrollPane = new JScrollPane(
            wrapperOptions,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setBounds(350, 40, 250, 70);
        panel.add(scrollPane);

        //PRODUCTS
        JLabel labelProduct = new JLabel("Quais produtos essa ameaça afeta ?");
        labelProduct.setBounds(350, 130, 250, 15);
        wrapperOptions = new JPanel();
        wrapperOptions.setLayout(new BoxLayout(wrapperOptions, BoxLayout.Y_AXIS));
        List<JCheckBox> buttons = new ArrayList<>();
        ProductService productService = new ProductService();
        List<Product> products = productService.list();
        JCheckBox b;
        for (Product p : products) {
            Version v = productService.getProductVersion(p);
            b = new JCheckBox(p.getName() + " - " + v.getName());
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
        scrollPane.setBounds(350, 150, 250, 150);
        panel.add(labelProduct);
        panel.add(scrollPane);

        JButton submit = new JButton("Cadastrar");
        submit.setBounds(230, 320, 200, 40);
        panel.add(submit);

        submit.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    Threat t = new Threat();
                    String cveYear = cveFieldYear.getText(), cveCode = cveFieldCode.getText(), dateDay = dateFieldDay.getText(), dateMonth = dateFieldMonth.getText(), dateYear = dateFieldYear.getText();
                    int criticallyID = Integer.parseInt(
                        (criticallyField.getSelection().getActionCommand())
                    );

                    int typeID = Integer.parseInt((typeField.getSelection().getActionCommand()));

                    t.setCVE("CVE-" + cveYear + "-" + cveCode);
                    t.setDiscoveryDate(dateDay + "/" + dateMonth + "/" + dateYear);
                    t.setCriticallyLevelID(criticallyID);
                    System.out.println("CVE: " + t.getCVE());
                    System.out.println("DISCOVERY DATE: " + t.getDiscoveryDate());
                    System.out.println("CRITICIDADE: " + t.getCriticallyLevelID());
                    System.out.println("TIPO DE AMEAÇA: " + typeID);

                    ThreatService threatService = new ThreatService();
                    t = threatService.add(t);

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
}
