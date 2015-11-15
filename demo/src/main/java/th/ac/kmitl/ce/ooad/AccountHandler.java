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
        conn = ConnectionConfuguration.getConnection();
    }

    public Account getAccountByAccountID(int accountID){
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
            return account;
        }
        if(st == null){
            account=new Account("State Null SQL");
            System.out.println("st error");
            return account;
        }
        try {
            res = st.executeQuery("SELECT * FROM account WHERE accountID='"+accountID+"'");
            if (res == null) {
                account=new Account("Not Found SQL");
                System.out.println("rest error");
                return account;
            }
            while (res.next()) {

                String getName =res.getString(2);
                account=new Account(accountID,getName);
            }
        }
        catch(Exception e){
            account=new Account(e.toString()+"SQL  it   I don't know");
            System.out.println(e.toString() + " error");
        }
        return account;
    }

    public String storeAccount(int accountID,String name){
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
                String query ="INSERT INTO account(accountID,name) VALUES ('"+accountID+"','"+name+"')";
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

    public String deleteAccount(int  accountID ) {
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
                String query ="DELETE FROM account WHERE accountID='"+accountID+"'";
                st.executeUpdate(query);
                System.out.println("Delete account complete ...");
                check= "Delete account complete ...";

            }catch (Exception e){
                System.out.println(e.toString());
                check= e.toString();
            }
        }
        System.out.println("Delete account  success");

        return check;
    }


}
