package task5_0.entity;

public class Employees {
    private long id;
    private String name;
    private TypeWage typeWage;
    private int salary;
    private double salaryAverage;

    public Employees(String name, int salary, TypeWage typeWage) {
        this.name = name;
        this.salary = salary;
        this.typeWage = typeWage;
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

    public double getSalaryAverage() {
        return salaryAverage;
    }

    public void setSalaryAverage(double salaryAverage) {
        this.salaryAverage = salaryAverage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        if (id != employees.id) return false;
        if (salary != employees.salary) return false;
        if (Double.compare(employees.salaryAverage, salaryAverage) != 0) return false;
        if (name != null ? !name.equals(employees.name) : employees.name != null) return false;
        return typeWage == employees.typeWage;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (typeWage != null ? typeWage.hashCode() : 0);
        result = 31 * result + salary;
        temp = Double.doubleToLongBits(salaryAverage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return
               id +
                " " + name   +
                " " + typeWage +
                " " + salary +
                " "+
                String.format("%.2f",salaryAverage)
                 ;
    }
}
