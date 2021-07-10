package main;

/**
 * A time stamp for time data in java.ca
 *
 * @author HongLIn  XiaomingSu
 * @version 1.0
 * @since 2021-07-10
 */
public class TimeStamp {
    private int empNo;
    private String timeStamp;
    public TimeStamp() {
        super();
    }
    public TimeStamp(int empNo, String timeStamp) {
        super();
        this.empNo = empNo;
        this.timeStamp = timeStamp;
    }
    public int getEmpNo() {
        return empNo;
    }
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
    public String getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    @Override
    public String toString() {
        return "TimeStamp [empNo=" + empNo + ", timeStamp=" + timeStamp + "]";
    }
}



