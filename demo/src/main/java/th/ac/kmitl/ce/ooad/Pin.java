package th.ac.kmitl.ce.ooad;

/**
 * Created by Administrator on 28/10/2558.
 */
public class Pin {
    private  int pinID;
    private int scheduleID;
    private int topicID;

    private String state1;
    private String state2;

    public Pin(int pinID,int scheduleID,int topicID){
        this.pinID=pinID;
        this.scheduleID=scheduleID;
        this.topicID=topicID;
    }

    public Pin(String state1,String state2){
        this.state1=state1;
        this.state2=state2;
        this.pinID=-1;
        this.scheduleID=-1;
        this.topicID=-1;
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

    public Pin(String state1){
        this.state1=state1;
        this.state2="";
        this.pinID=-1;

        this.scheduleID=-1;
        this.topicID=-1;
    }

    public int getPinID() {
        return pinID;
    }

    public void setPinID(int pinID) {
        this.pinID = pinID;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }
}
