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

    public boolean insert(Product p) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "insert into product (name, version_id) values (?,?)"
            );
            statement.setString(1, p.getName());
            statement.setInt(2, p.getVersionID());
            statement.executeUpdate();
            db.closeConection();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return false;
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

    public List<Product> list() {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, name from product"
            );
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

    public boolean exists(String name, String version) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, name from product where name=?"
            );
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                db.closeConection();
                return false;
            }

            statement = connection.prepareStatement("select id, name from pversion where name=?");
            statement.setString(1, version);
            rs = statement.executeQuery();
            if (!rs.next()) {
                db.closeConection();
                return false;
            }
            statement = connection.prepareStatement("select id from product where version_id=?");
            statement.setString(1, rs.getString(1));
            rs = statement.executeQuery();
            if (!rs.next()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return false;
        }
    }

    public Version getProductVersion(Product p) {
        Version v;
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select version_id from product where id=?"
            );
            statement.setInt(1, p.getID());
            ResultSet rs = statement.executeQuery();

            statement = connection.prepareStatement("select id, name from pversion where id=?");
            statement.setInt(1, rs.getInt(1));
            rs = statement.executeQuery();
            v = new Version();

            v.setID(rs.getInt(1));
            v.setName(rs.getString(2));
            db.closeConection();
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }
}
