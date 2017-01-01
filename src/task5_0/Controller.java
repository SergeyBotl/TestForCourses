package task5_0;

import task5_0.dao.EmployeesDAO;
import task5_0.entity.Employees;

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
        Comparator<Employees> bySalaryAverage = (o1, o2) -> (int) averageSalary(o2) - (int) averageSalary(o1);
        Comparator<Employees> byName = (o1, o2) -> o1.getName().compareTo(o2.getName());
        return e.stream()
                .sorted(bySalaryAverage.thenComparing(byName))
                .collect(Collectors.toList());
    }

    public List<Employees> limitFirst(int first, List<Employees> list) {
        return list.stream().limit(first).collect(Collectors.toList());
    }

    public List<Employees> limitLast(int last, List<Employees> list) {
        long l = list.size() - last;
        return list.stream().skip(l).collect(Collectors.toList());
    }
}
