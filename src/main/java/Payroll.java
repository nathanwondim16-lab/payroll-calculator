
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Payroll {
    static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employees.csv"));
            String line = reader.readLine(); // Skips first line
            while((line = reader.readLine()) != null) {
                String[] employeeInfo = line.split("\\|");
                int employeeID = Integer.parseInt(employeeInfo[0]);
                String name = employeeInfo[1];
                double hoursWorked = Double.parseDouble(employeeInfo[2]);
                double pay = Double.parseDouble(employeeInfo[3]);
                Employee employee = new Employee(employeeID, name, hoursWorked, pay);
                System.out.printf("ID:%-10d Name: %-20s Gross Pay:$%-20.2f\n",employee.getEmployeeID(), employee.getName(), employee.getGrossPay());
            }

        } catch (IOException e) {
            System.out.println("Somethiing went wrong with writing to the file");
        }
    }
}
