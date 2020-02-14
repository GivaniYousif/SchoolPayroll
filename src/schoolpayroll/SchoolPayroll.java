/*
Course:        CS-182
Project:       Cuyamaca Payroll Application
Name:          Givani Yousif
Date:          9/23/2015
Description:   This application will prompt the user for an employee's name, 
               what type of employee they are, and what their wages are based on
               their employee type. The application will then output the 
               employee's weekly salary after taxes and deductions.
 */
package schoolpayroll;

/*
Module		:	CuyamacaPayroll
Description	:	User inputs information about the employee, application
                        returns employee's weekly wage.
Input		:	Employee's name, salary, and if not a salaried employee,
                        hours worked.
Output		:	Employee's name with weekly wages after taxes and 
                        deductions.
 */

import java.util.Scanner;
import java.text.NumberFormat;

public class SchoolPayroll 
{
    enum EmployeeType { SALARIED , HOURLY, TEMPORARY }

    public static void main(String[] args) 
    {
       Scanner        keyboard = new Scanner( System.in );
       String         employeeName;
       String         employeeType;
       char           employeeChar;
       EmployeeType   employee = EmployeeType.SALARIED;
       double         salary = 0.0;
       double         yearlySalary = 0.0;
       double         yearlySalaryTaxed = 0.0;
       double         hourlyEmployeeSalary = 0.0;
       double         tempEmployeeSalary = 0.0;
       double         weeklySalary = 0.0;
       double         weeklySalaryTaxed = 0.0;
       double         salaryTaxes = 0.0;
       double         retirementPension = 0.0;
       int            hours = 0;
       
       System.out.println("Cuyamaca Payroll Calculator");
       System.out.print( "Enter the name of the employee (Quit to Exit): " );
       employeeName = keyboard.nextLine();
       
       while (( !employeeName.equalsIgnoreCase( "QUIT" )) && ( employeeName.length() != 0 ))
       {
         System.out.print( "Employee Type [S]alaried, [H]ourly, [T]emporary: " );
         employeeType = keyboard.nextLine();
         employeeChar = employeeType.charAt( 0 );
         
         // Review Product Type entered, set Enumerated Type value 
         if (( employeeType.equalsIgnoreCase( "SALARIED" )) || ( employeeChar == 's' ) || ( employeeChar == 'S' ))
         {
            employee = EmployeeType.SALARIED;
            System.out.print("Enter " + employeeName + "'s yearly salary: $");
            yearlySalary = keyboard.nextDouble();
         }
         else if (( employeeType.equalsIgnoreCase( "HOURLY" )) || ( employeeChar == 'h' ) || ( employeeChar == 'H' ))
         {
            employee = EmployeeType.HOURLY;
            System.out.print("Enter " + employeeName + "'s hourly wage: $");
            hourlyEmployeeSalary = keyboard.nextDouble();
            System.out.print("Enter the number of hours worked per week: ");
            hours = keyboard.nextInt();
         }
         else if (( employeeType.equalsIgnoreCase( "TEMPORARY" )) || ( employeeChar == 't' ) || ( employeeChar == 'T' ))
         {
            employee = EmployeeType.TEMPORARY;
            System.out.print("Enter " + employeeName + "'s hourly wage (No Taxes Deducted): $");
            tempEmployeeSalary = keyboard.nextDouble();
            System.out.print("Enter the number of hours worked per week: ");
            hours = keyboard.nextInt();
         }
      
         
         switch ( employee )
         {
             case SALARIED:
                 // Salaried employees are taxed for 22% of their salary
                 salaryTaxes = yearlySalary * 0.22;
                 retirementPension = yearlySalary * 0.04;
                 yearlySalaryTaxed = yearlySalary - (salaryTaxes + retirementPension);
                 System.out.println("Employee: " + employeeName + "\nGross Wages: $" + yearlySalary + "\nTaxes Withheld: $" + salaryTaxes + "\nRetirement Pension Withheld: $" + retirementPension + "\nNet Wages: $" + weeklySalaryTaxed );
             break;    
                 
             case HOURLY:
                 // Salaried employees are taxed for 18% of their salary
                 weeklySalary = (hourlyEmployeeSalary * hours);
                 weeklySalaryTaxed = ((hourlyEmployeeSalary * hours) - salaryTaxes);
                 salaryTaxes = hourlyEmployeeSalary * 0.18;
                 System.out.println("Employee: " + employeeName + "\nGross Wages: $" + weeklySalary + "\nTaxes Withheld: $" + salaryTaxes + "\nNet Wages: $" + weeklySalaryTaxed );
             break;
                 
             case TEMPORARY:
                 // Temporary employees are not taxed
                 weeklySalary = (tempEmployeeSalary * hours);
                 System.out.println("Employee: " + employeeName + "\nGross Wages: $" + weeklySalary + "\nNO TAXES WITHHELD");

             break;
                
         }
         
         
         
    }
    
  }
}