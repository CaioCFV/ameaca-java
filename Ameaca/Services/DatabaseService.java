package Ameaca.Services;

import Ameaca.Entities.*;
import java.io.*;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DatabaseService {

    public void exportData() {
        JFrame frame = new JFrame();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(frame);
        if (chooser.getSelectedFile() != null) {
            String path = chooser.getSelectedFile().getAbsolutePath() + "/registros.th";
            try {
                FileOutputStream fs = new FileOutputStream(path);
                DataOutputStream ds = new DataOutputStream(fs);
                ThreatService th = new ThreatService();
                List<Threat> colecao = th.list();
                for (Threat t : colecao) {
                    ds.writeInt(t.getID());
                    ds.writeInt(t.getTypeID());
                    ds.writeInt(t.getCriticallyLevelID());
                    ds.writeUTF(t.getCVE());
                    ds.writeUTF(t.getDiscoveryDate());
                }
                ds.close();
                fs.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

    public void importData() {
        JFrame frame = new JFrame();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Threats", "th"));
        chooser.showOpenDialog(frame);
        if (chooser.getSelectedFile() != null) {
            String path = chooser.getSelectedFile().getAbsolutePath();
            try {
                FileInputStream fs = new FileInputStream(path);
                DataInputStream ds = new DataInputStream(fs);
                while (ds.available() > 0) {
                    System.out.println("ID: " + ds.readInt());
                    System.out.println("getTypeID: " + ds.readInt());
                    System.out.println("getCriticallyLevelID: " + ds.readInt());
                    System.out.println("getCVE: " + ds.readUTF());
                    System.out.println("getDiscoveryDate: " + ds.readUTF());
                }
                ds.close();
                fs.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
