import main.Employee;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

  public class EmployeeTest {
    @Test
   public void testGetEmpNo() {
   Employee E = new Employee(23,"kate","chen",35.0);
    assertEquals(23,E.getEmpNo());
    }
    @Test
    public void testSetEmpNo() {
        Employee E = new Employee(38,"John","Ji",26.0);
       E.setEmpNo(29);
       assertEquals(29,E.getEmpNo());
    }
    @Test
   public void testGetFirstName() {
        Employee E = new Employee(9,"Mid","Alice",19.0);
        assertEquals("Alice",E.getFirstName());
    }
    @Test
    public void testSetFirstName() {
        Employee E = new Employee(23,"Ros","Zhang",8.0);
        E.setFirstName("Rose");
        assertEquals("Rose",E.getFirstName());
    }
    @Test
   public void testGetLastName() {
        Employee E = new Employee(8,"Lin","li",23.00);
        assertEquals("Lin",E.getLastName());
    }
    @Test
    public void testSetLastName() {
        Employee E = new Employee(5,"Ciel","chen",19.0);
        E.setFirstName("Ciel");
        assertEquals("Ciel",E.getLastName());
    }
    @Test
   public void testGetHourRate() {
        Employee E = new Employee(14,"Li","David",27.0);
        assertEquals(27.0,E.getHourRate());
    }
    @Test
   public void testSetHourRate() {
        Employee E = new Employee(6,"Yang","Yun",20.0);
        E.setHourRate(18);
        assertEquals(18,E.getHourRate());
    }

    @Test
    public void testGetTimeWorked() {
        Employee E = new Employee(14,"Li","David",27.0);
        assertEquals(0,E.getTimeWorked());
    }
    @Test
    public void testSetTimeWorked() {
        Employee E = new Employee(6, "Yang", "Yun", 20.0);
        E.setTimeWorked(18);
        assertEquals(18, E.getTimeWorked());
    }


    }

