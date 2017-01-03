package task5_0;

import task5_0.dao.EmployeesDAO;
import task5_0.db.CreateData;
import task5_0.entity.Employees;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static File FILE_PATH = new File("src\\task5_0\\db\\employees.txt");

    public static void main(String[] args) {
        List<Employees> employeesList;
        Controller controller = new Controller();

        //controller.checkFileExist(FILE_PATH);


        employeesList = controller.getAllEmployees();

        employeesList = controller.sortList(employeesList);
        employeesList.forEach(System.out::println);
        System.out.println();

        employeesList = controller.limitFirst(5, employeesList);
        employeesList.forEach(System.out::println);
        System.out.println();

        controller.limitLast(3, employeesList).forEach(System.out::println);
        // employeesList.forEach(e -> System.out.println(e.getId()));

    }


}
