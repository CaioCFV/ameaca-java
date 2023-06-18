package Ameaca;

import Ameaca.Views.*;

// 6. baixar patch de uma ameaca

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

public class Principal {

    public static void main(String args[]) {
        MainGUI mainGUI = new MainGUI();
        mainGUI.init();
    }
}
