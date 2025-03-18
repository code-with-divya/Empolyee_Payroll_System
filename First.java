
import java.util.ArrayList;

abstract class Employe {

    private String Name;

    private int id ;

    // created constructore empolye...
    public Employe(String Name , int id){
    // corresponding value assigned here this keyword...
        this.Name = Name ;
        this.id =  id;
    }

    // get method
    public String getName(){
        return Name;
    }

    public int getid(){
        return id;
    }


    // you have not declared body 
    public abstract double calculateSalary();
    @Override
    public String toString(){
        return "Employe [Name ="+  Name+",id ="+id+", salary ="+calculateSalary()+"]";
    }
}

// 1st class full time
class FullTimeEmploye extends Employe {
    private double monthlySalary;


    public FullTimeEmploye(String Name ,int id ,double monthlySalary){
        // parent invoke variable in super keyword...
        super(Name,id);
        this.monthlySalary = monthlySalary;

    }

    @Override
    public double calculateSalary(){
        return monthlySalary;

    }

}
// 2nd class parttime
class PartTimeEmploye extends Employe {
    private int hoursWorked;

    private double hourlyRate;

    public PartTimeEmploye(String Name ,int id ,int hoursWorked , double hourlyRate){
        super(Name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }
    @Override
    public double calculateSalary(){
        // multiple 
        return hoursWorked *hourlyRate;
    }

}

class PayrollSystem{
    // created empolye Arraylist collection of data
    private ArrayList<Employe> employeslisList;

    public PayrollSystem(){
        employeList = new ArrayList<>();
    }
    // using add method and added new empolye....
    public void addEmploye(first.Employe employe){
        employelisList.add(employe);
   }

   public void removeEmpolye(int id){
    Employe employeToRemove =null ;
    for(Employe employe:employeList){
        if(employe.getid()==id){
            employeToRemove = employe;
            break;
        }
    }

    if(employeToRemove!=null){
        employeslisList.remove(employeToRemove);
    }
}
}


public void displayEmploye() {
    for(Employe employe : employeList) {
        System.out.println(employe);  // This will call employee.toString() and print details
    }
}


public class First {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        // Corrected object instantiation
        FullTimeEmploye divya = new FullTimeEmploye("Divya", 1, 7000.0);
        PartTimeEmploye priya = new PartTimeEmploye("Priya", 2, 40, 100);

        // Adding employees
        payrollSystem.addEmploye(divya);
        payrollSystem.addEmploye(priya);

        // Display initial employee details
        System.out.println("Initial employee details:");
        payrollSystem.displayEmploye();

        // Remove an employee
        System.out.println("\nRemoving Employee with ID 2...");
        payrollSystem.removeEmploye(2);

        // Display remaining employees
        System.out.println("\nRemaining employee details:");
        payrollSystem.displayEmploye();
    }
}
