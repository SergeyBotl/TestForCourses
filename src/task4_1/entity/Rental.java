package task4_1.entity;

public class Rental {

    private long rentalId;
    private int kind;
    private int days;
    private double basePrice;

// Other fields, constructors, get, set, etc. //

    public Rental(int kind, int days) {
        this.kind = kind;
        this.days = days;
    }

    public Rental( int kind, int days, double basePrice) {
        this.kind = kind;
        this.days = days;
        this.basePrice = basePrice;
    }

    public long getRentalId() {
        return rentalId;
    }

    public void setRentalId(long rentalId) {
        this.rentalId = rentalId;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        // Calculation of Price.
        return basePrice;
    }

// Other


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rental rental = (Rental) o;

        if (rentalId != rental.rentalId) return false;
        if (kind != rental.kind) return false;
        if (days != rental.days) return false;
        return Double.compare(rental.basePrice, basePrice) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (rentalId ^ (rentalId >>> 32));
        result = 31 * result + kind;
        result = 31 * result + days;
        temp = Double.doubleToLongBits(basePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", kind=" + kind +
                ", days=" + days +
                ", basePrice=" + basePrice +
                '}';
    }
}
