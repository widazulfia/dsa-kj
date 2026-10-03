package lw1.prelab;

public abstract class PrintJob implements Chargeable {

    private String id;
    private int pages;

    protected PrintJob(String id, int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("pages must be a positive number");
        }
        this.id = id;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public abstract int calculateCharge();

    /**
     * Overloaded version: total charge for a number of identical copies.
     * Implemented once here so MonoPrint/ColourPrint do not duplicate it.
     */
    public int calculateCharge(int copies) {
        if (copies <= 0) {
            throw new IllegalArgumentException("copies must be a positive number");
        }
        return copies * calculateCharge();
    }

    public String label() {
        return "Print";
    }

    /** Always priced at a single copy, regardless of any copies value seen elsewhere. */
    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
