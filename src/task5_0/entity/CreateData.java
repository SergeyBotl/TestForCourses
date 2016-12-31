package task5_0.entity;

import task5_0.dao.EmployeesDAO;

import static task5_0.entity.TypeWage.*;

public class CreateData {

    public CreateData() {
        EmployeesDAO dao = new EmployeesDAO();
        dao.save(new Employees("Ann", 120, FIXED));
        dao.save(new Employees("Becker", 100, FIXED));
        dao.save(new Employees("Audley", 105, FIXED));
        dao.save(new Employees("Goldman", 90, FIXED));
        dao.save(new Employees("Galbraith", 80, FIXED));
        dao.save(new Employees("Erickson", 110, FIXED));
        dao.save(new Employees("Flannagan", 108, FIXED));
        dao.save(new Employees("Gibbs", 180, FIXED));
        dao.save(new Employees("Eddington", 160, FIXED));

        dao.save(new Employees("Farrell", 5, HOURLY));
        dao.save(new Employees("Ford", 4, HOURLY));
        dao.save(new Employees("Ayrton", 6, HOURLY));
        dao.save(new Employees("Bootman", 7, HOURLY));
        dao.save(new Employees("Clifford", 2, HOURLY));
        dao.save(new Employees("Cramer", 3, HOURLY));
        dao.save(new Employees("Arthurs", 4, HOURLY));
        dao.save(new Employees("Gilson", 3, HOURLY));
        dao.save(new Employees("Hancock", 4, HOURLY));
        dao.save(new Employees("Ellington", 2, HOURLY));
        dao.save(new Employees("Dyson", 1, HOURLY));
        dao.save(new Employees("Duncan", 5, HOURLY));

    }
}
