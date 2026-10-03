package lw1.unguided1b;

public class CarWash extends WashService {
    public CarWash(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int charge;

        if (getDays() <= 3) {
            charge = getDays() * 35000;
        } else {
            charge = 3 * 35000 + (getDays() - 3) * 25000;
        }

        return charge + 15000;
    }

    @Override
    public String label() {
        return "Car";
    }
}
