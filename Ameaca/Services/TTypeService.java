package Ameaca.Services;

import Ameaca.Entities.TType;
import Ameaca.Repositories.TTypeRepository;
import java.util.List;

public class TTypeService {

    private TTypeRepository rep = new TTypeRepository();

    public List<TType> listar() {
        return rep.listar();
    }
}
