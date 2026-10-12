package lw3.unguided3a;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1. Initialize Map
        Map<String, Integer> enrollment = new LinkedHashMap<>();

        String checkResults = "";
        int rejected = 0;

        // 2. Read and process enrollment operations
        Scanner file = new Scanner(
            Main.class.getResourceAsStream("enrollment.txt")
        );

        while (file.hasNextLine()) {
            String line = file.nextLine();
            Scanner input = new Scanner(line);

            String operation = input.next();

            if (operation.equals("REGISTER")) {
                String course = input.next();
                int count = input.nextInt();

                if (count <= 0) {
                    rejected++;

                } else if (enrollment.containsKey(course)) {
                    enrollment.put(
                        course,
                        enrollment.get(course) + count
                    );

                } else {
                    enrollment.put(course, count);
                }

            } else if (operation.equals("WITHDRAW")) {
                String course = input.next();
                int count = input.nextInt();

                if (count <= 0) {
                    rejected++;

                } else if (enrollment.containsKey(course)
                        && enrollment.get(course) >= count) {
                    enrollment.put(
                        course,
                        enrollment.get(course) - count
                    );

                } else {
                    rejected++;
                }

            } else if (operation.equals("CHECK")) {
                String course = input.next();

                if (enrollment.containsKey(course)) {
                    checkResults += course + ": "
                        + enrollment.get(course)
                        + " students\n";
                } else {
                    checkResults += course + ": Not found\n";
                }
            }

            input.close();
        }

        file.close();

        // 3. Display enrollment checks
        System.out.println("===== Enrollment Checks =====");
        System.out.print(checkResults);

        // 4. Display final enrollment
        System.out.println();
        System.out.println("===== Final Enrollment =====");

        for (String course : enrollment.keySet()) {
            System.out.println(
                course + ": " + enrollment.get(course) + " students"
            );
        }

        // 5. Display summary
        System.out.println();
        System.out.println("Rejected operations: " + rejected);
    }
}