package Ameaca.Services;

import Ameaca.Entities.Version;
import Ameaca.Repositories.VersionRepository;
import java.util.*;

public class VersionService {

    private VersionRepository rep = new VersionRepository();

    public List<Version> getVersion(String parte) {
        return rep.list(parte);
    }

    public boolean exists(String name) {
        return rep.exists(name);
    }

    public Version add(Version v) {
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

        return rep.insert(v);
    }
}
