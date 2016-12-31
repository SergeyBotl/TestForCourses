package task5_0.dao;

import task5_0.entity.Employees;
import task5_0.entity.TypeWage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TimerTask;
import java.util.stream.Collectors;

import static task5_0.entity.TypeWage.*;

public class EmployeesDAO {
    private static List<Employees> employeesList = new ArrayList<>();


    public boolean save(Employees employees) {
        if (employees.getTypeWage().equals(FIXED)) {
            employees.setSalaryAverage(employees.getSalary());
        } else {
            employees.setSalaryAverage(employees.getSalary() * 8 * 20.8);
        }
        employees.setId(getAllEmployees().size() + 1);
        return employeesList.add(employees);
    }

    public List<Employees> getAllByTypeWage(TimerTask type) {
        return getAllEmployees()
                .stream()
                .filter(e -> e.getTypeWage().equals(type))
                .collect(Collectors.toList());
    }

    public double calculatingAverageSalary(TypeWage typeWage) {
        return employeesList
                .stream().filter(e -> e.getTypeWage().equals(typeWage))
                .mapToDouble(Employees::getSalaryAverage)
                .average()
                .getAsDouble();
    }

    public boolean delete(Employees employees) {
        return employeesList.remove(employees);
    }

    public Employees update(Employees employees, int index) {
        return employeesList.set(index, employees);
    }

    public Employees findById(final long id) {
        return employeesList
                .stream()
                .filter(e -> e.getId() == (id))
                .findFirst().orElse(null);
    }

    public List<Employees> getAllEmployees() {
        return employeesList;
    }

    public List<Employees> sortList(List<Employees> e) {
        Comparator<Employees> bySalaryAverage = (o1, o2) -> (int) o1.getSalaryAverage() - (int) o2.getSalaryAverage();
        Comparator<Employees> byName = (o1, o2) -> o1.getName().compareTo(o2.getName());
        return e.stream()
                .sorted(bySalaryAverage.thenComparing(byName))
                .collect(Collectors.toList());
    }

    public List<Employees> limitFirst(int first) {
       return getAllEmployees().stream().limit(first).collect(Collectors.toList());
    }

    public List<Employees> limitLast(int last) {
        long l=getAllEmployees().size()-last;
        return getAllEmployees().stream().skip(l).collect(Collectors.toList());
    }
}
