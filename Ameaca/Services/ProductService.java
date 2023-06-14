package Ameaca.Services;

import Ameaca.Entities.Product;
import Ameaca.Entities.Version;
import Ameaca.Repositories.ProductRepository;
import java.util.List;

public class ProductService {

    private ProductRepository rep = new ProductRepository();

    public List<Version> getVersionsByProduct(Product p) {
        return rep.getVersionsByProduct(p);
    }

    public List<Product> getVersions(String version, Product p) {
        return rep.getVersions(version, p);
    }

    public List<Product> findByName(String parte) {
        return rep.list(parte);
    }

    public List<Product> list() {
        return rep.list();
    }

    public void insert(Product p) {
        // if (d.getTitulo().length() < 2) throw new BussinesException(
        //     "Titulo deve ter mais de 1 caracter"
        // );
        // if (d.getEstilo().length() < 5) throw new BussinesException(
        //     "O Estilo deve ter mais de 5 caractere"
        // );
        // if (d.getDuracao() < 1 || d.getDuracao() > 1000) throw new BussinesException(
        //     "DVD com duração invalida"
        // );
        // if (d.getAno() < 1900 || d.getAno() > 2050) throw new BussinesException(
        //     "DVD com ano invalido"
        // );
        // if (d.getCodigo() < 1) throw new BussinesException("DVD com codigo invalido");
        // t.getCVE();
        // var dvd = rep.get(d.getCodigo());
        // if (dvd != null) throw new BussinesException("DVD com codigo ja existente");

        rep.insert(p);
    }

    public void addVersion(Product p, Version v) {
        rep.addVersion(p, v);
    }
}
