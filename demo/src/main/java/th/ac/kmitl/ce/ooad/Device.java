package th.ac.kmitl.ce.ooad;

/**
 * Created by Administrator on 16/11/2558.
 */
public class Device {
    private String deviceID;
    private int accountID;


    public Device(String deviceID,int accountID){
        this.deviceID=deviceID;
        this.accountID=accountID;
    }
    public Device(String state1){
        this.deviceID="";
        this.accountID=-1;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
