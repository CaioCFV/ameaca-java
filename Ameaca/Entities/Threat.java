package Ameaca.Entities;

// numero do CVE (ex: CVE-2023-31145)
// Tipo da ameaca (tipo de ameaca (Spam, Worm, Virus, Trrojan, DDOS,  Ramsoware, etc...)
// Data  (data da descoberta)
// Criticidade (nivel de citicidade)
// PathCorrecao (arquivo a ser executado para resolver) (arquivo zip)
// Solucao (texto grande contendo os passos para resolver)
// Consequencia (PDF com as possiveis consequencias se esta ameaca nao for mitigada)

public class Threat {

    private String cve, discovery_date;
    private TType type;
    private int critically_level_id;
    //private Blob consequence, solution;
    private int id;

    public String getCVE() {
        return cve;
    }

    public String getDiscoveryDate() {
        return discovery_date;
    }

    public TType getType() {
        return type;
    }

    public int getCriticallyLevelID() {
        return critically_level_id;
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

    public void setThreatType(TType value) {
        type = value;
    }

    public void setCriticallyLevelID(int value) {
        critically_level_id = value;
    }
}
