package Ameaca.Views;

import Ameaca.Entities.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

// class BussinesException extends Error {

//     public BussinesException(String msg) {
//         super(msg);
//     }
// }

// class FrmDVD extends JDialog implements ActionListener {

//     private JButton btnOk;
//     private JButton btnCancel;

//     private JTextField tbxTitulo;
//     private JTextField tbxAno;
//     private JTextField tbxCodigo;
//     private JTextField tbxDuracao;
//     private JTextField tbxEstilo;

//     private boolean confirmou = false;

//     private JTextField criarTextField(JPanel pnlPai, String rotulo, int largura) {
//         Panel pnl = new Panel(new FlowLayout(FlowLayout.LEFT));
//         pnl.setPreferredSize(new Dimension(450, 30));
//         JLabel lbl = new JLabel(rotulo);
//         lbl.setPreferredSize(new Dimension(100, 30));
//         JTextField tbx = new JTextField(largura);
//         pnl.add(lbl);
//         pnl.add(tbx);
//         pnlPai.add(pnl);
//         return tbx;
//     }

//     public FrmDVD() {
//         setTitle("Editar Dados do DVD");
//         setSize(new Dimension(500, 270));
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//         setModal(true);
//         JPanel pnlBotoes, pnlDados;

//         pnlBotoes = new JPanel();
//         ((FlowLayout) pnlBotoes.getLayout()).setHgap(70);
//         pnlDados = new JPanel();

//         add(pnlBotoes, BorderLayout.SOUTH);
//         add(pnlDados, BorderLayout.CENTER);

//         btnOk = new JButton("Ok");
//         btnOk.setPreferredSize(new Dimension(100, 25));
//         btnOk.addActionListener(this);
//         pnlBotoes.add(btnOk);

//         btnCancel = new JButton("Cancelar");
//         btnCancel.setPreferredSize(new Dimension(100, 25));
//         btnCancel.addActionListener(this);
//         pnlBotoes.add(btnCancel);

//         tbxCodigo = criarTextField(pnlDados, "Codigo", 10);
//         tbxTitulo = criarTextField(pnlDados, "Titulo", 30);
//         tbxAno = criarTextField(pnlDados, "Ano", 10);
//         tbxDuracao = criarTextField(pnlDados, "Duracao", 10);
//         tbxEstilo = criarTextField(pnlDados, "Estilo", 20);
//     }

//     public void actionPerformed(ActionEvent e) {
//         // if (e.getSource() == btnOk) confirmou = true;
//         // hide();
//     }

//     private void atualizarTela() {
//         tbxCodigo.setText("");
//         tbxTitulo.setText("");
//         tbxAno.setText("");
//         tbxDuracao.setText("");
//         tbxEstilo.setText("");
//     }

//     private void atualizarObjeto() {
//         // d.setCodigo(Integer.parseInt(tbxCodigo.getText()));
//         // d.setTitulo(tbxTitulo.getText());
//         // d.setAno(Integer.parseInt(tbxAno.getText()));
//         // d.setDuracao(Integer.parseInt(tbxDuracao.getText()));
//         // d.setEstilo(tbxEstilo.getText());
//     }

//     public boolean executar() {
//         atualizarTela();
//         confirmou = false;
//         show();
//         if (confirmou) {
//             atualizarObjeto();
//             return true;
//         } else return false;
//     }

//     public static void main(String args[]) {
//         // FrmDVD frm = new FrmDVD();
//         // DVD d = new DVD();
//         // d.setTitulo("Filme de Teste");
//         // d.setEstilo("Ruim");
//         // if (frm.executar(d)) System.out.println("Confirmou!"); else System.out.println("Cancelou!");
//         // System.out.println(d.getTitulo());
//         // System.exit(0);
//     }
// }

// class FrmMenu extends JDialog implements ActionListener {

//     private int opc;
//     private HashMap<JButton, Integer> dic = new HashMap<JButton, Integer>();

//     public FrmMenu() {
//         setTitle("Cadadastro de Filmes");
//         setSize(new Dimension(400, 600));
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(HIDE_ON_CLOSE);
//         setModal(true);
//         setLayout(new FlowLayout());

//         int i = 1;
//         for (String s : new String[] {
//             "1 - inserir um filme",
//             "2 - remover dado o codigo",
//             "3 - alterar dado o codigo",
//             "4 - pesquisar valor do aluguel dado o codigo",
//             "5 - listar todos",
//             "6 - listar dado parte titulo ou estilo",
//             "7 - importar txt",
//             "8 - exportar txt",
//             "9 - importar bin",
//             "10 - exportar bin",
//             "11 - sair"
//         }) {
//             JButton btn = new JButton(s);
//             btn.setPreferredSize(new Dimension(350, 40));
//             dic.put(btn, i);
//             i++;
//             add(btn);
//             btn.addActionListener(this);
//         }
//     }

//     public void actionPerformed(ActionEvent e) {
//         JButton btn = (JButton) e.getSource();
//         opc = dic.get(btn);
//         hide();
//     }

//     public int executar() {
//         opc = 11;
//         show();
//         return opc;
//     }

//     public static void main(String g[]) {
//         FrmMenu frm = new FrmMenu();
//         JOptionPane.showMessageDialog(null, "Usuario escolheu:" + frm.executar());
//         System.exit(0);
//     }
// }

// public class Home {

