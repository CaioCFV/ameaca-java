package Ameaca.Services;

import Ameaca.Entities.TType;
import Ameaca.Repositories.TTypeRepository;
import java.util.List;

public class TTypeService {

    private TTypeRepository rep = new TTypeRepository();

    public List<TType> list() {
        return rep.list();
    }

    public TType getType(int typeID) {
        return rep.getType(typeID);
    }
}
