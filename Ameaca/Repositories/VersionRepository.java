package Ameaca.Repositories;

import Ameaca.Entities.*;
import Ameaca.Services.DatabaseConnection;
import java.sql.*;
import java.util.*;

public class VersionRepository {

    private DatabaseConnection db = new DatabaseConnection();
    private Connection connection;

    public Version insert(Version v) {
        Version result;
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "insert into pversion (name) values (?)"
            );
            statement.setString(1, v.getName());
            statement.executeUpdate();

            statement = connection.prepareStatement("select id, name from pversion where name=?");
            statement.setString(1, v.getName());
            ResultSet rs = statement.executeQuery();
            result = new Version();
            result.setID(rs.getInt(1));
            result.setName(rs.getString(2));
            db.closeConection();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return v;
        }
    }

    public List<Version> list(String name) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, name from pversion where name=?"
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

    public boolean exists(String name) {
        boolean exists = true;
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, name from pversion where name=?"
            );

            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();

            if (!rs.next()) {
                exists = false;
            }

            db.closeConection();
            return exists;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return false;
        }
    }
}
