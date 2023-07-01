package Ameaca.Entities;

public class Threat {

    private String cve, discovery_date;
    private int critically_level_id, type_id;
    private int id;

    public String getCVE() {
        return cve;
    }

    public String getDiscoveryDate() {
        return discovery_date;
    }

    public int getTypeID() {
        return type_id;
    }

    public int getCriticallyLevelID() {
        return critically_level_id;
    }

    public int getID() {
        return id;
    }

    public void setID(int value) {
        id = value;
    }

    public void setCVE(String value) {
        cve = value;
    }

    public void setDiscoveryDate(String value) {
        discovery_date = value;
    }

    public void setTypeID(int value) {
        type_id = value;
    }

    public void setCriticallyLevelID(int value) {
        critically_level_id = value;
    }
}
