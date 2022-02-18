import java.util.Scanner;

public class Main {
    public static int NUM_CONTAINERS = 5;
    public static int CAPACITY = 25;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Containers c = new Containers(NUM_CONTAINERS, CAPACITY);
        int op;
        do {
            Menu.show();
            op = Utils.readInt(sc);
            switch (op) {
                case 1:
                    addWater(c);
                    break;
                case 2:
                    removeWater(c);
                    break;
                case 3:
                    c.show();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Wrong option");
                    System.err.flush();
            }
        } while (op != 0);
    }

    /**
     * Add water to a specific container
     * @param c Container
     */
    public static void addWater(Containers c) {
        int container_id = c.getContainer(sc);

        System.out.print("L of water to add: ");
        int water = Utils.readWaterQuantity(sc);
        c.add(water, container_id - 1);
    }

    /**
     * Remove water from specific container
     * @param c Container
     */
    public static void removeWater(Containers c) {
        int container_id = c.getContainer(sc);

        System.out.print("L of water to remove: ");
        int water = Utils.readWaterQuantity(sc);
        c.remove(water, container_id - 1);
    }
}