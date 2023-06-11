package Ameaca.Repositories;

import Ameaca.Entities.*;
import Ameaca.Services.DatabaseConnection;
import java.sql.*;
import java.util.*;

public class VersionRepository {

    private DatabaseConnection db = new DatabaseConnection();
    private Connection connection;

    public void insert(Version v) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "insert into threat(name) values (?)"
            );
            statement.setString(1, v.getName());
            statement.executeUpdate();
            db.closeConection();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public List<Version> list(String name) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, name from version where name=?"
            );
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            List<Version> list = new LinkedList<Version>();
            while (rs.next()) {
                Version v = new Version();
                v.setID(rs.getInt(1));
                v.setName(rs.getString(2));
                list.add(v);
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
