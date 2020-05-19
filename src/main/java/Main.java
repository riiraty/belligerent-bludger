
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello tiralabra!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Give message: ");
        String message = scanner.nextLine();
        scanner.close();

        System.out.println("encrypting '" + message + "' ...");

    }
}