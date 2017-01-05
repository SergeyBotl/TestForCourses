package task5_0.entity;

import java.io.Serializable;

/**
 * object model
 */
public class Employees implements Serializable {
    private long id;
    private String name;
    private TypeWage typeWage;
    private int salary;


    public Employees(String name, int salary, TypeWage typeWage) {
        this.name = name;
        this.salary = salary;
        this.typeWage = typeWage;
    }

    public Employees(long id, String name, TypeWage typeWage, int salary) {
        this.id = id;
        this.name = name;
        this.typeWage = typeWage;
        this.salary = salary;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeWage getTypeWage() {
        return typeWage;
    }

    public void setTypeWage(TypeWage typeWage) {
        this.typeWage = typeWage;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {

        this.salary = salary;
    }

    public double getAverageSalary() {
        return (typeWage.equals(TypeWage.HOURLY)) ? salary * 20.8 * 8 : salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        if (id != employees.id) return false;
        if (salary != employees.salary) return false;
        if (name != null ? !name.equals(employees.name) : employees.name != null) return false;
        return typeWage == employees.typeWage;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (typeWage != null ? typeWage.hashCode() : 0);
        result = 31 * result + salary;
        return result;
    }

    @Override
    public String toString() {
        return id +
                " " + name +
                " " + typeWage +
                " " + salary +
                " " +
                String.format("%.2f", (typeWage.equals(TypeWage.FIXED) ? getSalary() : (getSalary() * 20.8 * 8)))
                ;
    }


}
