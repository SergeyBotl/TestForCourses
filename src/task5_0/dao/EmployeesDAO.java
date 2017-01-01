package task5_0.dao;

import task5_0.db.UtilDB;
import task5_0.entity.Employees;
import task5_0.entity.TypeWage;

import java.io.File;
import java.util.*;

public class EmployeesDAO {
    private static EmployeesDAO employeesDAO;
    public static File FILE_PATH;

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
        return utilDB.writeFile(FILE_PATH, list);
    }

    public List<Employees> getAllOfFile() {
        int index = 0;
        list = new ArrayList<>();
        String[] e;
        String line;
        StringTokenizer st = new StringTokenizer(utilDB.readFile(FILE_PATH), "\n");
        while (st.hasMoreElements()) {
            line = st.nextToken();
            e = line.split(" ");
            try {
                list.add(new Employees(Long.valueOf(e[0]), e[1], TypeWage.valueOf(e[2])
                        , Integer.valueOf(e[3])));
                index++;
            } catch (NumberFormatException ex) {
                System.err.println("wrong record on an index: " + index + "\n");
            } catch (IllegalArgumentException ex) {
                System.err.println("wrong format type wage index of: " + index);
            } finally {

            }
        }
        return list;
    }
}
