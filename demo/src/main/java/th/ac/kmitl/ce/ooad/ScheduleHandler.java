package th.ac.kmitl.ce.ooad;

/**
 * Created by Administrator on 24/10/2558.
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

public class ScheduleHandler {
    private Connection conn;
    private Statement st;
    private ResultSet res;

    public ScheduleHandler() {

    }

    public ArrayList<Pin> getPinByAccountIDAndDate(int accountID, String date) {

        conn = ConnectionConfuguration.getConnection();
        try {
            st = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Pin pin = null;
        ArrayList<Pin> list = new ArrayList<>();
        //  System.out.println(" error");
        if (conn == null) {
            pin = new Pin("Connection Null", "SQL");
            System.out.println("conn error");
            list.add(pin);
            closeConnection();
            return list;
        }
        if (st == null) {
            pin = new Pin("State Null", "SQL");
            list.add(pin);
            System.out.println("st error");
            closeConnection();
            return list;
        }
        try {

            res = st.executeQuery("SELECT * FROM pin WHERE datetime>='" + date + " 00:00:00' AND datetime<='" + date + " 23:59:59' AND accountID='" + accountID + "'");
            if (res == null) {
                pin = new Pin("Not Found", "SQL?");
                System.out.println("rest error");
                list.add(pin);
                closeConnection();
                return list;
            }
            while (res.next()) {

                // if (res.next()) {
                Integer getPinID = Integer.parseInt(res.getString(1));
                Integer getScheduleID = Integer.parseInt(res.getString(2));
                Integer getTopicID = Integer.parseInt(res.getString(3));

                java.sql.Date dbSqlDate = res.getDate(4);
                java.util.Date getdatetime = new java.util.Date(dbSqlDate.getTime());

                Integer getAccountID = Integer.parseInt(res.getString(6));

                pin = new Pin(getPinID, getScheduleID, getTopicID, getdatetime, getAccountID);

                list.add(pin);
            }
        } catch (Exception e) {
            pin = new Pin(e.toString(), "SQL  it   I don't know");
            System.out.println(e.toString() + " error");
            list.add(pin);
        }
        closeConnection();
        return list;
    }


    public String storePin(int accountID, int topicID, String date, String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        conn = ConnectionConfuguration.getConnection();

        // Calendar calendar = new GregorianCalendar(Integer.parseInt(datetime.substring(0, 5)),Integer.parseInt(datetime.substring(5,7)),
        //       Integer.parseInt(datetime.substring(7,9)),Integer.parseInt(time.substring(0,2)),Integer.parseInt(time.substring(2,4)),
        //     Integer.parseInt(time.substring(4,6)));

        //System.out.println("calendar     "+calendar.toString());
        String xx = "2015-11-08 19:39:00";
        String xy = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8) + " " + time;

        System.out.println("Create Schedule start");
        try {
            st = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String check = null;
        if (conn == null) {
            System.out.println("Connection failed ");
            check = "connection failed";
        } else {
            try {
                String query = "INSERT INTO pin(scheduleID,topicID,datetime,accountID) VALUES ('111','" + topicID + "','" + xy + "','" + accountID + "')";
                st.executeUpdate(query);
                System.out.println("Inserted records into the table...");
                check = "Inserted records into the table...";

            } catch (Exception e) {
                System.out.println(e.toString());
                check = e.toString();
            }
        }

        System.out.println("create success");

        closeConnection();
        return check;
    }

    public String deletePin(int accountID, int topicID) {
        conn = ConnectionConfuguration.getConnection();
        try {
            st = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String check = null;
        if (conn == null) {
            System.out.println("Connection failed ");
            check = "connection failed";
        } else {
            try {
                String query = "DELETE FROM pin WHERE accountID='" + accountID + "' AND topicID='" + topicID + "'";
                st.executeUpdate(query);
                System.out.println("Delete pin complete ...");
                check = "Delete pin complete ...";

            } catch (Exception e) {
                System.out.println(e.toString());
                check = e.toString();
            }
        }
        System.out.println("Delete pin  success");
        closeConnection();
        return check;
    }


    public ArrayList<Pin> getPinAllByAccountID(int accountID) {

        conn = ConnectionConfuguration.getConnection();
        try {
            st = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Pin pin = null;
        ArrayList<Pin> list = new ArrayList<>();
        //  System.out.println(" error");
        if (conn == null) {
            pin = new Pin("Connection Null", "SQL");
            System.out.println("conn error");
            list.add(pin);
            closeConnection();
            return list;
        }
        if (st == null) {
            pin = new Pin("State Null", "SQL");
            list.add(pin);
            System.out.println("st error");
            closeConnection();
            return list;
        }
        try {

            res = st.executeQuery("SELECT * FROM pin WHERE accountID='"+accountID+"'");
            if (res == null) {
                pin = new Pin("Not Found", "SQL?");
                System.out.println("rest error");
                list.add(pin);
                closeConnection();
                return list;
            }
            while (res.next()) {

                // if (res.next()) {
                Integer getPinID = Integer.parseInt(res.getString(1));
                Integer getScheduleID = Integer.parseInt(res.getString(2));
                Integer getTopicID = Integer.parseInt(res.getString(3));

                java.sql.Timestamp dbSqlDate = res.getTimestamp(4);
                java.util.Date getdatetime = new java.util.Date(dbSqlDate.getTime());

                Integer getAccountID = Integer.parseInt(res.getString(6));

                pin = new Pin(getPinID, getScheduleID, getTopicID, getdatetime, getAccountID);

                list.add(pin);
            }
        } catch (Exception e) {
            pin = new Pin(e.toString(), "SQL  it   I don't know");
            System.out.println(e.toString() + " error");
            list.add(pin);
        }
        closeConnection();
        return list;
    }

    public ArrayList<Pin> getPinAll() {

        conn = ConnectionConfuguration.getConnection();
        try {
            st = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Pin pin = null;
        ArrayList<Pin> list = new ArrayList<>();
        //  System.out.println(" error");
        if (conn == null) {
            pin = new Pin("Connection Null", "SQL");
            System.out.println("conn error");
            list.add(pin);
            closeConnection();
            return list;
        }
        if (st == null) {
            pin = new Pin("State Null", "SQL");
            list.add(pin);
            System.out.println("st error");
            closeConnection();
            return list;
        }
        try {

            res = st.executeQuery("SELECT * FROM pin ");
            if (res == null) {
                pin = new Pin("Not Found", "SQL?");
                System.out.println("rest error");
                list.add(pin);
                closeConnection();
                return list;
            }
            while (res.next()) {

                // if (res.next()) {
                Integer getPinID = Integer.parseInt(res.getString(1));
                Integer getScheduleID = Integer.parseInt(res.getString(2));
                Integer getTopicID = Integer.parseInt(res.getString(3));

                java.sql.Timestamp dbSqlDate = res.getTimestamp(4);
                java.util.Date getdatetime = new java.util.Date(dbSqlDate.getTime());

                Integer getAccountID = Integer.parseInt(res.getString(6));

                pin = new Pin(getPinID, getScheduleID, getTopicID, getdatetime, getAccountID);

                list.add(pin);
            }
        } catch (Exception e) {
            pin = new Pin(e.toString(), "SQL  it   I don't know");
            System.out.println(e.toString() + " error");
            list.add(pin);
        }
        closeConnection();
        return list;
    }
    public  void closeConnection(){
        try{
            conn.close();
            conn=null;
        }catch (Exception  e){

        }
    }



}