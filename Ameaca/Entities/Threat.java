package Ameaca.Entities;

import Ameaca.Types.ThreatLevel;
import Ameaca.Types.ThreatType;

// numero do CVE (ex: CVE-2023-31145)
// Tipo da ameaca (tipo de ameaca (Spam, Worm, Virus, Trrojan, DDOS,  Ramsoware, etc...)
// Data  (data da descoberta)
// Criticidade (nivel de citicidade)
// PathCorrecao (arquivo a ser executado para resolver) (arquivo zip)
// Solucao (texto grande contendo os passos para resolver)
// Consequencia (PDF com as possiveis consequencias se esta ameaca nao for mitigada)

public class Threat {

    private String cve, discovery_date;
    private ThreatType type;
    private ThreatLevel critically_level;
    //private Blob consequence, solution;
    private int id;

    public String getCVE() {
        return cve;
    }

    public String getDiscoveryDate() {
        return discovery_date;
    }

    public ThreatType getType() {
        return type;
    }

    public ThreatLevel setCriticallyLevel() {
        return critically_level;
    }

    public int getID() {
        return id;
    }

    public void setCVE(String value) {
        cve = value;
    }

    public void setDiscoveryDate(String value) {
        discovery_date = value;
    }

    public void setThreatType(ThreatType value) {
        type = value;
    }

    public void setCriticallyLevel(ThreatLevel value) {
        critically_level = value;
    }
}
