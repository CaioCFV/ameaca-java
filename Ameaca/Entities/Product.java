package Ameaca.Entities;

public class Product {

    private String name;
    private int id, version_id;

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public int getVersionID() {
        return version_id;
    }

    public void setVersionID(int value) {
        version_id = value;
    }

    public void setName(String value) {
        name = value;
    }

    public void setID(int value) {
        id = value;
    }
}
