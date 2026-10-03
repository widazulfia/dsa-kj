package lw1.unguided1b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("washes.txt")
        );

        int count = scanner.nextInt();

        WashService[] washes = new WashService[count];
        int[] units = new int[count];

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int unit = scanner.nextInt();

            if (type.equals("MOTORCYCLE")) {
                washes[i] = new MotorcycleWash(id, days);
            } else {
                washes[i] = new CarWash(id, days);
            }

            units[i] = unit;
        }

        scanner.close();

        for (int i = 0; i < washes.length; i++) {
            System.out.println(
                washes[i].getId()
                + " | "
                + washes[i].label()
                + " | "
                + washes[i].calculateCharge(units[i])
            );
        }
    }
}
