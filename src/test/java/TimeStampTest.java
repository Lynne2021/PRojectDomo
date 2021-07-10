import static org.junit.jupiter.api.Assertions.*;
import main.TimeStamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


   public class TimeStampTest {
        TimeStamp timeStamp;
        @BeforeEach
       public void setUp() throws Exception {
            timeStamp = new TimeStamp(2745, "05:23:00");
        }
        @Test
        public void testTimeStampIntString() {
            assertTrue(timeStamp.getEmpNo()==2745);
        }
        @Test
       public void testGetEmpNo() {
            assertTrue(timeStamp.getEmpNo()==2745);
        }
        @Test
        public void testSetEmpNo() {
            timeStamp.setEmpNo(1234);
            assertTrue(timeStamp.getEmpNo()==1234);
            timeStamp.setEmpNo(2745);
        }
        @Test
        public void testGetTimeStamp() {

            assertTrue(timeStamp.getTimeStamp().equalsIgnoreCase("05:23:00"));
        }
        @Test
        public void testSetTimeStamp() {
            timeStamp.setTimeStamp("04:21:00");
            assertTrue(timeStamp.getTimeStamp().equalsIgnoreCase("04:21:00"));
            timeStamp.setTimeStamp("05:23:00");
        }
        @Test
        public void testToString(){
            assertEquals("TimeStamp [empNo=2745, timeStamp=05:23:00]",timeStamp.toString());
            TimeStamp ts = new TimeStamp();
            ts.setEmpNo(1234);
            ts.setTimeStamp("01:02:03");
            assertEquals("TimeStamp [empNo=1234, timeStamp=01:02:03]",ts.toString());
        }
    }



