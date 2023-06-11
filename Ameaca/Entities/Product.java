package Ameaca.Entities;

public class Product {

    private String name, version_id;
    private int id;

    public String getName() {
        return name;
    }

    public String getVersionID() {
        return version_id;
    }

    public int getID() {
        return id;
    }

    public void setName(String value) {
        name = value;
    }

    public void setVersionID(String value) {
        version_id = value;
    }
}
