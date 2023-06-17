package Ameaca.Repositories;

import Ameaca.Entities.Product;
import Ameaca.Entities.Threat;
import Ameaca.Services.DatabaseConnection;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ThreatRepository {

    private DatabaseConnection db = new DatabaseConnection();
    private Connection connection;

    public Threat insert(Threat t) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "insert into threat(cve, discovery_date, critically_level_id, type_id) values (?,?,?,?)"
            );
            statement.setString(1, t.getCVE());
            statement.setString(2, t.getDiscoveryDate());
            statement.setInt(3, t.getCriticallyLevelID());
            statement.setInt(4, t.getTypeID());
            statement.executeUpdate();
            statement =
                connection.prepareStatement(
                    "select id, cve, discovery_date, critically_level_id, type_id from threat where cve=?"
                );
            statement.setString(1, t.getCVE());
            ResultSet rs = statement.executeQuery();

            Threat t2 = new Threat();
            t2.setID(rs.getInt(1));
            t2.setCVE(rs.getString(2));
            t2.setDiscoveryDate(rs.getString(3));
            t2.setCriticallyLevelID(rs.getInt(4));
            t2.setTypeID(rs.getInt(5));
            db.closeConection();
            return t2;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    public void addProduct(Threat t, int pID) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select product_id, threat_id from threat_product where product_id=? and threat_id=?"
            );
            statement.setInt(1, t.getID());
            statement.setInt(1, pID);
            ResultSet rs = statement.executeQuery();

            if (!rs.next()) {
                statement =
                    connection.prepareStatement(
                        "insert into threat_product(threat_id, product_id) values (?,?)"
                    );
                statement.setInt(1, t.getID());
                statement.setInt(2, pID);
                statement.executeUpdate();
            }
            db.closeConection();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public Threat getByCVE(String cve) {
        Threat t;
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, cve, discovery_date, critically_level_id, type_id from threat where cve=?"
            );
            statement.setString(0, cve);
            ResultSet rs = statement.executeQuery();
            t = new Threat();
            t.setID(rs.getInt(1));
            t.setCVE(rs.getString(2));
            db.closeConection();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    public List<Threat> list() {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, cve, discovery_date, critically_level_id, type_id from threat"
            );
            ResultSet rs = statement.executeQuery();
            List<Threat> list = new LinkedList<Threat>();
            while (rs.next()) {
                Threat t = new Threat();
                t.setID(rs.getInt(1));
                t.setCVE(rs.getString(2));
                t.setDiscoveryDate(rs.getString(3));
                t.setCriticallyLevelID(rs.getInt(4));
                t.setTypeID(rs.getInt(5));
                list.add(t);
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
