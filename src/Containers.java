import java.util.Scanner;

public class Containers {
    private int[] containers;
    private int capacity;

    /**
     * Constructor
     * @param num_containers Number of containers to create
     * @param capacity Max capacity for each container
     */
    public Containers(int num_containers, int capacity) {
        this.containers = new int[num_containers];
        this.capacity = capacity;
    }

    /**
     * Add water to container
     * @param water Water liters to add
     * @param pos Position os the container in the array
     */
    public void add(int water, int pos) {
        int waste = (water + this.containers[pos]) - Main.capacity;
        if (waste > 0) {
            System.out.println("Container " + (pos + 1) + " is full, you waste " + waste + "L");
            this.containers[pos] = Main.capacity;
        }
        else this.containers[pos] += water;
    }

    /**
     * Remove water from container
     * @param water Water liters to remove
     * @param pos Position os the container in the array
     */
    public void remove(int water, int pos) {
        int remainder = this.containers[pos] - water;
        if (remainder < 0) {
            System.out.println("you can just remove " + this.containers[pos] + "L, Container " + (pos + 1) + " is now empty");
            this.containers[pos] = 0;
        }
        else this.containers[pos] -= water;
    }

    /**
     * Show all containers
     */
    public void show() {
        System.out.println("╔════════════╗");
        System.out.println("║ Containers ║");
        System.out.println("╚════════════╝");
        for (int i = 0; i < this.containers.length; i++) {

            System.out.print("Container " + (i + 1) + ": ");
            graphic(this.containers[i]);
            System.out.println(" " + this.containers[i] + "L/" + Main.capacity + "L");
        }
    }

    /**
     * Represents the amount of water in graph
     * @param water Amount of water
     */
    private void graphic(int water) {
        int total = ((water * 10) / this.capacity) - 1;
        for (int i = 0; i < 10; i++) {
            if (i <= total) System.out.print("■");
            else System.out.print("_");
        }
    }

    /**
     * Get an specific container
     * @param sc Scanner
     * @return Container id
     */
    public int getContainer(Scanner sc) {
        int container_id;

        do {
            System.out.println();
            System.out.print("Select container: ");
            container_id = Utils.readPositiveInt(sc);
            if (container_id > Main.num_containers) {
                System.err.println("Container not exist");
                System.out.println();
            }
        } while (container_id <= 0 || container_id > Main.num_containers);

        return container_id;
    }
}