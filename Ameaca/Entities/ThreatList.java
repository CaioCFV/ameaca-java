package Ameaca.Entities;

public class ThreatList {

    private final Threat threat_list[] = new Threat[100];
    private int threat_quantity = 0;
    private int i;

    public void addThreat(String cve, String product_name) {
        Threat th = new Threat();
        th.setCVE(cve);
        th.setProductName(product_name);
        threat_list[threat_quantity] = th;
        threat_quantity++;
    }

    public void listThreat() {
        System.out.println("+-----+----------------+----------------------------+");
        System.out.println("+ ID  | NÚMERO CVE     | NOME DO PRODUTO            |");
        System.out.println("+-----|----------------+----------------------------+");
        for (i = 0; i < threat_quantity; i++) {
            System.out.format(
                "| %-3s | %-13s | %-26s |\n",
                i,
                threat_list[i].getCVE(),
                threat_list[i].getProductName()
            );
            System.out.println("+-----+----------------+----------------------------+");
        }
    }

    public void removeThreat(String name) {
        for (i = 0; i < threat_quantity; i++) {
            if (name.equals(threat_list[i].getProductName())) {
                threat_list[i] = threat_list[i + 1];
                i++;
                threat_quantity -= 1;
            }
        }
    }

    public void updateThreat(int id, String cve, String product_name) {
        for (i = 0; i < threat_quantity; i++) {
            if (id == i) {
                threat_list[i].setCVE(cve);
                threat_list[i].setProductName(product_name);
            }
        }
    }
}
