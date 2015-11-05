package th.ac.kmitl.ce.ooad;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 23/10/2558.
 */
public class Schedule {
    private int pinID;
    private int accountID;
    private Date date;
    private ArrayList<Topic> list;
    private String dateString;

    public Schedule(int accountID,Date date,ArrayList list,String dateString){
        this.accountID=accountID;
        this.date=date;
        this.list=list;
        this.dateString=dateString;
    }

    public int getPinID() {
        return pinID;
    }

    public void setPinID(int pinID) {
        this.pinID = pinID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Topic> getList() {
        return list;
    }

    public void setList(ArrayList<Topic> list) {
        this.list = list;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }





}
