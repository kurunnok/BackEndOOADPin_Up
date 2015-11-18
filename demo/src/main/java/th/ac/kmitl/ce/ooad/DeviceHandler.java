package th.ac.kmitl.ce.ooad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Administrator on 16/11/2558.
 */
public class DeviceHandler {
    private Connection conn;
    private Statement st;
    private ResultSet res;

    public DeviceHandler(){

    }

    public Device getDeviceByDeviceAndfbID(int fbID){

        conn = ConnectionConfuguration.getConnection();
        try {
            st = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Device device= null;
        //  System.out.println(" error");
        if(conn == null){
            device=new Device("Connection Null"+"SQL");
            System.out.println("conn error");
            closeConnection();
            return device;
        }
        if(st == null){
            device=new Device("State Null"+"SQL");
            System.out.println("st error");
            closeConnection();
            return device;
        }
        try {

            res = st.executeQuery("SELECT * FROM device WHERE fbID='"+fbID+"'");
            if (res == null) {
                device=new Device("Not Found, SQL?");
                System.out.println("st error");
                closeConnection();
                return device;
            }
            while (res.next()) {

                // if (res.next()) {
                String getDevice=res.getString(2);
                Integer getAccountID=Integer.parseInt(res.getString(3));

               device=new Device(getDevice,getAccountID);
            }
        }
        catch(Exception e){
            device=new Device(e.toString()+ "SQL  it   I don't know");
            System.out.println(e.toString()+" error");
        }
        closeConnection();
        return device;
    }


    public String storeDevice(String deviceId,String fbID ) {
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
                String query ="INSERT INTO device(deviceID,fbID) VALUES ('"+deviceId+"','"+fbID+"')";
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
    public  void closeConnection(){
        try{
            conn.close();
            conn=null;
        }catch (Exception  e){

        }
    }
}
