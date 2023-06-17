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

    public void insert(Threat t) {
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
    // public void remover(int codigo)
    // {
    //     try{
    //         conectar();
    // 	    PreparedStatement statement = _con.prepareStatement("delete from dvd where codigo=?");
    //         statement.setInt(1, codigo);
    //     statement.executeUpdate();
    //         desconectar();
    //     }catch(Exception e){
    // 	e.printStackTrace();
    // 	System.exit(0);
    // }
    // }
    // public void alterar(int cod, DVD d)
    // {
    //     try{
    //         conectar();
    // 	    PreparedStatement statement = _con.prepareStatement("update dvd set codigo=?,titulo=?,ano=?,duracao=?,estilo=? where codigo=?");
    //         statement.setInt(1, d.getCodigo());
    //         statement.setString(2, d.getTitulo());
    //         statement.setInt(3, d.getAno());
    //         statement.setInt(4, d.getDuracao());
    //         statement.setString(5, d.getEstilo());
    //         statement.setInt(6, cod);
    //     statement.executeUpdate();
    //         desconectar();
    //     }catch(Exception e){
    // 	e.printStackTrace();
    // 	System.exit(0);
    // }
    // }
    // public DVD get(int cod)
    // {
    //     try{
    //         conectar();
    // 	    PreparedStatement statement = _con.prepareStatement("select codigo, titulo, ano, duracao, estilo from dvd where codigo=?");
    //         statement.setInt(1, cod);
    //     ResultSet rs = statement.executeQuery();
    //         DVD d = null;
    //         if (rs.next())
    //         {
    //             d = new DVD();
    //             d.setCodigo(rs.getInt(1));
    //             d.setTitulo(rs.getString(2));
    //             d.setAno(rs.getInt(3));
    //             d.setDuracao(rs.getInt(4));
    //             d.setEstilo(rs.getString(5));
    //         }
    //         desconectar();
    //         return d;
    //     }catch(Exception e){
    // 	e.printStackTrace();
    // 	System.exit(0);
    // 	return null;
    // }
    // }
    // public Iterable<DVD> listar()
    // {
    //     try{
    //         conectar();
    // 	    PreparedStatement statement = _con.prepareStatement("select codigo, titulo, ano, duracao, estilo from dvd order by codigo");
    //     ResultSet rs = statement.executeQuery();
    //         List<DVD> list = new LinkedList<DVD>();
    //         while (rs.next())
    //         {
    //             DVD d = new DVD();
    //             d.setCodigo(rs.getInt(1));
    //             d.setTitulo(rs.getString(2));
    //             d.setAno(rs.getInt(3));
    //             d.setDuracao(rs.getInt(4));
    //             d.setEstilo(rs.getString(5));
    //             list.add(d);
    //         }
    //         desconectar();
    //         return list;
    //     }catch(Exception e){
    // 	e.printStackTrace();
    // 	System.exit(0);
    //             return null;
    // }
    // }
}
