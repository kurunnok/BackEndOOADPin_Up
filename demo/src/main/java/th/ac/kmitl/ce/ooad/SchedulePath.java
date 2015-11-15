package th.ac.kmitl.ce.ooad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Administrator on 30/10/2558.
 */
@Controller
public class SchedulePath {
//    @RequestMapping (value = "/getScheduleAll",method = RequestMethod.GET)
//    public
//    @ResponseBody
//    List<List<Topic>> getScheduleAll(
//            @RequestParam(value = "accountID",defaultValue = "1") int accountID)
//    {
//        ScheduleController sc=new ScheduleController();
//        return sc.getAllSchedule(accountID);
//    }
//
//    @RequestMapping (value = "/storeSchedule",method = RequestMethod.GET)
//    public
//    @ResponseBody
//    String storeSchedule(
//            @RequestParam(value = "accountID",defaultValue = "0") int accountID,
//            @RequestParam(value = "datetime",defaultValue = "20150101") String datetime,   ///datetime(startDate) UI have to insert for back-end ,for used to create Schedule and Pin
//            @RequestParam(value = "topicID",defaultValue = "23") int topicID,
//            @RequestParam(value = "time",defaultValue = "090000") String time) throws ParseException {
//        ScheduleController sc=new ScheduleController();
//
//        return sc.storePinup(accountID, datetime, topicID, time);
//    }
//
//
//
//    @RequestMapping (value = "/getScheduleOne",method = RequestMethod.GET)
//    public
//    @ResponseBody
//    List<Topic> getScheduleOne(
//            @RequestParam(value = "accountID",defaultValue = "1") int accountID,
//            @RequestParam(value = "date",defaultValue = "20151104") String date)
//    {
//        ScheduleController sc=new ScheduleController();
////        ScheduleHandler sh=new ScheduleHandler();
////        List<List<Topic>> array=sc.getAllSchedule(accountID);
////        List<Topic> array2=new ArrayList<>();
//
//        List<Topic> topics= sc.getScheduleOne(accountID, date);
//
//        if (topics==null) {
//            topics=new ArrayList<>();
//            topics.add(new Topic("Error,", "topic is not found"));
//        }
//        return topics;
//    }
//    @RequestMapping (value = "/getScheduleOne",method = RequestMethod.POST)
//    public
//    @ResponseBody
//    List<Topic> getScheduleOnePOST(
//            @RequestParam(value = "accountID",defaultValue = "1") int accountID,
//            @RequestParam(value = "date",defaultValue = "20151104") String date)
//    {
//        ScheduleController sc=new ScheduleController();
//
//        List<Topic> topics= sc.getScheduleOne(accountID, date);
//
//        if (topics==null) {
//            topics=new ArrayList<>();
//            topics.add(new Topic("Error,", "topic is not found"));
//        }
//        return topics;
//    }
//    @RequestMapping (value = "/storeSchedule",method = RequestMethod.POST)
//    public
//    @ResponseBody
//    String storeSchedulePost(
//            @RequestParam(value = "accountID",defaultValue = "0") int accountID,
//            @RequestParam(value = "datetime",defaultValue = "20150101") String datetime,   ///datetime(startDate) UI have to insert for back-end ,for used to create Schedule and Pin
//            @RequestParam(value = "topicID",defaultValue = "23") int topicID,
//            @RequestParam(value = "time",defaultValue = "090000") String time) throws ParseException {
//        ScheduleController sc=new ScheduleController();
//
//        return sc.storePinup(accountID, datetime, topicID, time);
//    }
//
//    @RequestMapping (value = "/deletePin",method = RequestMethod.GET)
//    public
//    @ResponseBody
//    String deletePin(
//            @RequestParam(value = "accountID",defaultValue = "0") int accountID,
//            @RequestParam(value = "date",defaultValue = "20150101") String datetime,
//            @RequestParam(value = "topicID",defaultValue = "23") int topicID) throws ParseException {
//        ScheduleController sc=new ScheduleController();
//        return sc.deletePin(accountID, datetime, topicID);
//    }
//
//    @RequestMapping (value = "/getAllPin",method = RequestMethod.GET)
//    public
//    @ResponseBody
//    ArrayList<Pin> testPin(
//            @RequestParam(value = "accountID",defaultValue = "1") int accountID)
//    {
//        ScheduleController sc=new ScheduleController();
//        return new ScheduleHandler().getPinAll();
//    }


}