//     private FrmMenu guiMenu = new FrmMenu();
//     private FrmDVD guiDVD = new FrmDVD();

//     // private FrmListar guiListar = new FrmListar();
//     // private DVDService srvDVD = new DVDService();

//     private void inserir() {
//         // DVD ficha = new DVD();
//         guiDVD.executar();
//         // srvDVD.inserir(ficha);
//     }

//     private int lerCodigo(String msg) {
//         String resp = JOptionPane.showInputDialog(msg);
//         if (resp == null) return -1; else return Integer.parseInt(resp);
//     }

//     private String lerTexto(String msg) {
//         String resp = JOptionPane.showInputDialog(msg);
//         if (resp == null) return ""; else return resp;
//     }

//     private void remover() {
//         // int cod = lerCodigo("Entre com o codigo do filme a ser removido");
//         // if (!srvDVD.existe(cod)) JOptionPane.showMessageDialog(
//         //     null,
//         //     "filme nao encontrado!",
//         //     "Aviso",
//         //     JOptionPane.INFORMATION_MESSAGE
//         // ); else {
//         //     srvDVD.remover(cod);
//         //     JOptionPane.showMessageDialog(null, "filme removido com sucesso!");
//         // }
//     }

//     private void alterar() {
//         // int cod = lerCodigo("Entre com o codigo do filme a ser alterado");
//         // DVD ficha = srvDVD.obterPeloCodigo(cod);
//         // if (ficha == null) JOptionPane.showMessageDialog(
//         //     null,
//         //     "filme nao encontrado!",
//         //     "Aviso",
//         //     JOptionPane.INFORMATION_MESSAGE
//         // ); else {
//         //     guiDVD.executar(ficha);
//         //     srvDVD.alterar(cod, ficha);
//         //     JOptionPane.showMessageDialog(null, "filme atualizado com sucesso!");
//         // }
//     }

//     private void consultarAluguel() {
//         // int cod = lerCodigo("Entre com o codigo do filme a ser consultado o valor do aluguel");
//         // if (!srvDVD.existe(cod)) JOptionPane.showMessageDialog(
//         //     null,
//         //     "filme nao encontrado!",
//         //     "Aviso",
//         //     JOptionPane.INFORMATION_MESSAGE
//         // ); else JOptionPane.showMessageDialog(
//         //     null,
//         //     String.format("aluguel = R$%10.2f\n", srvDVD.aluguel(cod))
//         // );
//     }

//     private void listar() {
//         //guiListar.executar(srvDVD.listar());
//     }

//     private void filtrar() {
//         //String parte = lerTexto("Entre com parte do nome");
//         //guiListar.executar(srvDVD.listar(parte));
//     }

//     private void importartxt() {}

//     private void exportartxt() {}

//     private void importarbin() {}

//     private void exportarbin() {}

//     public void executar() {
//         boolean acabou = false;
//         while (!acabou) {
//             try {
//                 switch (guiMenu.executar()) {
//                     case 1:
//                         inserir();
//                         break;
//                     case 2:
//                         remover();
//                         break;
//                     case 3:
//                         alterar();
//                         break;
//                     case 4:
//                         consultarAluguel();
//                         break;
//                     case 5:
//                         listar();
//                         break;
//                     case 6:
//                         filtrar();
//                         break;
//                     case 7:
//                         importartxt();
//                         break;
//                     case 8:
//                         exportartxt();
//                         break;
//                     case 9:
//                         importarbin();
//                         break;
//                     case 10:
//                         exportarbin();
//                         break;
//                     case 11:
//                         acabou = true;
//                         break;
//                 }
//             } catch (BussinesException err) {
//                 JOptionPane.showMessageDialog(
//                     null,
//                     err.getMessage(),
//                     "Erro",
//                     JOptionPane.WARNING_MESSAGE
//                 );
//             } catch (Exception err) {
//                 JOptionPane.showMessageDialog(
//                     null,
//                     "Erro não esperado! entre em contato com os desenvolvedores\n\n" +
//                     err.getMessage(),
//                     "Erro Crítico",
//                     JOptionPane.ERROR_MESSAGE
//                 );
//             }
//         }
//     }
// }

public class Tela extends JFrame {

    public void init() {
        Container c = getContentPane();
        CardLayout cardlayout = new CardLayout(30, 30);

        this.setVisible(true);

        JToolBar toolbar = new JToolBar();
        JButton button = new JButton("File");
        toolbar.addSeparator();
        toolbar.add(button);
        JButton button2 = new JButton("File2");
        toolbar.add(button2);
        toolbar.setRollover(true);

        toolbar.setFloatable(false);

        JPanel cards = new JPanel();
        cards.setLayout(cardlayout);

        JPanel panelAbout = new JPanel();
        panelAbout.setName("panelAbout");
        panelAbout.add(new JLabel("TELA DE SOBRE"));
        cards.add("panelImport", panelAbout);

        JPanel panelImport = new JPanel();
        panelImport.setName("panelImport");
        panelImport.add(new JLabel("TELA DE IMPRT"));
        cards.add("panelAbout", panelImport);

        button.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    cardlayout.show(cards, "panelAbout");
                }
            }
        );

        button2.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    cardlayout.show(cards, "panelImport");
                }
            }
        );

        c.setLayout(new BorderLayout());
        c.add(toolbar, BorderLayout.NORTH);
        c.add(cards, BorderLayout.CENTER);
    }
}
