package task5_0.dao;

import task5_0.Main;
import task5_0.db.CreateData;
import task5_0.entity.Employees;
import task5_0.entity.TypeWage;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class EmployeesDAO implements DAO<Employees> {
    private static File filePath = Main.FILE_PATH_EMPLOYEES;
    private UtilDB utilDB = new UtilDB();
    private CreateData createData = CreateData.getCreateData();
    private List<Employees> list;


    private static EmployeesDAO employeesDAO;

    public static EmployeesDAO getEmployeesDAO() {
        if (employeesDAO == null) {
            employeesDAO = new EmployeesDAO();
        }
        return employeesDAO;
    }


    @Override
    public boolean save(Employees employees)  {
        list = getAllOfFile();
        employees.setId(list.size() + 1);
        list.add(employees);
        return utilDB.writeFile(filePath, list);
    }


    @Override
    public List<Employees> getAllOfFile() {
        int index = 0;
        list = new ArrayList<>();
        String[] e;
        StringTokenizer st = new StringTokenizer(utilDB.readFile(filePath), "\n");
        while (st.hasMoreElements()) {
            e = st.nextToken().split(" ");
            try {
                list.add(new Employees(Long.valueOf(e[0]), e[1], TypeWage.valueOf(e[2])
                        , Integer.valueOf(e[3])));
                index++;
            } catch (NumberFormatException ex) {
                System.err.println("wrong record on an index: " + index + "\n");
            } catch (IllegalArgumentException ex) {
                System.err.println("wrong format type wage index: " + index);
            }
        }
        return list;
    }


    public void createFile() {
        utilDB.writeFile(filePath, createData.getDataEmployees());
        System.out.println("create file");
    }
}
