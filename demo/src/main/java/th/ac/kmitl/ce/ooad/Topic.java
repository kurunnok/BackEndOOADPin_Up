package th.ac.kmitl.ce.ooad;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Administrator on 12/10/2558.
 */
public class Topic {
    private String nameTitle;
    private String description;
    private Date startDate;  //วันจัดงาน
    private Date startTime; //เวลาที่จัดงาน
    private Date endDate;  //วันจัดงาน
    private Date endTime; //เวลาที่จัดงาน
    private String startDateString;
    private String endDateString;
    private String location;
    private String tag;
    private String type;
    private double rate;
    private ArrayList<Comment> comments;
    private int people;
    private int account;



    private  int topicID;
    private java.sql.Timestamp timestamp;
    private String photo;


    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public Topic (String nameTitle,String description,Date startDate,Date startTime,Date endDate,Date endTime,
                  String location,String tag, String type,double rate,String startDateString,String endDateString,
                  Timestamp timestamp,int topicID,String photo,int people,int account){
        this.nameTitle=nameTitle;
        this.description=description;
        this.startDate=startDate;
        this.startTime=startTime;
        this.endDate=endDate;
        this.endTime=endTime;
        this.type=type;
        this.rate=rate;
        this.startDateString=startDateString;
        this.endDateString=endDateString;
        this.location=location;
        this.tag=tag;
        this.timestamp=timestamp;
        this.topicID=topicID;
        this.photo=photo;
        this.people=people;
        this.account=account;
        //this.account=new AccountHandler().getAccountByAccountID(accountID);

       // this.comments=getCommentsFromDatabase(this.topicID);
    }
    public  Topic(String state1,String state2,int topicID){
        this.nameTitle=state1;
        this.description=state2;
        this.startDate=new Date();
        this.startTime=new Date();
        this.endDate=new Date();
        this.endTime=new Date();
        this.type="public";
        this.rate=0;
        this.startDateString="";
        this.endDateString="";
        this.location="";
        this.tag="";
        this.topicID=topicID;
        this.photo="";
        this.people=0;
        this.account=0;

    }
    public  Topic(String state1,String state2){
        this.nameTitle=state1;
        this.description=state2;
        this.startDate=new Date();
        this.startTime=new Date();
        this.endDate=new Date();
        this.endTime=new Date();
        this.type="public";
        this.rate=0;
        this.startDateString="";
        this.endDateString="";
        this.location="";
        this.tag="";
        this.photo="";
        this.people=0;
        this.account=0;
    }

    public Topic (int topicID,String nameTitle,String description,Date startDate,Date startTime,Date endDate,Date endTime,
                  String location,String tag, String type,double rate,String startDateString,String endDateString,Timestamp timestamp
                    ,int people,int account){
        this.topicID=topicID;
        this.nameTitle=nameTitle;
        this.description=description;
        this.startDate=startDate;
        this.startTime=startTime;
        this.endDate=endDate;
        this.endTime=endTime;
        this.type=type;
        this.rate=rate;
        this.startDateString=startDateString;
        this.endDateString=endDateString;
        this.location=location;
        this.tag=tag;
        this.timestamp=timestamp;
        this.photo="";
        this.people=people;
        this.account=account;
       // this.account=new AccountHandler().getAccountByAccountID(accountID);
    }


    public String getStartDateString() {
        return startDateString;
    }

    public void setStartDateString(String startDateString) {
        this.startDateString = startDateString;
    }

    public String getEndDateString() {
        return endDateString;
    }

    public void setEndDateString(String endDateString) {
        this.endDateString = endDateString;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }
    public String getStartDate() {
        return startDateString;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        String time1= startTime.toString();
        String time2=time1.substring(11,19);
        return time2;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDateString;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        String time1= endTime.toString();
        String time2=time1.substring(11,19);
        return time2;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getTimestamp() {
        return timestamp.toString();
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    public int compareTo(Topic compareTopict) {
        double compareRate = ((Topic) compareTopict).getRate();
        //ascending order
        int xx= (int )(this.rate-compareRate);
        return  xx;
        //descending order
        //return compareQuantity - this.quantity;
    }

    public static Comparator<Topic> TopicNameComparator = new Comparator<Topic>() {
        public int compare(Topic topic1, Topic topic2) {
            String topicName1 = topic1.getNameTitle().toUpperCase();
            String topicName2 = topic2.getNameTitle().toUpperCase();
            //ascending order
            return topicName1.compareTo(topicName2);
            //descending order
            //return fruitName2.compareTo(fruitName1);
        }
    };

    public static Comparator<Topic> StartDateComparator = new Comparator<Topic>() {
        public int compare(Topic topic1, Topic topic2) {
            String startDate1 = topic1.getStartDate().toUpperCase();
            String startDate2 = topic2.getStartDate().toUpperCase();
            //ascending order
            return startDate1.compareTo(startDate2);
            //descending order
            //return fruitName2.compareTo(fruitName1);
        }
    };
    public static Comparator<Topic> RateComparator = new Comparator<Topic>() {
        public int compare(Topic topic1, Topic topic2) {
            double rate1 = topic1.getRate();
            double rate2 = topic2.getRate();
            //ascending order
            return (int)(rate2-rate1);
            //descending order
            //return fruitName2.compareTo(fruitName1);
        }
    };

//    private ArrayList<Comment> getCommentsFromDatabase(int topicID){
//        CommentController ch=new CommentController();
//        return ch.getCommentByTopicIDAuto(topicID);
//    }
public int getPeople() {
    return people;
}

    public void setPeople(int people) {
        this.people = people;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {this.photo = photo;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
