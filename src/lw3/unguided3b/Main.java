package lw3.unguided3b;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1. Initialize Sets
        Set<String> registered = new HashSet<>();
        Set<String> checkedIn = new HashSet<>();

        int rejected = 0;

        // 2. Read registered students
        Scanner reg = new Scanner(
            Main.class.getResourceAsStream("registrations.txt")
        );

        while (reg.hasNext()) {
            String id = reg.next();
            registered.add(id);
        }

        reg.close();

        // 3. Read and process check-ins
        Scanner check = new Scanner(
            Main.class.getResourceAsStream("checkins.txt")
        );

        System.out.println("===== Event Check-In Results =====");

        while (check.hasNext()) {
            String id = check.next();

            if (!registered.contains(id)) {
                System.out.println(id + ": Rejected (not registered)");
                rejected++;

            } else if (checkedIn.contains(id)) {
                System.out.println(id + ": Rejected (already checked in)");
                rejected++;

            } else {
                checkedIn.add(id);
                System.out.println(id + ": Checked in");
            }
        }

        check.close();

        // 4. Calculate summary
        int absent = registered.size() - checkedIn.size();

        // 5. Display results
        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registered.size());
        System.out.println("Successful check-ins: " + checkedIn.size());
        System.out.println("Absent students: " + absent);
        System.out.println("Rejected attempts: " + rejected);
    }
}
