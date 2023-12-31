package Ameaca.Views;

import javax.swing.*;

public abstract class GUI extends JPanel {

    public abstract JPanel getPanel();

    public abstract JButton getMenuButton();

    public void showSuccess(String title, String msg) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String title, String msg) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    public void showAlert(String title, String msg) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.WARNING_MESSAGE);
    }
}
