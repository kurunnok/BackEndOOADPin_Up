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

    public ScheduleHandler(){
        conn = ConnectionConfuguration.getConnection();
    }

    public ArrayList<SubSchedule> getScheduleByAccountID(int accountID){

        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        SubSchedule subSchedule;
        ArrayList<SubSchedule> list= new ArrayList<>();
        //System.out.println(" error");
        if(conn == null){
            subSchedule=new SubSchedule("Connection Null","SQL");
            System.out.println("conn error");
            list.add(subSchedule);
            return list;
        }
        if(st == null){
            subSchedule=new SubSchedule("State Null","SQL");
            list.add(subSchedule);
            System.out.println("st error");
            return list;
        }
        try {
            res = st.executeQuery("SELECT * FROM schedule WHERE accountID='"+accountID+"'");
            if (res == null) {
                subSchedule=new SubSchedule("Not Found", "SQL?");
                System.out.println("rest error");
                list.add(subSchedule);
                return list;
            }
            while (res.next()) {

                    // if (res.next()) {
                    Integer getScheduleID = Integer.parseInt(res.getString(1));
                    Integer getAccountID = Integer.parseInt(res.getString(2));
                    java.sql.Date dbSqlDate = res.getDate(3);
                    java.util.Date date2 = new java.util.Date(dbSqlDate.getTime());

                   subSchedule=new SubSchedule(getScheduleID,getAccountID,date2);



                   // System.out.println();
                  //  System.out.println("yahoo");
                    list.add(subSchedule);

                    // }
            }
        }
        catch(Exception e){
            subSchedule=new SubSchedule(e.toString(), "SQL  it   I don't know");
            System.out.println(e.toString()+" error");
        }

        return list;
    }

    public ArrayList<Pin> getPinByScheduleID(int scheduleID){

        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Pin pin= null;
        ArrayList<Pin> list= new ArrayList<>();
        System.out.println(" error");
        if(conn == null){
            pin=new Pin("Connection Null","SQL");
            System.out.println("conn error");
            list.add(pin);
            return list;
        }
        if(st == null){
            pin=new Pin("State Null","SQL");
            list.add(pin);
            System.out.println("st error");
            return list;
        }
        try {
            res = st.executeQuery("SELECT * FROM pin WHERE scheduleID='"+scheduleID+"'");
            if (res == null) {
                pin=new Pin("Not Found", "SQL?");
                System.out.println("rest error");
                list.add(pin);
                return list;
            }
            while (res.next()) {

                // if (res.next()) {
                Integer getPinID=Integer.parseInt(res.getString(1));
                Integer getScheduleID = Integer.parseInt(res.getString(2));
                Integer getTopicID = Integer.parseInt(res.getString(3));

               pin=new Pin(getPinID,getScheduleID,getTopicID);



                System.out.println();
                System.out.println();
                list.add(pin);

                // }
            }
        }
        catch(Exception e){
            pin=new Pin(e.toString(), "SQL  it   I don't know");
            System.out.println(e.toString()+" error");
        }

        return list;
    }

    public ArrayList<Pin> getPinAll(){

        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Pin pin= null;
        ArrayList<Pin> list= new ArrayList<>();
      //  System.out.println(" error");
        if(conn == null){
            pin=new Pin("Connection Null","SQL");
            System.out.println("conn error");
            list.add(pin);
            return list;
        }
        if(st == null){
            pin=new Pin("State Null","SQL");
            list.add(pin);
            System.out.println("st error");
            return list;
        }
        try {
            res = st.executeQuery("SELECT * FROM pin ");
            if (res == null) {
                pin=new Pin("Not Found", "SQL?");
                System.out.println("rest error");
                list.add(pin);
                return list;
            }
            while (res.next()) {

                // if (res.next()) {
                Integer getPinID=Integer.parseInt(res.getString(1));
                Integer getScheduleID = Integer.parseInt(res.getString(2));
                Integer getTopicID = Integer.parseInt(res.getString(3));

                pin=new Pin(getPinID,getScheduleID,getTopicID);



              //  System.out.println("pin yahoo all" );
               // System.out.println();
                list.add(pin);

                // }
            }
        }
        catch(Exception e){
            pin=new Pin(e.toString(), "SQL  it   I don't know");
            System.out.println(e.toString()+" error");
            list.add(pin);
        }

        return list;
    }

    public SubSchedule storeSchedule(int accountID,String  datetime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");

        //Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);

        System.out.println("Create Schedule start");
        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        String check=null;
        if(conn==null){
            System.out.println("Connection failed ");
            check= "connection failed";
        }
        else{
            try{
               String query ="INSERT INTO schedule(accountID, date) VALUES ('"+accountID+"','"+datetime+"')";
                st.executeUpdate(query);
                System.out.println("Inserted records into the table...");
                check= "Inserted records into the table...";

            }catch (Exception e){
                System.out.println(e.toString());
                check= e.toString();
            }
        }
        System.out.println("create success");

        //return current subSchedule for get scheduleID
        return getOneSchedule(accountID,datetime);
    }

    public String storePin(int scheduleID,int topicID,String datetime,String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");

       // Calendar calendar = new GregorianCalendar(Integer.parseInt(datetime.substring(0, 5)),Integer.parseInt(datetime.substring(5,7)),
         //       Integer.parseInt(datetime.substring(7,9)),Integer.parseInt(time.substring(0,2)),Integer.parseInt(time.substring(2,4)),
           //     Integer.parseInt(time.substring(4,6)));

        //System.out.println("calendar     "+calendar.toString());
        System.out.println("Create Schedule start");
        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        String check=null;
        if(conn==null){
            System.out.println("Connection failed ");
            check= "connection failed";
        }
        else{
            try{
                String query ="INSERT INTO pin(scheduleID, topicID,datetime) VALUES ('"+scheduleID+"','"+topicID+"','"+datetime+"')";
                st.executeUpdate(query);
                System.out.println("Inserted records into the table...");
                check= "Inserted records into the table...";

            }catch (Exception e){
                System.out.println(e.toString());
                check= e.toString();
            }
        }

        System.out.println("create success");


        return check;
    }

    public SubSchedule getOneSchedule(int accountID,String date){

        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        SubSchedule subSchedule=null;
        ArrayList<SubSchedule> list= new ArrayList<>();
        //System.out.println(" error");
        if(conn == null){
            subSchedule=new SubSchedule("Connection Null","SQL");
            System.out.println("conn error");
            list.add(subSchedule);
            return subSchedule;
        }
        if(st == null){
            subSchedule=new SubSchedule("State Null","SQL");
            list.add(subSchedule);
            System.out.println("st error");
            return subSchedule;
        }
        try {
            res = st.executeQuery("SELECT * FROM schedule WHERE accountID='"+accountID+"' AND date='"+date+"'");
            if (res == null) {
                subSchedule=new SubSchedule("Not Found", "SQL?");
                System.out.println("rest error");
                list.add(subSchedule);
                return subSchedule;
            }
            while (res.next()) {

                // if (res.next()) {
                Integer getScheduleID = Integer.parseInt(res.getString(1));
                Integer getAccountID = Integer.parseInt(res.getString(2));
                java.sql.Date dbSqlDate = res.getDate(3);
                java.util.Date date2 = new java.util.Date(dbSqlDate.getTime());

                subSchedule=new SubSchedule(getScheduleID,getAccountID,date2);

               // System.out.println();
               // System.out.println("yahoo");

                // }
            }
        }
        catch(Exception e){
            subSchedule=new SubSchedule(e.toString(), "SQL  it   I don't know");
            System.out.println(e.toString()+" error");
        }

        return subSchedule;
    }


}
