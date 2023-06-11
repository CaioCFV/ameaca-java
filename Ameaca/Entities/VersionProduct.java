package Ameaca.Entities;

public class VersionProduct {

    private int id, version_id, product_id;

    public int getID() {
        return id;
    }

    public int getProductID() {
        return product_id;
    }

    public int getVersionID() {
        return version_id;
    }

    public void setVersionID(int value) {
        version_id = value;
    }

    public void setProductID(int value) {
        product_id = value;
    }
}
