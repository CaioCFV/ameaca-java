package Ameaca.Repositories;

import Ameaca.Entities.TType;
import Ameaca.Services.DatabaseConnection;
import java.sql.*;
import java.util.*;

public class TTypeRepository {

    private DatabaseConnection db = new DatabaseConnection();
    private Connection connection;

    public List<TType> list() {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement("select id, name from ttype");
            ResultSet rs = statement.executeQuery();
            List<TType> list = new LinkedList<TType>();
            while (rs.next()) {
                TType t = new TType();
                t.setID(rs.getInt(1));
                t.setName(rs.getString(2));
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

    public TType getType(int TypeID) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select id, name from ttype where id=?"
            );
            statement.setInt(1, TypeID);
            ResultSet rs = statement.executeQuery();
            TType t = new TType();
            t.setID(rs.getInt(1));
            t.setName(rs.getString(2));
            db.closeConection();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }
}
