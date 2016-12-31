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
            String[] sDouble = e[4].split(",");
            try {
                list.add(new Employees(Long.valueOf(e[0]), e[1], TypeWage.valueOf(e[2])
                        , Integer.valueOf(e[3])
                        ));
                       // , Double.valueOf(sDouble[0] + "." + sDouble[1])));
                       // , doubleValueOf(e[4])));
            } catch (NumberFormatException e1) {
                System.err.println("wrong line on an : " + index + "\n");
            } catch (ArrayIndexOutOfBoundsException e2) {
                System.err.println("wrong format average salary index of: "+index);
            }
        }
        return list;
    }

    double doubleValueOf(String s) {
        String[] sDouble = s.split(",");
        double result;
        try {
            result = Double.valueOf(sDouble[0] + "." + sDouble[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("wrong format average salary");
            throw e;

        }
        return result;
    }
}
