package task5_0.dao;

import task5_0.db.UtilDB;
import task5_0.entity.Employees;
import task5_0.entity.TypeWage;

import java.io.File;
import java.util.*;

/**
 * EmployeesDAO class works with the database,
 * in this case the file employees.txt
 */
public class EmployeesDAO {
    public static File FILE_PATH;
    private List<Employees> list;
    private UtilDB utilDB = new UtilDB();

    /**
     * Singleton. Receive one copy of the class
     */
    private static EmployeesDAO employeesDAO;

    public static EmployeesDAO getEmployeesDAO() {
        if (employeesDAO == null) {
            employeesDAO = new EmployeesDAO();
        }
        return employeesDAO;
    }

    /**
     * add the id is stored in the collection
     * and transferred to UtilDB class to save a file
     *
     * @param employees
     * @return boolean,
     */
    public boolean save(Employees employees) {
        list = getAllOfFile();
        employees.setId(list.size() + 1);
        list.add(employees);
        return utilDB.writeFile(FILE_PATH, list);
    }

    /**
     * Translate string in the list
     * and returns a collection of objects
     */
    public List<Employees> getAllOfFile() {
        int index = 0;
        list = new ArrayList<>();
        String[] e;
        StringTokenizer st = new StringTokenizer(utilDB.readFile(FILE_PATH), "\n");
        while (st.hasMoreElements()) {
            e = st.nextToken().split(" ");
            try {
                list.add(new Employees(Long.valueOf(e[0]), e[1], TypeWage.valueOf(e[2])
                        , Integer.valueOf(e[3])));
                index++;
            } catch (NumberFormatException ex) {
                System.err.println("wrong record on an index: " + index + "\n");
            } catch (IllegalArgumentException ex) {
                System.err.println("wrong format type wage index of: " + index);
            }
        }
        return list;
    }
}
