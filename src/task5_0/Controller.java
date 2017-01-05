package task5_0;

import task5_0.dao.EmployeesDAO;
import task5_0.db.CreateData;
import task5_0.entity.Employees;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.TimerTask;
import java.util.stream.Collectors;

import static task5_0.entity.TypeWage.FIXED;

/**
 * Controller class here as the API system.
 */
public class Controller {

    private EmployeesDAO dao = EmployeesDAO.getEmployeesDAO();

    /**
     * Filter by type salary.
     * used here java8.
     *
     * @param type parameter type  salary from enum TypeWage
     * @return Returns  collection the employees
     */
    public List<Employees> getAllByTypeWage(TimerTask type) {
        return getAllEmployees()
                .stream()
                .filter(e -> e.getTypeWage().equals(type))
                .collect(Collectors.toList());
    }

   /* *//**
     * The calculation of the average wage,
     * depending on the type of wages.
     * For employees with hourly
     * wage use next formula: “average monthly salary= 20.8*8* hourly rate”, for
     * employees with fixed payment – “average monthly salary= fixed monthly
     * payment”.
     *
     * @param e (Employees) one object the employee
     * @return type double average monthly salary
     *//*
    public double averageSalary(Employees e) {
        return (e.getTypeWage().equals(FIXED)) ?
                e.getSalary() : e.getSalary() * 8 * 20.8;
    }*/

    /**
     * Here get all employees  in the list
     * from EmployeesDAO class
     *
     * @return collection  type the "Employees"
     */
    public List<Employees> getAllEmployees() {
        return dao.getAllOfFile();
    }

    /**
     * Sort the resulting collection
     * Sort the collection of employees in descending order by the average
     * monthly salary. In the case of equal salary – by the name.
     *
     * @param e List<Employees>
     * @return sort a collection of all employees.
     * Used java8
     * Since the beginning of creating two filters then
     * filter in the method of sorted()
     */
    public List<Employees> sortList(List<Employees> e) {
        //Here  prepared the conditions and fields for sorting
        Comparator<Employees> bySalaryAverage = (o1, o2) -> (int) o2.getAverageSalary() - (int) o1.getAverageSalary();
        Comparator<Employees> byName = (o1, o2) -> o1.getName().compareTo(o2.getName());

        return e.stream()
                .sorted(bySalaryAverage.thenComparing(byName))//Here is sorted
                .collect(Collectors.toList());//return in the list
    }

    /**
     * The method takes a  specified number first
     * of workers from the collection
     *
     * @param first how to get the lines
     * @param list  list of  take a lines
     * @return found rows
     * Used java8
     */
    public List<Employees> limitFirst(int first, List<Employees> list) {
        return list.stream().limit(first).collect(Collectors.toList());
    }

    /**
     * Looking for a predetermined number of last lines
     * ((l < 1) ? 0 : l)if the number of rows is less
     * than zero then it returns the entire list
     *
     * @param last how to get the lines
     * @param list list of  take a lines
     * @return a collection of id field, Long type
     * Used java8
     */
    public List<Long> limitLast(int last, List<Employees> list) {
        long l = list.size() - last; //The number of skipped lines
        return list.stream()
                .skip((l < 1) ? 0 : l)
                .map(Employees::getId)// get the fields  ids
                .collect(Collectors.toList());//return in the list type the long
    }

    /**
     * Method for testing only
     * <p>
     * if (!file.exists()) If this file does not
     * exist then create a new.
     *
     * @param file
     */
    public void checkFileExist(File file) {
        if (!file.exists()) {
            dao.createFile();
        }

    }
}
