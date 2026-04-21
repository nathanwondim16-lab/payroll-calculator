public class Employee {
    private int employeeID;
    private String name;
    private double hoursWorked;
    private double payRate;

    Employee() {

    }

    Employee(int employeeID, String name, double hoursWorked, double payRate) {
        this.employeeID = employeeID;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public double getGrossPay() {
        return hoursWorked * payRate;
    }

    public String getName() {
        return name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }
}
