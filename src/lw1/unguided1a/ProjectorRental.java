package lw1.unguided1a;

public class ProjectorRental extends Rental {

    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int charge;

        if (getDays() <= 3) {
            charge = getDays() * 60000;
        } else {
            charge = 3 * 60000 + (getDays() - 3) * 45000;
        }

        return charge + 20000;
    }

    @Override
    public String label() {
        return "Projector";
    }
}