package task5_0.db;

import task5_0.entity.Employees;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static task5_0.entity.TypeWage.*;

public class CreateData {
    private static List<Employees> list = new ArrayList<>();
   private static CreateData createData;

    public static CreateData getCreateData() {
        if (createData==null){
            createData=new CreateData();
          }

        return createData;
    }

    public  CreateData() {

        list.add(new Employees("Ann", 120, FIXED));
        list.add(new Employees("Becker", 100, FIXED));
        list.add(new Employees("Audley", 105, FIXED));
        list.add(new Employees("Goldman", 90, FIXED));
        list.add(new Employees("Galbraith", 80, FIXED));
        list.add(new Employees("Erickson", 110, FIXED));
        list.add(new Employees("Flannagan", 108, FIXED));
        list.add(new Employees("Gibbs", 180, FIXED));
        list.add(new Employees("Eddington", 160, FIXED));

        list.add(new Employees("Farrell", 5, HOURLY));
        list.add(new Employees("Ford", 4, HOURLY));
        list.add(new Employees("Ayrton", 6, HOURLY));
        list.add(new Employees("Bootman", 7, HOURLY));
        list.add(new Employees("Clifford", 2, HOURLY));
        list.add(new Employees("Cramer", 3, HOURLY));
        list.add(new Employees("Arthurs", 4, HOURLY));
        list.add(new Employees("Gilson", 3, HOURLY));
        list.add(new Employees("Hancock", 4, HOURLY));
        list.add(new Employees("Ellington", 2, HOURLY));
        list.add(new Employees("Dyson", 1, HOURLY));
        list.add(new Employees("Duncan", 5, HOURLY));
    }

    public List<Employees> getDataEmployees() {
         long id = 0;
        for (Employees e : list) {
            id++;
            e.setId(id);
        }
        return list;
    }
}
