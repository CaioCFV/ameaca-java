package Ameaca.Services;

import Ameaca.Entities.*;
import Ameaca.Repositories.*;
import java.util.List;

public class ThreatService {

    private ThreatRepository rep = new ThreatRepository();

    public Threat add(Threat t) {
        return rep.insert(t);
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
