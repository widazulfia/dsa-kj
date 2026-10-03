package lw1.unguided1a;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("rentals.txt")
        );

        int count = scanner.nextInt();

        Rental[] rentals = new Rental[count];
        int[] units = new int[count];

        for (int i = 0; i < count; i++) {

            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int unit = scanner.nextInt();

            if (type.equals("LAPTOP")) {
                rentals[i] = new LaptopRental(id, days);
            } else {
                rentals[i] = new ProjectorRental(id, days);
            }

            units[i] = unit;
        }

        scanner.close();

        for (int i = 0; i < rentals.length; i++) {

            System.out.println(
                rentals[i].getId()
                + " | "
                + rentals[i].label()
                + " | "
                + rentals[i].calculateCharge(units[i])
            );
        }
    }
}