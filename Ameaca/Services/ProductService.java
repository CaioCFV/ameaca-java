package Ameaca.Services;

import Ameaca.Entities.*;
import Ameaca.Repositories.*;
import Ameaca.Views.AboutGUI;
import Ameaca.Views.ListGUI;
import Ameaca.Views.ProductGUI;
import Ameaca.Views.ThreatGUI;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductService {

    private ProductRepository rep = new ProductRepository();

    public Version getProductVersion(Product p) {
        return rep.getProductVersion(p);
    }

    public List<Product> list() {
        return rep.list();
    }

    public boolean exists(String name, String version) {
        return rep.exists(name, version);
    }

    public boolean add(Product p, String v) {
        try {
            if (exists(p.getName(), v)) {
                throw new BussinesException("Já existe um produto com essa versão.");
            } else {
                return rep.insert(p);
            }
        } catch (BussinesException err) {
            JOptionPane.showMessageDialog(
                null,
                err.getMessage(),
                "Erro",
                JOptionPane.WARNING_MESSAGE
            );
            return false;
        } catch (Exception err) {
            JOptionPane.showMessageDialog(
                null,
                "Erro não esperado! entre em contato com os desenvolvedores\n\n" + err.getMessage(),
                "Erro Crítico",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
}
