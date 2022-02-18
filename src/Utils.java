import java.util.Scanner;

public class Utils {
    /**
     * Integer read with error prevention
     * @param sc Scanner
     * @return Integer readed
     */
    public static int readInt(Scanner sc) {
        int op = 0;
        boolean err = true;
        do {
            try {
                op = sc.nextInt();
                err = false;
            } catch (Exception e) {
                System.err.println("Wrong type");
                sc.nextLine();
            }
        } while (err);
        return op;
    }

    public static int readPositiveInt(Scanner sc) {
        int value;
        do {
            value = readInt(sc);
            if (value < 0) System.err.println("Negative value");
        } while (value < 0);
        return value;
    }
}