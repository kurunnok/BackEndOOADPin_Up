package th.ac.kmitl.ce.ooad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Administrator on 10/11/2558.
 */
public class AccountHandler {
    private Connection conn;
    private Statement st;
    private ResultSet res;

    public AccountHandler(){

    }

    public Account getAccountByfbID(String fbID){
        conn = ConnectionConfuguration.getConnection();
        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Account account=null;
        if(conn == null){
            account=new Account("Connection Null SQL");
            System.out.println("conn error");
            closeConnection();
            return account;
        }
        if(st == null){
            account=new Account("State Null SQL");
            System.out.println("st error");
            closeConnection();
            return account;
        }
        try {
            res = st.executeQuery("SELECT * FROM account WHERE fbID='"+fbID+"'");
            if (res == null) {
                account=new Account("Not Found SQL");
                System.out.println("rest error");
                closeConnection();
                return account;
            }
            while (res.next()) {
                Integer getAccountID=Integer.parseInt(res.getString(1));
                String getName =res.getString(2);
                String getFbID=res.getString(4);
                account=new Account(getAccountID,getName,getFbID);
            }
        }
        catch(Exception e){
            account=new Account(e.toString()+"SQL  it   I don't know");
            System.out.println(e.toString() + " error");
        }
        closeConnection();
        return account;
    }

    public String storeAccount(String name,String fbID){
        conn = ConnectionConfuguration.getConnection();
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
                String query ="INSERT INTO account(name,fbID) VALUES ('"+name+"','"+fbID+"')";
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

    public String deleteAccount(String  fbID ) {
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
                String query ="DELETE FROM account WHERE fbID='"+fbID+"'";
                st.executeUpdate(query);
                System.out.println("Delete account complete ...");
                check= "Delete account complete ...";

            }catch (Exception e){
                System.out.println(e.toString());
                check= e.toString();
            }
        }
        System.out.println("Delete account  success");
        closeConnection();
        return check;
    }


    public ArrayList<Account> getAccountAll(){
        conn = ConnectionConfuguration.getConnection();
        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Account account = null;
        ArrayList<Account> list= new ArrayList<>();

        if(conn == null){
            account=new Account("Connection Null"+"SQL");
            System.out.println("conn error");
            list.add(account);
            closeConnection();
            return list;
        }
        if(st == null){
            account=new Account("State Null"+"SQL");
            list.add(account);
            System.out.println("st error");
            closeConnection();
            return list;
        }
        try {
            res = st.executeQuery("SELECT * FROM account ORDER by accountID DESC");
            if (res == null) {
                account=new Account("Not Found"+ "SQL?");
                System.out.println("rest error");
                list.add(account);
                closeConnection();
                return list;
            }
            while (res.next()) {
                Integer getAccountID=Integer.parseInt(res.getString(1));
                String getName=res.getString(2);
                String fbID=res.getString(4);
                account=new Account(getAccountID,getName,fbID);
                list.add(account);

                // }
            }
        }
        catch(Exception e){
            account=new Account(e.toString()+ "SQL  it   I don't know");
            System.out.println(e.toString()+" error");
            list.add(account);
        }

        closeConnection();
        return list;
    }

    public Account getAccountByAccountID(int accountID){
        conn = ConnectionConfuguration.getConnection();
        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Account account=null;
        if(conn == null){
            account=new Account("Connection Null SQL");
            System.out.println("conn error");
            closeConnection();
            return account;
        }
        if(st == null){
            account=new Account("State Null SQL");
            System.out.println("st error");
            closeConnection();
            return account;
        }
        try {
            res = st.executeQuery("SELECT * FROM account WHERE accountID='"+accountID+"'");
            if (res == null) {
                account=new Account("Not Found SQL");
                System.out.println("rest error");
                closeConnection();
                return account;
            }
            while (res.next()) {
                Integer getAccountID=Integer.parseInt(res.getString(1));
                String getName =res.getString(2);
                String getFbID=res.getString(4);
                account=new Account(getAccountID,getName,getFbID);
            }
        }
        catch(Exception e){
            account=new Account(e.toString()+"SQL  it   I don't know");
            System.out.println(e.toString() + " error");
        }
        closeConnection();
        return account;
    }


    public  void closeConnection(){
        try{
            conn.close();
            conn=null;
        }catch (Exception  e){

        }
    }
}
