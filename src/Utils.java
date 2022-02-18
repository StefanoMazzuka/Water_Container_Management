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

    public static int readWaterQuantity(Scanner sc) {
        int water;
        do {
            water = readInt(sc);
            if (water < 0) System.err.println("Negative value");
        } while (water < 0);
        return water;
    }
}