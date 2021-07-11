package main;

import java.io.*;
/**
 * A Binary Class to read and write Binary files in java.class
 *
 * @author HongLin, XiaomingSu
 * @version 1.0
 * @since 2021-07-10
 */
public class BinaryOper {
        public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
            TimeStamp timeStamp = new TimeStamp(1234,"21:03:21");
            FileOutputStream fos = new FileOutputStream("temp.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(timeStamp);
            oos.close();

            FileInputStream fstream = new FileInputStream("temp.data");
            ObjectInputStream ostream = new ObjectInputStream(fstream);
            TimeStamp outputStamp = (TimeStamp)ostream.readObject();//cast to TimeStamp
            System.out.println(outputStamp.toString());
            fstream.close();
        }
}
