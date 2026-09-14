import EmployeeObjects.SalaryEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryEmployeeTest {
    SalaryEmployee emp = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);

    @Test
    void testCalculateWeeklyPayOfSalaryEmplooyee() {
        double weeklyPay = emp.calculateWeeklyPay();

        assertEquals(1237.02, weeklyPay);
    }

    @Test
    void testHolidayBonus(){
        double holidayBonus = emp.holidayBonus();

        assertEquals(2164.54, holidayBonus, 0.01);
    }
}
