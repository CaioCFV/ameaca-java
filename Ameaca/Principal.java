package Ameaca;

import Ameaca.Entities.Threat;
import Ameaca.Services.ScanService;
import Ameaca.Services.ThreatService;

// Voce foi contratado pela Fature, para fazer um sistema de gerenciamento de ameaças
// neste sistem deve ser possivel realizar as seguintes operacoes.

// 1. inserir uma ameca
// 2. remover uma ameaca
// 3. alterar os dados de uma ameaca
// 4. listar todas as amaeacas
// 5. listar as ameacas dado o nome do produto e sua versao
// 6. baixar patch de uma ameaca

// os dados das ameacas são:
// numero do CVE (ex: CVE-2023-31145)
// Produto (nome do produto vulneravel)
// Versao  (versao do prooduto vulneravel)
// Tipo  (tipo de ameaca (Spam, Worm, Virus, Trrojan, DDOS,  Ramsoware, etc...)
// Criticidade (nivel de citicidade)
// Data  (data da descoberta)
// PathCorrecao (arquivo a ser executado para resolver) (arquivo zip)
// Solucao (texto grande contendo os passos para resolver)
// Consequencia (PDF com as possiveis consequencias se esta ameaca nao for mitigada)

// pre-requisitor para a analise de qualquer pontuacao:
// 1. programa estar compilando
// 2. programa ser entregue no prazo
// 3. no maxino 2 pessoas por grupo
// 4. feito em java
// 5. plataforma desktop (nao eh web)
// 6. no coropo do email ter o nome dos integrantes do grupo
// 7. o assunto do email ser:trab ist prj 2023 01

// pontuação:
// itens 1-4 feitos em tela console e sem BD					4.0 (obrigatorio)
// item 5	(listar as ameacas dado o nome do produto e sua versao)			0.5
// item 6	(baixar patch de uma ameaca)						0.5
// usar telas JOPtionaPane								1.0
// user telas customizadas								2.0
// gravar e ler dados do banco de dados (SQLite)					3.0
// importar/exportar ameacas para arquivo texto					1.5
// importar/exportar ameacas para arquivo binario					1.5
// colocar pdf e patch no banco de dados						2.0
// tela de splash									1.0
// tela de sobre									1.0
// icones customizados (para janelas e botoes)					1.0
// fazer instalador (em tela grafica, como passo a passo e icone)			2.5 (inosetup)
// normalizacao do banco de dados							1.5

// entrega: 02 de julho de 2023.
// por email: mozar.silva@gmail.com
// assunto do email: trab ist prj 2023 01
// no corpo de email deve ter o nome do integrantes do trabalho.

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
        String cve;
        ScanService s = new ScanService();
        do {
            cmd = menuPanel();
            switch (cmd) {
                case 1:
                    System.out.println("Digite o CVE da ameaça: ");
                    cve = s.nextString();
                    Threat t = new Threat();
                    t.setCVE(cve);
                    th_service.add(t);
                    // System.out.println("Digite o nome do produto: ");
                    // productName = s.nextString();
                    // t.setProductName(productName);
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
// Produto:
//    ID INT AUTOINCREMENT PRIMARY KEY not null,
//    Produto VARCHAR(50)
// Versao:
//    ID INT AUTOINCREMENT PRIMARY KEY not null,
//    IdProduto int foreing key Produto (id)
//    Versao VARCHAR(20)
// Tipo:
//    ID INT AUTOINCREMENT PRIMARY KEY not null,
//    Tipo VARCHAR(30)
// Criticidade:
//    ID INT AUTOINCREMENT PRIMARY KEY not null,
//    Criticiade VARCHAR(30)
// Ameaca:
//    ID INT AUTOINCREMENT PRIMARY KEY,
//    CVE VARCHAR(20),
//    IdProduto int foreing key Produto (id)
//    IdVersao  int foreing key Versao (id)
//    IdTipo int foreing key Tipo (id)
//    IdCriticidade int foreing key Criticidade (id)
//    Data  DATTIME,
//    PathCorrecao BLOB,
//    Solucao BLOB,
//    Consequencia BLOB
