package th.ac.kmitl.ce.ooad;

import java.util.Date;

/**
 * Created by Administrator on 28/10/2558.
 */
public class SubSchedule {
    private int scheduleID;
    private int accountID;
    private Date date;


    private String state1;
    private String state2;

    public SubSchedule(int scheduleID,int accountID,Date date){
        this.scheduleID=scheduleID;
        this.accountID=accountID;
        this.date=date;
        this.state1="";
        this.state2="";
    }


    public SubSchedule(String state1,String state2){
        this.state1=state1;
        this.state2=state2;
        this.scheduleID=-1;
        this.accountID=-1;
        this.date=null;
    }

    public SubSchedule(String state1){
        this.state1=state1;
        this.state2="";
        this.scheduleID=-1;
        this.accountID=-1;
        this.date=null;
    }
    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
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
}
