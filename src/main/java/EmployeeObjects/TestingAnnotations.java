package EmployeeObjects;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestingAnnotations {
    public static void main(String[] args){
        // Creates hourly, salary, commission employee objects
        CommissionEmployee commissionEmployee = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", 0.0265);
        SalaryEmployee salaryEmployee = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);

        hourlyEmployee.increaseHours(40);
        commissionEmployee.increaseSales(200);

        Object[] employees = {commissionEmployee, hourlyEmployee, salaryEmployee};

        int numOfEmployee = 0;

        // Loops through the employees checking to see if the class is annotated with the Employee type
        // if the annotation is present it increases the variable.
        for (Object employee:employees){
            Class<?> employeeTypeClass = employee.getClass();

            if(employeeTypeClass.isAnnotationPresent(EmployeeType.class)){
                numOfEmployee ++;

                EmployeeType employeeType = employeeTypeClass.getAnnotation(EmployeeType.class);

                System.out.println("\n" + "Employee Type: " + employeeType.type());
            }

            Method[] methods = employeeTypeClass.getDeclaredMethods();
            for (Method method:methods){
                if (method.isAnnotationPresent(WeeklyPayCalculator.class)){
                    try {
                        method.setAccessible(true);
                        Object weeklyPay = method.invoke(employee);
                        System.out.printf("Employee Weekly Pay: $%.2f%n", weeklyPay);
                    }
                    catch (Exception e){
                        System.out.println("*** Error Calculating Weekly Pay ***");
                    }
                }
            }

            Field[] fields = employeeTypeClass.getDeclaredFields();
            for (Field field : fields){
                if(field.isAnnotationPresent(PayRate.class)){
                    try{
                        field.setAccessible(true);
                        Object payRate = field.get(employee);
                        System.out.printf("Employee Pay Rate: $%.2f%n", payRate, "\n");
                    }
                    catch (Exception e){
                        System.out.println("*** Error getting Pay Rate ***");
                    }
                }
            }
        }

        System.out.println("\nYou have " + numOfEmployee + " employee types ");


    }
}
