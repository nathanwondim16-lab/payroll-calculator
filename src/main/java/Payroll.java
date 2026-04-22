import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Payroll {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the employee file to process: ");
        String employeeFile = scanner.nextLine().strip().toLowerCase();
        System.out.print("Enter the name of the payroll file to create: ");
        String payrollFile = scanner.nextLine().strip().toLowerCase();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(employeeFile));
            boolean isJson = payrollFile.endsWith(".json");
            BufferedWriter writer = new BufferedWriter(new FileWriter(payrollFile));
            if(isJson) {
                writer.write("[\n");
            }
            String line = reader.readLine(); // Skips first line
            boolean firstComma = true;
            while((line = reader.readLine()) != null) {
                String[] employeeInfo = line.split(Pattern.quote("|"));
                int employeeID = Integer.parseInt(employeeInfo[0]);
                String name = employeeInfo[1];
                double hoursWorked = Double.parseDouble(employeeInfo[2]);
                double pay = Double.parseDouble(employeeInfo[3]);
                Employee employee = new Employee(employeeID, name, hoursWorked, pay);
                if(!firstComma) {
                    writer.write(",\n");
                }
                if(isJson) {
                    writer.write(String.format("\t{ \"id\":  %d, \"name\"  :  \"%s\", \"grossPay\" : %.2f }",employee.getEmployeeID(), employee.getName(), employee.getGrossPay()));
                    firstComma = false;
                } else {
                    writer.write(String.format("ID:%-10d Name: %-20s Gross Pay:$%-20.2f\n",employee.getEmployeeID(), employee.getName(), employee.getGrossPay()));
                }
            }
            if(isJson) {
                writer.write("\n]");
            }
            writer.close();
            reader.close();

        } catch (IOException e) {
            System.out.println("Something went wrong with writing to the file");
        }

    }
}
