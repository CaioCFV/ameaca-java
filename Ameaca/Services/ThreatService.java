package Ameaca.Services;

import Ameaca.Entities.*;
import Ameaca.Repositories.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ThreatService {

    String code, year, day, month, CVEyear;

    private ThreatRepository rep = new ThreatRepository();

    public Threat add(Threat t) {
        try {
            CVEyear = t.getCVE().split("-")[1];
            code = t.getCVE().split("-")[2];
            day = t.getDiscoveryDate().split("/")[0];
            month = t.getDiscoveryDate().split("/")[1];
            year = t.getDiscoveryDate().split("/")[2];

            if (Integer.parseInt(CVEyear) < 1950 || Integer.parseInt(CVEyear) > 2050) {
                throw new BussinesException("Ano do CVE inválido");
            } else if (code.length() < 5) {
                throw new BussinesException("Código do CVE precisa ter 5 digitos.");
            } else if (Integer.parseInt(day) > 30 || Integer.parseInt(day) < 1) {
                throw new BussinesException("Dia inválido");
            } else if (Integer.parseInt(month) > 12 || Integer.parseInt(month) < 1) {
                throw new BussinesException("Mês inválido");
            } else if (Integer.parseInt(year) < 1950 || Integer.parseInt(year) > 2050) {
                throw new BussinesException("Ano inválido");
            } else if (hasCVE(t.getCVE())) {
                throw new BussinesException("Este CVE já existe");
            } else {
                return rep.insert(t);
            }
        } catch (BussinesException err) {
            JOptionPane.showMessageDialog(
                null,
                err.getMessage(),
                "Erro",
                JOptionPane.WARNING_MESSAGE
            );
            return null;
        } catch (Exception err) {
            JOptionPane.showMessageDialog(
                null,
                "Erro não esperado! entre em contato com os desenvolvedores\n\n" + err.getMessage(),
                "Erro Crítico",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
    }

    public boolean hasCVE(String v) {
        return rep.hasCVE(v);
    }

    public void addProduct(Threat t, int productID) {
        rep.addProduct(t, productID);
    }

    public List<Threat> list() {
        return rep.list();
    }

    public List<Product> getProducts(int threatID) {
        return rep.getProducts(threatID);
    }

    public void delete(int ID) {
        rep.delete(ID);
    }

    public void update(Threat t) {
        rep.update(t);
    }

    public void removeProducts(Threat t) {
        rep.removeProducts(t);
    }

    public List<Threat> searchProducts(String name, String version) {
        return rep.searchProducts(name, version);
    }

    public List<Threat> searchProductsName(String version) {
        return rep.searchProductsName(version);
    }

    public List<Threat> searchProductsVersion(String name) {
        return rep.searchProductsVersion(name);
    }
}
