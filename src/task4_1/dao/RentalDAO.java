package task4_1.dao;

import task4_1.entity.Rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RentalDAO implements DAO<Rental> {
    static List<Rental> rentalList = new ArrayList<>();

    public double amountFor(Rental rental) {
        double result;

        // Another code.

        result = rental.getDays() * rental.getBasePrice();

        if (rental.getKind() == 1) {
            result *= 1.5;//
        }

        if (rental.getKind() == 2) {
            result *= 2;
        }

        if (rental.getKind() == 3) {
            result *= 2.5;
        }

        if (rental.getDays() > 7) {
            result *= 3;
        }

// Other calculation.
        return result;
    }

    public static long getLastId() {
        long id;
        while (true) {
            id = new Random().nextLong();
            if (id > 0) {
                break;
            }
        }
        return id;
    }

    @Override
    public boolean save(Rental rental) {
        rental.setRentalId(getLastId());
        return rentalList.add(rental);

    }

    @Override
    public boolean delete(Rental rental) {
        return rentalList.remove(rental);
    }

    @Override
    public Rental update(Rental rental, int index) {
        return rentalList.set(index, rental);
    }

    @Override
    public Rental findById(long id) {
        for (Rental r : rentalList) {
            if (r.getRentalId() == id) {
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Rental> getAll() {
        return rentalList;
    }


}
