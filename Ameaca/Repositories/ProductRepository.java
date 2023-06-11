package Ameaca.Repositories;

import Ameaca.Entities.Product;
import Ameaca.Entities.Version;
import Ameaca.Services.DatabaseConnection;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductRepository {

    private DatabaseConnection db = new DatabaseConnection();
    private Connection connection;

    public void insert(Product p) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "insert into product (name) values (?)"
            );
            statement.setString(1, p.getName());
            statement.executeUpdate();
            db.closeConection();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void addVersion(Product p, Version v) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "insert into version_product (version_id, product_id) values (?,?)"
            );
            statement.setInt(1, v.getID());
            statement.setInt(2, p.getID());
            statement.executeUpdate();
            db.closeConection();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public List<Product> list(String name) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, name from product where name=?"
            );
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            List<Product> list = new LinkedList<Product>();
            while (rs.next()) {
                Product p = new Product();
                p.setID(rs.getInt(1));
                p.setName(rs.getString(2));
                list.add(p);
            }
            db.closeConection();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    public List<Product> getVersions(String version, Product p) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, version_id, product_id from version_product where version_id=? AND product_id=?"
            );
            statement.setString(1, version);
            statement.setInt(2, p.getID());
            ResultSet rs = statement.executeQuery();
            List<Product> list = new LinkedList<Product>();
            while (rs.next()) {
                p = new Product();
                p.setID(rs.getInt(1));
                p.setName(rs.getString(2));
                list.add(p);
            }
            db.closeConection();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }
}
