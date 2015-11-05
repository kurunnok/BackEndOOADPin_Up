package th.ac.kmitl.ce.ooad;

/**
 * Created by Administrator on 20/10/2558.
 */import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TopicHandler {
    private Connection conn;
    private Statement st;
    private ResultSet res;


    public  TopicHandler(){
        conn = ConnectionConfuguration.getConnection();
    }

    public ArrayList<Topic> getTopicAll(){

        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Topic topic = null;
        ArrayList<Topic> list= new ArrayList<>();

        if(conn == null){
            topic=new Topic("Connection Null","SQL");
            System.out.println("conn error");
            list.add(topic);
            return list;
        }
        if(st == null){
            topic=new Topic("State Null","SQL");
            list.add(topic);
            System.out.println("st error");
            return list;
        }
        try {
            res = st.executeQuery("SELECT * FROM topic ORDER by topicID DESC");
            if (res == null) {
                topic=new Topic("Not Found", "SQL?");
                System.out.println("rest error");
                list.add(topic);
                return list;
            }
            while (res.next()) {

                // if (res.next()) {
                Integer getTopicID = Integer.parseInt(res.getString(1));
                String title = res.getString(2);
                String startDate= res.getString(3);
                String startTime= res.getString(4);
                String endDate= res.getString(5);
                String endTime= res.getString(6);
                String location=res.getString(7);
                String description = res.getString(8);
                String type = res.getString(9);
                Double rate = Double.parseDouble(res.getString(10));
                String tag=res.getString(11);
                java.sql.Timestamp timestamp= res.getTimestamp(12);

                java.sql.Date dbSqlDate = res.getDate(3);
                java.util.Date startDate2 = new java.util.Date(dbSqlDate.getTime());
                java.sql.Time dbSqlTime = res.getTime(4);
                java.util.Date startTime2 = new java.util.Date(dbSqlTime.getTime());

                java.sql.Date dbSqlDate2 = res.getDate(5);
                java.util.Date endDate2 = new java.util.Date(dbSqlDate2.getTime());
                java.sql.Time dbSqlTime2 = res.getTime(6);
                java.util.Date endTime2 = new java.util.Date(dbSqlTime2.getTime());

                String getPhoto=res.getString(13);

                topic = new Topic(title,description,startDate2,startTime2,endDate2,endTime2,
                        location,tag,type,rate,startDate,endDate,timestamp,getTopicID,getPhoto);
              //  System.out.println(getTopicID + "  " + "title   " + title+" timestamp"+timestamp.toString());
              //  System.out.println(getTopicID + "  " + "title   " + title);
                list.add(topic);

                // }
            }
        }
        catch(Exception e){
            topic=new Topic(e.toString(), "SQL  it   I don't know");
            System.out.println(e.toString()+" error");
            list.add(topic);
        }


        return list;
    }

    public ArrayList<Topic> getTopicByType(String typeSelect){

        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Topic topic = null;
        ArrayList<Topic> list= new ArrayList<>();
        System.out.println(" error");
        if(conn == null){
            topic=new Topic("Connection Null","SQL");
            System.out.println("conn error");
            list.add(topic);
            return list;
        }
        if(st == null){
            topic=new Topic("State Null","SQL");
            list.add(topic);
            System.out.println("st error");
            return list;
        }
        try {
            res = st.executeQuery("SELECT * FROM topic WHERE type='"+typeSelect+"'");
            if (res == null) {
                topic=new Topic("Not Found", "SQL?");
                System.out.println("rest error");
                list.add(topic);
                return list;
            }
            while (res.next()) {

                // if (res.next()) {
                Integer getTopicID = Integer.parseInt(res.getString(1));
                String title = res.getString(2);
                String startDate= res.getString(3);
                String startTime= res.getString(4);
                String endDate= res.getString(5);
                String endTime= res.getString(6);
                String location=res.getString(7);
                String description = res.getString(8);
                String type = res.getString(9);
                Double rate = Double.parseDouble(res.getString(10));
                String tag=res.getString(11);
                java.sql.Timestamp timestamp= res.getTimestamp(12);

                java.sql.Date dbSqlDate = res.getDate(3);
                java.util.Date startDate2 = new java.util.Date(dbSqlDate.getTime());
                java.sql.Time dbSqlTime = res.getTime(4);
                java.util.Date startTime2 = new java.util.Date(dbSqlTime.getTime());

                java.sql.Date dbSqlDate2 = res.getDate(5);
                java.util.Date endDate2 = new java.util.Date(dbSqlDate.getTime());
                java.sql.Time dbSqlTime2 = res.getTime(6);
                java.util.Date endTime2 = new java.util.Date(dbSqlTime.getTime());

                String getPhoto=res.getString(13);

                topic = new Topic(title,description,startDate2,startTime2,endDate2,endTime2,
                        location,tag,type,rate,startDate,endDate,timestamp,getTopicID,getPhoto);

                list.add(topic);

                // }
            }
        }
        catch(Exception e){
            topic=new Topic(e.toString(), "SQL  it   I don't know");
            System.out.println(e.toString()+" error");
            list.add(topic);
        }

        return list;
    }

    public Topic getTopicByTopicID(int topicID){

        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Topic topic = null;
        if(conn == null){
            topic=new Topic("Connection Null","SQL",topicID);
            System.out.println("conn error");
            return topic;
        }
        if(st == null){
            topic=new Topic("State Null","SQL",topicID);
            System.out.println("st error");
            return topic;
        }
        try {
            res = st.executeQuery("SELECT * FROM topic WHERE topicID='"+topicID+"'");
            System.out.println("try but failed");
            if (res == null) {
                topic=new Topic("Not Found", "SQL?", topicID);
                System.out.println("rest error");
                return topic;
            }
            while (res.next()) {

                Integer getTopicID = Integer.parseInt(res.getString(1));
                String title = res.getString(2);
                String startDate= res.getString(3);
                String startTime= res.getString(4);
                String endDate= res.getString(5);
                String endTime= res.getString(6);
                String location=res.getString(7);
                String description = res.getString(8);
                String type = res.getString(9);
                Double rate = Double.parseDouble(res.getString(10));
                String tag=res.getString(11);
                java.sql.Timestamp timestamp= res.getTimestamp(12);

                java.sql.Date dbSqlDate = res.getDate(3);
                java.util.Date startDate2 = new java.util.Date(dbSqlDate.getTime());
                java.sql.Time dbSqlTime = res.getTime(4);
                java.util.Date startTime2 = new java.util.Date(dbSqlTime.getTime());

                java.sql.Date dbSqlDate2 = res.getDate(5);
                java.util.Date endDate2 = new java.util.Date(dbSqlDate2.getTime());
                java.sql.Time dbSqlTime2 = res.getTime(6);
                java.util.Date endTime2 = new java.util.Date(dbSqlTime2.getTime());

                String getPhoto=res.getString(13);

                topic = new Topic(title,description,startDate2,startTime2,endDate2,endTime2,
                        location,tag,type,rate,startDate,endDate,timestamp,getTopicID,getPhoto);
              //  System.out.println(getTopicID + "  " + "title   " + title + " timestamp" + timestamp.toString());

                // }
            }
        }
        catch(Exception e){
            topic=new Topic(e.toString(), "SQL  it   I don't know", topicID);
            System.out.println(e.toString()+" error");
        }

        return topic;
    }

    public String storeTopic(String title,String startDate,String startTime,String endDate,String endTime
            ,String location,String description,String type,String rate,String tag,String photo){
        System.out.println("Create Topic start");
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
                String query2="INSERT INTO topic( title, startDate, startTime, endDate, endTime, location, description, type, rate, tag, photo)" +
                        " VALUES ('"+title+"','"+startDate+"','"+startTime+"','"+endDate+"','"+endTime+"','"+location+"','"+description+"','"+type+"','"+rate+"','"+tag+"','"+photo+"')";
                st.executeUpdate(query2);
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




}
