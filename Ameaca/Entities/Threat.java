package Ameaca.Entities;

public class Threat {

    private String cve, product_name;
    //version, discovery_date, path, solution, consequence;
    private int id;

    // private ThreatType type;
    // private ThreatLevel criticality;

    public void setCVE(String s) {
        cve = s;
    }

    public void setProductName(String s) {
        product_name = s;
    }

    public String getCVE() {
        return cve;
    }

    public String getProductName() {
        return product_name;
    }

    public int getID() {
        return id;
    }
}
