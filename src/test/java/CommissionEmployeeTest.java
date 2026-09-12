import EmployeeObjects.CommissionEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommissionEmployeeTest {

    CommissionEmployee emp = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", 0.0265);

    @Test
    void testIncreaseSales(){
        emp.increaseSales(1250);

        assertEquals(1250, emp.getSales());
    }

    @Test
    void testHolidayBonus(){
        emp.holidayBonus();

        assertEquals(0, emp.getSales());
    }

    @Test
    void testAnnualRaise(){
        emp.annualRaise();
        emp.annualRaise();

        assertEquals(0.0305, emp.getRate());
    }
}
