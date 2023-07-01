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
        return rep.insert(v);
    }
}
