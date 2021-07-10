package main;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * A test class what test the result for all classes in java.ca
 *
 * @author Hong lin, Xiaoming Su
 * @version 1.0
 * @since 2021-07-10
 */
    public class EmployeeManagement {
        /**
         * @param args
         * Print out Menu
         */
        public static void main(String[] args) {

            ArrayList<Employee> empList = new ArrayList<Employee>();
            generateEmployeeListFromFile(empList, "./data/employees.txt");
            processTimeWorkedFile(empList, "./data/employeesHours.txt");
            //create menu
            Scanner choose = new Scanner(System.in);
            while(true) {
                System.out.println("======please input================\n0 exit \n1 employeeNumberOrder\n2 nameOrder\n3 timeOrder\n4 payOrder\n=====================");
                String choice = choose.next();
                if("0".equalsIgnoreCase(choice)) {
                    break;
                }else if("1".equalsIgnoreCase(choice)) {
                    empList.sort(Comparators.NUMBER);
                    printReport(empList, "./output/employeeNumberOrder.txt");
                }else if("2".equalsIgnoreCase(choice)) {
                    empList.sort(Comparators.NAME);
                    printReport(empList, "./output/nameOrder.txt");
                }else if("3".equalsIgnoreCase(choice)) {
                    empList.sort(Comparators.TIME);
                    printReport(empList, "./output/timeOrder.txt");
                }else if("4".equalsIgnoreCase(choice)) {
                    empList.sort(Comparators.PAY);
                    printReport(empList, "./output/payOrder.txt");
                }
            }
            choose.close();
            System.out.println("=====done====");
        }

        /**
         * read data from employee.txt one by one;
         * split one line and initialize Employee object;
         * add employee object to list
         *
         * @param employeeList ArrayList
         * @param fileName String
         * @return boolean
         *
         * */
        public static boolean generateEmployeeListFromFile(ArrayList employeeList, String fileName) {
            //read data from employees.txt and employeesHours.txt
            //fetch data and convert into list;
            try {
                //create file object and scanner object for two files
                File empFile = new File(fileName);
                Scanner empTextRead = new Scanner(empFile);
                //read data from file, fetch line one by one and write to list
                while (empTextRead.hasNext()) {
                    String empStr = (String)empTextRead.next();
                    //split string by comma and convert into Array
                    String[] empArray = empStr.split(",");
                    Employee employee = new Employee(Integer.parseInt(empArray[0]), empArray[1],empArray[2],Double.parseDouble(empArray[3]));
                    employeeList.add(employee);
                }
                //close scanner
                empTextRead.close();
                return true;
            } catch (IOException e) {
                System.out.println("IOException occurs in generateEmployeeListFromFile");
                return false;
            }
        }
        /**
         * add time worked into employee list by employee no.
         *
         * @param employeeList ArrayList
         * @param fileName String
         * @return boolean
         *
         * */
        public static boolean processTimeWorkedFile(ArrayList employeeList, String fileName) {
            try {
                File hoursFile = new File(fileName);
                Scanner hoursTextRead = new Scanner(hoursFile);
                while (hoursTextRead.hasNext()) {
                    String hoursStr = (String)hoursTextRead.next();
                    //split string by comma and convert into Array
                    String[] hoursArray = hoursStr.split(",");
                    TimeStamp timeStamp = new TimeStamp(Integer.parseInt(hoursArray[0]), hoursArray[1]);
                    addTimeWorkedToEmployee(employeeList,Integer.parseInt(hoursArray[0]), timeStamp);
                }
                //close scanner
                hoursTextRead.close();
                return true;
            } catch (IOException e) {
                System.out.println("IOException occurs in processTimeWorkedFile");
                return false;
            }
        }
        /**
         * write details in employee into console and specified txt file
         *
         * @param employeeList ArrayList
         * @param fileName String
         * @return boolean
         *
         * */
        public static boolean printReport(ArrayList employeeList, String fileName) {
            try {
                File file = new File(fileName);
                PrintWriter writer = new PrintWriter(file);
                writer.println("Emp# LastName FirstName TimeWorked Hourly Wage Pay");
                System.out.println("Emp# LastName FirstName TimeWorked Hourly Wage Pay");
                double totalTime = (double)0.0, totalPay = (double)0.0;
                for (Object obj:employeeList) {
                    Employee employee = (Employee)obj;
                    double pay = employee.getHourRate()*employee.getTimeWorked();
                    System.out.println(employee.getEmpNo() + " "
                            + employee.getLastName() + " "
                            + employee.getFirstName() + " "
                            + employee.getFormatTimeWorked()+ " "
                            + "$"+employee.getHourRate() + " "
                            + "$"+Math.round(pay*100.0)/100.0);
                    writer.println(employee.getEmpNo() + " "
                            + employee.getLastName() + " "
                            + employee.getFirstName() + " "
                            + employee.getFormatTimeWorked()+ " "
                            + "$"+employee.getHourRate() + " "
                            + "$"+Math.round(pay*100.0)/100.0);
                    totalTime+=employee.getTimeWorked();
                    totalPay+=pay;
                }
                System.out.println();
                System.out.println();
                System.out.println("Total time worked:"+getFormatTotalTime(totalTime));
                System.out.println("Total pay: $"+Math.round(totalPay*100.0)/100.0);
                writer.println();
                writer.println();
                writer.println("Total time worked:"+getFormatTotalTime(totalTime));
                writer.println("Total pay: $"+Math.round(totalPay*100.0)/100.0);
                writer.close();

            } catch (IOException e) {
                System.out.println(e);
            }
            return true;
        }
        /**
         * add time worked into employee
         *
         * @param employeeList ArrayList
         * @param employeeNumber int
         * @param timeWorked TimeStamp
         * @return boolean
         *
         * */
        public static boolean addTimeWorkedToEmployee(ArrayList<Employee> employeeList, int employeeNumber,
                                                      TimeStamp timeWorked) {
            String[] arr = timeWorked.getTimeStamp().split(":");
            int seconds = Integer.parseInt(arr[0])* 60 * 60 + Integer.parseInt(arr[1])* 60 + Integer.parseInt(arr[2]);
            double hours = (double)seconds/(60*60);
            for(Employee employee: employeeList) {
                if (employee.getEmpNo() == employeeNumber) {
                    employee.setTimeWorked(employee.getTimeWorked() + hours);
                }
            }
            return true;
        }
        /**
         * output formatted hour:minutes:seconds
         *
         * @param totalTime double
         * @return String
         *
         * */
        private static String getFormatTotalTime(double totalTime) {
            StringBuilder sb = new StringBuilder();
            int hours = (int) totalTime;
            int minutes = (int)((totalTime - hours)*60);
            sb.append(hours).append(":")
                    .append(minutes).append(":00");
            return sb.toString();

        }
    }

