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

    public void update(Threat t) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "UPDATE threat SET cve=?, discovery_date=?, critically_level_id=?, type_id=? where id=?"
            );
            statement.setString(1, t.getCVE());
            statement.setString(2, t.getDiscoveryDate());
            statement.setInt(3, t.getCriticallyLevelID());
            statement.setInt(4, t.getTypeID());
            statement.setInt(5, t.getID());
            statement.executeUpdate();

            db.closeConection();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
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

    public List<Product> getProducts(int threatID) {
        ResultSet rs, rs2;
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select product_id from threat_product where threat_id=?"
            );
            statement.setInt(1, threatID);
            rs = statement.executeQuery();
            List<Product> list = new LinkedList<Product>();
            while (rs.next()) {
                statement =
                    connection.prepareStatement(
                        "select id, version_id, name from product where id=?"
                    );
                statement.setInt(1, rs.getInt(1));
                rs2 = statement.executeQuery();
                while (rs2.next()) {
                    Product p = new Product();
                    p.setID(rs2.getInt(1));
                    p.setVersionID(rs2.getInt(2));
                    p.setName(rs2.getString(3));
                    list.add(p);
                }
            }
            db.closeConection();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    public boolean hasCVE(String s) {
        ResultSet rs;
        boolean result = false;
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select * from threat where cve=?"
            );
            statement.setString(1, s);
            rs = statement.executeQuery();
            if (rs.next()) {
                result = true;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return false;
        }
    }

    public void removeProducts(Threat t) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "delete from threat_product where threat_id=?"
            );
            statement.setInt(1, t.getID());
            statement.executeUpdate();
            db.closeConection();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void delete(int ID) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id from threat_product where threat_id=?"
            );
            statement.setInt(1, ID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                statement = connection.prepareStatement("delete from threat_product where id=?");
                statement.setInt(1, rs.getInt(1));
                statement.executeUpdate();
            }
            statement = connection.prepareStatement("delete from threat where id=?");
            statement.setInt(1, ID);
            statement.executeUpdate();
            db.closeConection();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public List<Threat> searchProducts(String name, String version) {
        ResultSet rs, rs2, rs3, rs4;
        List<Threat> list = new LinkedList<Threat>();
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, name from pversion where name LIKE ?"
            );
            statement.setString(1, "%" + version + "%");
            rs = statement.executeQuery();
            while (rs.next()) {
                statement =
                    connection.prepareStatement(
                        "select id, version_id, name from product where name LIKE ? AND version_id=?"
                    );
                statement.setString(1, "%" + name + "%");
                statement.setString(2, rs.getString(1));
                rs2 = statement.executeQuery();
                while (rs2.next()) {
                    statement =
                        connection.prepareStatement(
                            "select threat_id, product_id from threat_product where product_id=?"
                        );
                    statement.setString(1, rs2.getString(1));
                    rs3 = statement.executeQuery();
                    while (rs3.next()) {
                        statement =
                            connection.prepareStatement(
                                "select id, cve, discovery_date, critically_level_id, type_id from threat where id=?"
                            );
                        statement.setString(1, rs3.getString(1));
                        rs4 = statement.executeQuery();
                        while (rs4.next()) {
                            Threat t2 = new Threat();
                            t2.setID(rs4.getInt(1));
                            t2.setCVE(rs4.getString(2));
                            t2.setDiscoveryDate(rs4.getString(3));
                            t2.setCriticallyLevelID(rs4.getInt(4));
                            t2.setTypeID(rs4.getInt(5));
                            list.add(t2);
                        }
                    }
                }
            }
            db.closeConection();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    public List<Threat> searchProductsVersion(String version) {
        ResultSet rs, rs2, rs3, rs4;
        List<Threat> list = new LinkedList<Threat>();
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, name from pversion where name LIKE ?"
            );
            statement.setString(1, "%" + version + "%");
            rs = statement.executeQuery();
            while (rs.next()) {
                statement =
                    connection.prepareStatement(
                        "select id, version_id, name from product where version_id=?"
                    );
                statement.setString(1, rs.getString(1));
                rs2 = statement.executeQuery();
                while (rs2.next()) {
                    statement =
                        connection.prepareStatement(
                            "select threat_id, product_id from threat_product where product_id=?"
                        );
                    statement.setString(1, rs2.getString(1));
                    rs3 = statement.executeQuery();
                    while (rs3.next()) {
                        statement =
                            connection.prepareStatement(
                                "select id, cve, discovery_date, critically_level_id, type_id from threat where id=?"
                            );
                        statement.setString(1, rs3.getString(1));
                        rs4 = statement.executeQuery();
                        while (rs4.next()) {
                            Threat t2 = new Threat();
                            t2.setID(rs4.getInt(1));
                            t2.setCVE(rs4.getString(2));
                            t2.setDiscoveryDate(rs4.getString(3));
                            t2.setCriticallyLevelID(rs4.getInt(4));
                            t2.setTypeID(rs4.getInt(5));
                            list.add(t2);
                        }
                    }
                }
            }
            db.closeConection();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    public List<Threat> searchProductsName(String name) {
        ResultSet rs, rs2, rs3;
        List<Threat> list = new LinkedList<Threat>();
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, name, version_id from product where name LIKE ?"
            );
            statement.setString(1, "%" + name + "%");
            rs = statement.executeQuery();
            while (rs.next()) {
                statement =
                    connection.prepareStatement(
                        "select threat_id, product_id from threat_product where product_id=?"
                    );
                statement.setString(1, rs.getString(1));
                rs2 = statement.executeQuery();
                while (rs2.next()) {
                    statement =
                        connection.prepareStatement(
                            "select id, cve, discovery_date, critically_level_id, type_id from threat where id=?"
                        );
                    statement.setString(1, rs2.getString(1));
                    rs3 = statement.executeQuery();
                    while (rs3.next()) {
                        Threat t2 = new Threat();
                        t2.setID(rs3.getInt(1));
                        t2.setCVE(rs3.getString(2));
                        t2.setDiscoveryDate(rs3.getString(3));
                        t2.setCriticallyLevelID(rs3.getInt(4));
                        t2.setTypeID(rs3.getInt(5));
                        list.add(t2);
                    }
                }
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
