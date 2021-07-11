package main;
import java.util.Comparator;
/**
 *  Implementation the compare  by import util.java.comparator in java.class
 *
 * @author HongLin XiaomingSu
 * @version 1.0
 * @since 2021-07-10
 */
public class Comparators {
    /**
     * Creat 4 new different objects instances (Number,Name,TIme,Pay)for Compare.
     * get all objects' compare data.
     */
    //Creat new Object for compare employee number.
    public static Comparator<Employee> NUMBER = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getEmpNo() - o2.getEmpNo();
        }
    };
    //Creat new Object for compare employee name.
    public static Comparator<Employee> NAME = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    };
    //Creat new Object for compare employee worked time.
    public static Comparator<Employee> TIME = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (int)(o2.getTimeWorked() - o1.getTimeWorked());
        }
    };
    //Creat new Object for compare employee pay.
    // pay = employee hourRate * worked time.
    public static Comparator<Employee> PAY = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (int)(o1.getHourRate()*o1.getTimeWorked()-
                    o2.getHourRate()*o2.getTimeWorked());
        }
    };

}


