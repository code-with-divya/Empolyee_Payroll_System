import java.util.ArrayList;

// Abstract Class Employe
abstract class Employe {

    private String Name;
    private int id;

    // Constructor
    public Employe(String Name, int id) {
        this.Name = Name;
        this.id = id;
    }

    // Getter Methods
    public String getName() {
        return Name;
    }

    public int getId() {  // Fix method name from getid() → getId()
        return id;
    }
    // you have not declared body 
    // Abstract Method
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employe [Name = " + Name + ", id = " + id + ", Salary = " + calculateSalary() + "]";
    }
}

// Full-time Employee Class
class FullTimeEmploye extends Employe {
    private double monthlySalary;

    public FullTimeEmploye(String Name, int id, double monthlySalary) {
         // parent invoke variable in super keyword...
        super(Name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// Part-time Employee Class
class PartTimeEmploye extends Employe {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmploye(String Name, int id, int hoursWorked, double hourlyRate) {
        super(Name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        // multiple
        return hoursWorked * hourlyRate;
    }
}

// Payroll System Class
class PayrollSystem {
    // Employee list
    private ArrayList<Employe> employeList;

    public PayrollSystem() {
        employeList = new ArrayList<>();
    }

    // Add Employee
    public void addEmploye(Employe employe) {
        // using add method
        employeList.add(employe);
    }

    // Remove Employee
    public void removeEmploye(int id) {
        Employe employeToRemove = null;
        for (Employe employe : employeList) {
            if (employe.getId() == id) {
                employeToRemove = employe;
                break;
            }
        }
        if (employeToRemove != null) {
            employeList.remove(employeToRemove);
        }
    }

    // Display Employees
    public void displayEmploye() {
        for (Employe employe : employeList) {
            System.out.println(employe); // Calls toString()
        }
    }
}

// Main Class
public class First1 {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        // Creating Employees
        FullTimeEmploye divya = new FullTimeEmploye("Divya", 1, 7000.0);
        PartTimeEmploye priya = new PartTimeEmploye("Priya", 2, 40, 100);

        // Adding Employees
        payrollSystem.addEmploye(divya);
        payrollSystem.addEmploye(priya);

        // Display Employee Details
        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmploye();

        // Removing an Employee
        System.out.println("\nRemoving Employee with ID 2...");
        payrollSystem.removeEmploye(2);

        // Display Remaining Employees
        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmploye();
    }
}
