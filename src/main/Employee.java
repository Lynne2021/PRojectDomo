package main;
/**
 *  Employees personal data in java.ca.
 *
 * @author Honglin, XiaomingSu
 * @version 1.0
 * @since 2021-7-10
 */
public class Employee {
    private int empNo;
    private String firstName;
    private String lastName;
    private double hourRate;
    private double timeWorked;  //save total hours

    public Employee() {
        super();
    }
    public Employee(int empNo, String lastName, String firstName, double hourRate) {
        super();
        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourRate = hourRate;
    }
    public int getEmpNo() {
        return empNo;
    }
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public double getHourRate() {
        return hourRate;
    }
    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }
    public double getTimeWorked() {
        return timeWorked;
    }
    public void setTimeWorked(double timeWorked) {
        this.timeWorked = timeWorked;
    }
    /**
     * @return String:get the time type.
     */
    //convert worked time to HH:MM:SS type.
    public String getFormatTimeWorked() {
        StringBuilder sb = new StringBuilder();
        int hours = (int) timeWorked;
        int minutes = (int)((timeWorked - hours)*60);
        sb.append(hours).append(":")
                .append(minutes).append(":00");
        return sb.toString();
    }
    @Override
    public String toString() {
        return "Employee [empNo=" + empNo + ", firstName=" + firstName + ", lastName=" + lastName + ", hourRate="
                + hourRate + "]";
    }
}


