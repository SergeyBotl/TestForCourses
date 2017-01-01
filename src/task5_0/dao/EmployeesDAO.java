package task5_0.dao;

import task5_0.db.UtilDB;
import task5_0.entity.Employees;
import task5_0.entity.TypeWage;

import java.util.*;

public class EmployeesDAO {
    private static EmployeesDAO employeesDAO;

    public static EmployeesDAO getEmployeesDAO() {
        if (employeesDAO == null) {
            employeesDAO = new EmployeesDAO();
        }
        return employeesDAO;
    }

    private List<Employees> list;
    private UtilDB utilDB = new UtilDB();

    public boolean save(Employees employees) {
        list = getAllOfFile();
        employees.setId(list.size() + 1);
        list.add(employees);
        return utilDB.writeFile(list);
    }

    public List<Employees> getAllOfFile() {
        int index = 0;
        list = new ArrayList<>();
        String[] e;
        String line;
        StringTokenizer st = new StringTokenizer(utilDB.readFile(), "\n");
        while (st.hasMoreElements()) {
            line = st.nextToken();
            e = line.split(" ");
            index++;
            try {
                list.add(new Employees(Long.valueOf(e[0]), e[1], TypeWage.valueOf(e[2])
                        , Integer.valueOf(e[3])));
            } catch (NumberFormatException e1) {
                System.err.println("wrong line on an : " + index + "\n");
            } catch (ArrayIndexOutOfBoundsException e2) {
                System.err.println("wrong format average salary index of: " + index);
            }
        }
        return list;
    }
}
