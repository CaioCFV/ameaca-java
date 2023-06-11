package Ameaca;

import Ameaca.Entities.Threat;
import Ameaca.Services.ScanService;
import Ameaca.Services.ThreatService;

// import Ameaca.Entities.*;

// import java.sql.*;
// import java.util.*;
// import java.io.*;

// private static final String _NOME_BANCO_ = "dados.db";
// private Connection _con;
// public DVDRepository()
// {
//    try {
//        Class.forName("org.sqlite.JDBC");
//        File f = new File(_NOME_BANCO_);
//        if (!f.exists())
//           criarBanco();
//   }catch(Exception e)
//   {
//      e.printStackTrace();
//      System.exit(0);
//   }
// }

// private void criarBanco()
// {
//   try{
//        conectar();
//      Statement statement = _con.createStatement();
//        statement.executeUpdate("create table dvd (codigo int not null, titulo VARCHAR(50), ano int, duracao int, estilo varchar(20), CONSTRAINT codigo_unico PRIMARY KEY (codigo))");
//        desconectar();
//   }catch(Exception e)
//   {
//      e.printStackTrace();
//      System.exit(0);
//   }
// }

// private Connection conectar()
// {
//    try{
//       if (_con==null)
//          _con = DriverManager.getConnection("jdbc:sqlite:"+_NOME_BANCO_);
//       return _con;
//   }catch(Exception e)
//   {
//      e.printStackTrace();
//      System.exit(0);
//      return null;
//   }
// }

// private void desconectar()
// {
//    try{
//       _con.close();
//       _con = null;
//   }catch(Exception e)
//   {
//      e.printStackTrace();
//      System.exit(0);
//   }
// }

// public void inserir(DVD d)
// {
//     try{
//         conectar();
//         PreparedStatement statement = _con.prepareStatement("insert into dvd(codigo,titulo,ano,duracao,estilo) values (?,?,?,?,?)");
//         statement.setInt(1, d.getCodigo());
//         statement.setString(2, d.getTitulo());
//         statement.setInt(3, d.getAno());
//         statement.setInt(4, d.getDuracao());
//         statement.setString(5, d.getEstilo());
//     statement.executeUpdate();
//         desconectar();
//     }catch(Exception e){
//     e.printStackTrace();
//     System.exit(0);
// }
// }

// import Ameacas.Tela.*;

public class Principal {

    public static int menuPanel() {
        ScanService s = new ScanService();
        int cmd;

        System.out.println("1 - Inserir uma ameaça.");
        System.out.println("2 - Remover uma ameaça.");
        System.out.println("3 - Alterar dados de uma ameaça.");
        System.out.println("4 - Listar todas as ameaças.");
        System.out.println("5 - Listar as ameaças dado o nome do produto e sua versão");
        System.out.println("6 - baixar patch de uma ameaça.");
        System.out.println("7 - Sair");

        cmd = s.nextInt();
        return cmd;
    }

    public static void main(String args[]) {
        // ScanService s = new ScanService();
        // String cve, product_name, version, discovery_date, path, solution, consequence;
        // ThreatType type;
        // ThreatLevel criticality;
        // ThreatList th_list = new ThreatList();
        int cmd;
        ThreatService th_service = new ThreatService();
        String cve, productName;
        ScanService s = new ScanService();
        do {
            cmd = menuPanel();
            switch (cmd) {
                case 1:
                    System.out.println("Digite o CVE da ameaça: ");
                    cve = s.nextString();
                    System.out.println("Digite o nome do produto: ");
                    productName = s.nextString();
                    Threat t = new Threat();
                    t.setCVE(cve);
                    t.setProductName(productName);
                    th_service.add(t);
                    break;
                case 2:
                    // cve = s.nextString();
                    // th_list.removeThreat(cve);

                    break;
                case 3:
                    // System.out.println("Digite o ID: ");
                    // id = s.nextInt();
                    // System.out.println("Digite o CVE da ameaça: ");
                    // cve = s.nextString();
                    // System.out.println("Digite o nome do produto: ");
                    // product_name = s.nextString();

                    // th_list.updateThreat(id, cve, product_name);
                    break;
                case 4:
                    // th_list.listThreat();
                    break;
                case 5:
                    //System.out.println("Você selecionou inserir.");
                    break;
                case 6:
                    //System.out.println("Listar as ameaças dado o nome do produto e sua versão.");
                    break;
                case 7:
                    //System.out.println("OBRIGADO POR ULTILIZAR ESSE LIXO DE PROGRAMA");
                    break;
                default:
                    //System.out.println("Digita uma opção valida o burro");
                    break;
            }
        } while (cmd != 7);
    }
}
