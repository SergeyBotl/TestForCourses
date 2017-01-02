package task5_0;

import task5_0.dao.EmployeesDAO;
import task5_0.entity.Employees;

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
     * @param type (wage type)
     * @return Returns a collection of the filtered for wage type
     * used here java8.
     */
    public List<Employees> getAllByTypeWage(TimerTask type) {
        return getAllEmployees()
                .stream()
                .filter(e -> e.getTypeWage().equals(type))
                .collect(Collectors.toList());
    }

    /**
     * The calculation of the average monthly salary,
     * depending on the type of salary
     * For employees with hourly
     * wage use next formula: “average monthly salary= 20.8*8* hourly rate”, for
     * employees with fixed payment – “average monthly salary= fixed monthly
     * payment”.
     *
     * @param e (Employees) a copy of the employee
     * @return variable type double average monthly salary
     */
    public double averageSalary(Employees e) {
        return (e.getTypeWage().equals(FIXED)) ?
                e.getSalary() : e.getSalary() * 8 * 20.8;
    }

    /**
     * Here I get a collection of all employees
     *
     * @return collection of all employees
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
        Comparator<Employees> bySalaryAverage = (o1, o2) -> (int) averageSalary(o2) - (int) averageSalary(o1);
        Comparator<Employees> byName = (o1, o2) -> o1.getName().compareTo(o2.getName());
        return e.stream()
                .sorted(bySalaryAverage.thenComparing(byName))
                .collect(Collectors.toList());
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
        long l = list.size() - last;
        return list.stream()
                .map(employees -> employees.getId())
                .skip((l < 1) ? 0 : l)
                .collect(Collectors.toList());
    }
}
