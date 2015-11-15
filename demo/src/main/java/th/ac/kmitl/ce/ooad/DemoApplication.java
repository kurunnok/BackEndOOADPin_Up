package th.ac.kmitl.ce.ooad;

import test2.HttpURLConnectionPicture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
        Connection connection = null;
        try {
            connection = ConnectionConfuguration.getConnection();
            if (connection != null) {
                System.out.println("Connection established");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
//        Date date = new Date();
//
//        date.setDate(12);
//        System.out.println(date.toString());
//
//        date.setHours(14);
//        date.setMinutes(56);
//        date.setMonth(10);
//        date.setYear(113);
//        date.setDate(1);
//        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
//        System.out.println(date.toString());
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
//
//        Calendar calendar = new GregorianCalendar(2013, 1, 28, 13, 24, 56);
//        System.out.println("#1. " + sdf.format(calendar.getTime()));
//
//        //update a date
//        calendar.set(Calendar.YEAR, 2014);
//        calendar.set(Calendar.MONTH, 11);
//        calendar.set(Calendar.MINUTE, 33);
//        System.out.println("#2. " + sdf.format(calendar.getTime()));
//
//
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
//        String datexx = "20150011";
//        String time="235734";
//        calendar.set(Calendar.YEAR, Integer.parseInt(datexx.substring(0, 4)));
//        calendar.set(Calendar.MONTH, Integer.parseInt(datexx.substring(4, 6)));
//        calendar.set(Calendar.DATE, Integer.parseInt(datexx.substring(6, 8)));
//        System.out.println("#3. " + sdf.format(calendar.getTime()));
//
//
//        int y=(Integer.parseInt(datexx.substring(0, 4))+544);
//        String yy= ""+y;
//        String tt=time.substring(0,2)+":"+time.substring(2,4)+":"+time.substring(4,6);
//        String xx = yy + "-" + datexx.substring(4, 6) + "-" + datexx.substring(6, 8)+" "+tt;
//        Date date1 = sdf2.parse(xx);
//
//        System.out.println("#4   " + date1.toString());

//        ScheduleController sc=new ScheduleController();
//        System.out.println(sc.checkSchedule(234,"20150220"));
       /*HttpURLConnectionPicture hp=new HttpURLConnectionPicture();
        try {
            hp.sendPost();
        } catch (Exception e) {
            e.printStackTrace();
        }*/


    }


}
