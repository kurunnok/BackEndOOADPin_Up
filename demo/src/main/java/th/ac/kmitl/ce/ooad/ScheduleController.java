package th.ac.kmitl.ce.ooad;

import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 30/10/2558.
 */
@Controller
public class ScheduleController {
    public List<List<Topic>> getAllSchedule(int accountID) {
        System.out.println("getAllSchedule start");
        ScheduleHandler sh = new ScheduleHandler();
        ArrayList<SubSchedule> schedule = sh.getScheduleByAccountID(accountID);
        Iterator<SubSchedule> is = schedule.iterator();
        while ((is.hasNext())) {
            SubSchedule s = is.next();
            System.out.println("schedule ID :" + s.getScheduleID());
        }

        ArrayList<Pin> pin = sh.getPinAll();
        Iterator<Pin> ip = pin.iterator();
        while ((ip.hasNext())) {
            Pin p = ip.next();
            System.out.println("Pin ID :" + p.getPinID() + "    topicID " + p.getTopicID() + "    scheduleID " + p.getScheduleID());
        }

        List<List<Topic>> lists = searchTopic(schedule, pin);
        return lists;
    }

    public String storePinup(int accountID, String datetime, int topicID, String time) throws ParseException {
        ScheduleHandler sh = new ScheduleHandler();
        SubSchedule subSchedule = null;
        boolean yet = checkSchedule(accountID, datetime);
        if (!yet) {
            subSchedule = sh.storeSchedule(accountID, datetime);
        } else {
            subSchedule = sh.getOneSchedule(accountID, datetime);
        }

        if (subSchedule.getScheduleID() == -1)
            return "fail to get subSchedule check your accoutID or datetime";
        else
            return sh.storePin(subSchedule.getScheduleID(), topicID, datetime, time);

    }

    public List<List<Topic>> searchTopic(ArrayList<SubSchedule> subSchedule, ArrayList<Pin> pin) {
        TopicHandler tp = new TopicHandler();
        ArrayList<Topic> list = tp.getTopicAll();

        Iterator<SubSchedule> itrS = subSchedule.iterator();


        List<List<Topic>> lists = new ArrayList<List<Topic>>();  //create arrayList for send to UI

        while (itrS.hasNext()) {
            SubSchedule currentSubSchedule = itrS.next();
            System.out.println(" 1 ");
            Iterator<Pin> itrP = pin.iterator();
            ArrayList<Topic> currentTopicList = new ArrayList<>();
            while (itrP.hasNext()) {
                Pin currentPin = itrP.next();

                Iterator<Topic> itrT = list.iterator();
                System.out.println(" 2 ");
                if (currentPin.getScheduleID() == currentSubSchedule.getScheduleID()) {
                    while (itrT.hasNext()) {
                        Topic currentTopic = itrT.next();
                        System.out.println(" 3 ");
                        if ((currentTopic.getTopicID()) == currentPin.getTopicID()) {
                            currentTopicList.add(currentTopic);
                            System.out.println(" 4 ");
                        }
                    }

                }
            }
            if (!currentTopicList.isEmpty())
                lists.add(currentTopicList);
        }
        return lists;
    }

    public boolean checkSchedule(int accountID, String date) throws ParseException {
        ScheduleHandler sh = new ScheduleHandler();
        ArrayList<SubSchedule> list = sh.getScheduleByAccountID(accountID);
        Iterator<SubSchedule> itr = list.iterator();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //get time from parameter and for compare with schedule in database
        int year = (Integer.parseInt(date.substring(0, 4)) + 543);
        String yyear = "" + year;
        // String ttime=time.substring(0,2)+":"+time.substring(2,4)+":"+time.substring(4,6);
        String s1 = yyear + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
        Date date1 = sdf.parse(s1);
        boolean check = false;
        while (itr.hasNext()) {
            SubSchedule currentSubSchedule = itr.next();
            int tem = 1;
            // get time and check schedule in database
            int year2 = (currentSubSchedule.getDate().getYear() + 543);
            String yyear2 = "" + year;
            //  String ttime2=currentSubSchedule.getDate().getHours()+":"+currentSubSchedule.getDate().getMinutes()+":"+currentSubSchedule.getDate().getSeconds();
            String s2 = yyear2 + "-" + currentSubSchedule.getDate().getMonth() + "-" + currentSubSchedule.getDate().getDate();
            Date date2 = sdf.parse(s2);
         /*   boolean x= date1.getDate()==date2.getDate() ;
            boolean y= date1.getMonth()==date2.getMonth()+tem ;
            boolean z= date1.getYear()==date2.getYear() ;
            System.out.println(" #1  "+ x);
            System.out.println(" #2  "+ y+ "   date1 "+date1.getMonth()+ "  date2 "+date2.getMonth());
            System.out.println(" #3  "+ z);
            System.out.println();*/
            if ((date1.getDate() == date2.getDate()) && (date1.getMonth() == date2.getMonth() + tem) && (date1.getYear() == date2.getYear())) {
                check = true;
                break;
            }
        }
        return check;
    }
}
