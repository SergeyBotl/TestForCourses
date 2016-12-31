package task5_0;


import task5_0.dao.EmployeesDAO;
import task5_0.db.UtilDB;
import task5_0.entity.CreateData;
import task5_0.entity.Employees;
import static task5_0.entity.TypeWage.*;
import java.io.File;

public class Main {


    public static void main(String[] args) {
        CreateData d = new CreateData();
        EmployeesDAO dao = new EmployeesDAO();

        UtilDB utilDB = new UtilDB();
        File file=new File("src\\task5_0\\employees");

        System.out.println();
        //utilDB.createFile(dao.getAllEmployees(),file);
        utilDB.readFile(file);






     /*   System.out.println(dao.calculatingAverageSalary(FIXED));

        System.out.printf("%.2f\n \n", dao.calculatingAverageSalary(HOURLY));

        // get all the entries and print
        dao.getAllEmployees().forEach(System.out::println);

        System.out.println();
        //get all the entries, sort and print

        dao.sortList(dao.getAllEmployees()).forEach(System.out::println);

        System.out.println();

        System.out.println("\n" + dao.findById(21));

        //the first five records, print all five
        dao.limitFirst(5).forEach(System.out::println);

        //the last three records, print id
        dao.limitLast(3).forEach(e -> System.out.println(e.getId()));
*/
    }


}
