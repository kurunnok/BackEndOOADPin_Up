package th.ac.kmitl.ce.ooad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Administrator on 9/11/2558.
 */

public class CommentHandler {
    private Connection conn;
    private Statement st;
    private ResultSet res;

    public CommentHandler() {

    }

    public ArrayList<Comment> getCommentAllByTopicID(int topicID) {
        conn = ConnectionConfuguration.getConnection();
        try {
            st = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Comment comment = null;
        ArrayList<Comment> list = new ArrayList<>();

        if (conn == null) {
            //comment = new Comment("Connection SQL Null");
            //System.out.println("conn error");
            //list.add(comment);
            //return list;
            conn = ConnectionConfuguration.getConnection();
        }
        if (st == null) {
            comment = new Comment("State SQL Null");
            list.add(comment);
            System.out.println("st error");
            conn = ConnectionConfuguration.getConnection();
            closeConnection();
           return list;
        }
        try {
            res = st.executeQuery("SELECT * FROM comment WHERE topicID='"+topicID+"'");
            if (res == null) {
                comment = new Comment(" SQL Not Found");
                System.out.println("rest error");
                list.add(comment);
                conn.close();
                return list;
            }
            while (res.next()) {
                int getCommentID = res.getInt(1);
                String getDesc=res.getString(2);
                int accountID=res.getInt(3);

                comment=new Comment(getCommentID,getDesc,new Account(accountID));
                list.add(comment);
            }
            conn.close();
        } catch (Exception e) {
            comment = new Comment(e.toString() + "SQL  it   I don't know");
            System.out.println(e.toString() + " error");
            list.add(comment);
        }
        closeConnection();
        return list;
    }

    public String storeComment(String desc,int accountID , int topicID) {
        conn = ConnectionConfuguration.getConnection();
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
                String query ="INSERT INTO comment(description,accountID, topicID) VALUES ('"+desc+"','"+accountID+"','"+topicID+"')";
                st.executeUpdate(query);
                System.out.println("Inserted records into the table...");
                check= "Inserted records into the table...";

            }catch (Exception e){
                System.out.println(e.toString());
                check= e.toString();
            }
        }
        System.out.println("create success");

        closeConnection();
        return check;
    }

    public String deleteComment(int  accountID , int commentID) {
        conn = ConnectionConfuguration.getConnection();
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
                String query ="DELETE FROM comment WHERE accountID='"+accountID+"' AND commentID='"+commentID+"'";
                st.executeUpdate(query);
                System.out.println("Delete comment complete ...");
                check= "Delete comment complete ...";

            }catch (Exception e){
                System.out.println(e.toString());
                check= e.toString();
            }
        }
        System.out.println("Delete comment  success");

        closeConnection();
        return check;
    }

    public  void closeConnection(){
        try{
            conn.close();
            conn=null;
        }catch (Exception  e){

        }
    }
}
