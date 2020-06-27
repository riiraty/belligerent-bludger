package riiraty;

import java.util.Scanner;
import riiraty.ui.CipherUi;

public class Main {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CipherUi ui = new CipherUi(scanner);
        ui.start();
    }
}
