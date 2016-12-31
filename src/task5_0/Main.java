package task5_0;

import task5_0.dao.Controller;
import task5_0.dao.EmployeesDAO;
import task5_0.db.UtilDB;
import task5_0.db.CreateData;
import task5_0.entity.Employees;

import static task5_0.entity.TypeWage.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        UtilDB.FILE_PATH = new File("src\\task5_0\\employees");
        CreateData d = new CreateData();
        Controller controller = new Controller();
        UtilDB utilDB = new UtilDB();
        List<Employees> employeesList = new ArrayList<>(controller.getAllEmployees());



        employeesList = controller.sortList(employeesList);
        employeesList.forEach(System.out::println);
        System.out.println();
        employeesList = controller.limitFirst(5, employeesList);
        employeesList.forEach(System.out::println);
        System.out.println();
        employeesList = controller.limitLast(3, employeesList);
        employeesList.forEach(e -> System.out.println(e.getId()));

    }


}
