package Ameaca.Services;

import Ameaca.Entities.TType;
import Ameaca.Repositories.TTypeRepository;
import java.util.List;

public class TTypeService {

    private TTypeRepository rep = new TTypeRepository();

    public List<TType> listar() {
        return rep.listar();
    }
    // public Iterable<TType> listar(String parte) {
    //     List<TType> lista = new LinkedList<TType>();
    //     for (TType d : rep.listar()) {
    //         if (d.getTitulo().contains(parte) || d.getEstilo().contains(parte)) lista.add(d);
    //     }
    //     return lista;
    // }
}
