import java.util.Scanner;

public class Main {
    public static int num_containers;
    public static int capacity;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("How many containers do you want?: ");
        num_containers = Utils.readPositiveInt(sc);

        System.out.print("What will be its capacity?: ");
        capacity = Utils.readPositiveInt(sc);

        Containers c = new Containers(num_containers, capacity);
        int op;
        do {
            c.show();
            Menu.show();
            op = Utils.readInt(sc);
            switch (op) {
                case 1:
                    addWater(c);
                    break;
                case 2:
                    removeWater(c);
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
        int water = Utils.readPositiveInt(sc);
        c.add(water, container_id - 1);
    }

    /**
     * Remove water from specific container
     * @param c Container
     */
    public static void removeWater(Containers c) {
        int container_id = c.getContainer(sc);

        System.out.print("L of water to remove: ");
        int water = Utils.readPositiveInt(sc);
        c.remove(water, container_id - 1);
    }
}