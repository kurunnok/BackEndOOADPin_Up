package th.ac.kmitl.ce.ooad;

/**
 * Created by Administrator on 9/11/2558.
 */
public class Account {
    private int accountID;
    private String name;
    private String fbID;

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account(int accountID){
        this.accountID=accountID;
        this.name="default";
        this.fbID="default";

    }
    public Account(int accountID,String name,String fbID){
        this.accountID=accountID;
        this.name=name;
        this.fbID=fbID;

    }
    public Account(String state){
        this.accountID=-1;
        this.name=state;
        this.fbID="";
    }

    public String getFbID() {
        return fbID;
    }

    public void setFbID(String fbID) {
        this.fbID = fbID;
    }
}
