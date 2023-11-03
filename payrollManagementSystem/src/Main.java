import java.util.ArrayList;

abstract class Employee{ //an abstract class inheriting full-time & part-time employee class
    private final String name;
    private final int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    //an abstract method that is to be implemented by
    // full-time employee class and part-time employee class using super keyword
    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee{ //inheriting employee class and its abstract methods

    private final double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{ //inheriting employee class and its abstract methods

    private final int hoursWorked;
    private final double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem{
    private final ArrayList<Employee> empList;

    public PayrollSystem(){
        empList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){ //adding employee to the arraylist
        empList.add(employee);
    }

    public void removeEmployee(int id){ //removing employee through its id
        Employee empToRemove = null;
        for(Employee emp: empList){
            if(emp.getId() == id){
                empToRemove = emp;
                break;
            }
        }

        if(empToRemove != null){ //check whether employee that is to be removed is present or not
            empList.remove(empToRemove);
        }
    }

    public void displayEmployees(){ //displaying employees existing in arraylist
        for(Employee employee : empList){
            System.out.println(employee);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        //calling payroll system class
        PayrollSystem payrollSystem = new PayrollSystem();

        //adding employees to the payroll system methods
        FullTimeEmployee emp1 = new FullTimeEmployee("John Doe", 101, 5000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Jane Smith", 102, 30, 15.0);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(101);

        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();
    }
}