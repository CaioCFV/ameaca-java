package Ameaca.Services;

import Ameaca.Entities.*;
import Ameaca.Repositories.*;
import java.util.List;

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

    public void add(Product p) {
        rep.insert(p);
    }

    public void addVersion(Product p, Version v) {
        rep.addVersion(p, v);
    }
}
