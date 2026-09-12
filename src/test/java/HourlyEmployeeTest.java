import EmployeeObjects.HourlyEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourlyEmployeeTest {

    @Test
    void testIncreaseHours(){
        HourlyEmployee emp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);

        //create objects
        emp.increaseHours(5);
        assertEquals(5, emp.getHoursWorked());
    }

    @Test
    void testAnnualRise(){
        HourlyEmployee emp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);

        emp.annualRaise();

        assertEquals(34.49, emp.getWage());
    }

    @Test
    void testCalculateWeeklyPayAt40Hours (){
        HourlyEmployee emp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);

        emp.increaseHours(45);
        double weeklyPay = emp.calculateWeeklyPay();

        assertEquals(1560.38, weeklyPay, 0.01);
    }
}
