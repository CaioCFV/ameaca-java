package Ameaca.Services;

import Ameaca.Entities.Threat;
import Ameaca.Repositories.ThreatRepository;

public class ThreatService {

    private ThreatRepository rep = new ThreatRepository();

    //private final Threat threat_list[] = new Threat[100];
    //private int threat_quantity = 0;
    //private int i;

    public void add(Threat t) {
        // if (d.getTitulo().length() < 2) throw new BussinesException(
        //     "Titulo deve ter mais de 1 caracter"
        // );
        // if (d.getEstilo().length() < 5) throw new BussinesException(
        //     "O Estilo deve ter mais de 5 caractere"
        // );
        // if (d.getDuracao() < 1 || d.getDuracao() > 1000) throw new BussinesException(
        //     "DVD com duração invalida"
        // );
        // if (d.getAno() < 1900 || d.getAno() > 2050) throw new BussinesException(
        //     "DVD com ano invalido"
        // );
        // if (d.getCodigo() < 1) throw new BussinesException("DVD com codigo invalido");
        // t.getCVE();
        // var dvd = rep.get(d.getCodigo());
        // if (dvd != null) throw new BussinesException("DVD com codigo ja existente");

        rep.inserir(t);
    }
    // public void listThreat(){
    //     System.out.println("+-----+----------------+----------------------------+");
    //     System.out.println("+ ID  | NÚMERO CVE     | NOME DO PRODUTO            |");
    //     System.out.println("+-----|----------------+----------------------------+");
    //     for(i = 0; i < threat_quantity; i++){
    //         System.out.format("| %-3s | %-13s | %-26s |\n", i,threat_list[i].getCVE(), threat_list[i].getProductName());
    //         System.out.println("+-----+----------------+----------------------------+");
    //     }
    // }

    // public void removeThreat(String name) {
    //      for(i = 0; i < threat_quantity; i++){
    //         if(name.equals(threat_list[i].getProductName())){
    //             threat_list[i] = threat_list[i+1];
    //             i++;
    //             threat_quantity -= 1;
    //         }
    //     }
    // }

    // public void updateThreat(int id, String cve, String product_name) {
    //     for(i = 0; i < threat_quantity; i++){
    //         if(id == i){
    //             threat_list[i].setCVE(cve);
    //             threat_list[i].setProductName(product_name);
    //         }
    //     }
    // }
}
