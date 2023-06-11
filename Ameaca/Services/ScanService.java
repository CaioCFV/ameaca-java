package Ameaca.Services;

import java.util.Scanner;

public class ScanService {

    private static boolean hasInstance = false;
    private static Scanner sc;
    private int i;

    public String nextString() {
        return sc.nextLine();
    }

    public int nextInt() {
        i = sc.nextInt();
        this.nextString();
        return i;
    }

    public ScanService() {
        if (!hasInstance) {
            hasInstance = true;
            sc = new Scanner(System.in);
        }
    }
}
