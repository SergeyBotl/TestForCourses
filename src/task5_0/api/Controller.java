package task5_0.api;

import task5_0.dao.EmployeesDAO;
import task5_0.db.CreateData;
import task5_0.entity.Employees;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.TimerTask;
import java.util.stream.Collectors;

import static task5_0.entity.TypeWage.FIXED;


public class Controller {

    private EmployeesDAO dao = EmployeesDAO.getEmployeesDAO();


    public List<Employees> getAllByTypeWage(TimerTask type) {
        return getAllEmployees()
                .stream()
                .filter(e -> e.getTypeWage().equals(type))
                .collect(Collectors.toList());
    }


    public double averageSalary(Employees e) {
        return (e.getTypeWage().equals(FIXED)) ?
                e.getSalary() : e.getSalary() * 8 * 20.8;
    }


    public List<Employees> getAllEmployees() {
        return dao.getAllOfFile();
    }


    public List<Employees> sortList(List<Employees> e) {
        // Prepared the conditions and fields for sorting
        Comparator<Employees> bySalaryAverage = (o1, o2) -> (int) o2.getAverageSalary() - (int) o1.getAverageSalary();
        Comparator<Employees> byName = (o1, o2) -> o1.getName().compareTo(o2.getName());

        return e.stream()
                .sorted(bySalaryAverage.thenComparing(byName))
                .collect(Collectors.toList());
    }


    public List<Employees> limitFirst(int first, List<Employees> list) {
        return list.stream().limit(first).collect(Collectors.toList());
    }


    public List<Long> limitLast(int last, List<Employees> list) {
        long l = list.size() - last;
        return list.stream()
                .skip((l < 1) ? 0 : l)
                .map(Employees::getId)
                .collect(Collectors.toList());
    }


    public void checkFileExist(File file) {
        if (!file.exists()) {
            dao.createFile();
        }

    }
}
