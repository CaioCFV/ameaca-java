package Ameaca.Repositories;

import Ameaca.Entities.Product;
import Ameaca.Services.DatabaseConnection;
import java.sql.*;

public class ProductRepository {

    private DatabaseConnection db = new DatabaseConnection();
    private Connection connection;

    public void inserir(Product p) {
        try {
            connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "insert into threat(name,version_id) values (?,?)"
            );
            statement.setString(1, p.getName());
            statement.setString(2, p.getVersionID());
            statement.executeUpdate();
            db.closeConection();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    // public List<TType> listar() {
    //     try {
    //         connection = db.getConnection();
    //         PreparedStatement statement = connection.prepareStatement("select id, name from ttype");
    //         ResultSet rs = statement.executeQuery();
    //         List<TType> list = new LinkedList<TType>();
    //         while (rs.next()) {
    //             TType t = new TType();
    //             t.setID(rs.getInt(1));
    //             t.setName(rs.getString(2));
    //             list.add(t);
    //         }
    //         db.closeConection();
    //         return list;
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         System.exit(0);
    //         return null;
    //     }
    // }
}
