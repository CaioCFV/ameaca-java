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
}
