package th.ac.kmitl.ce.ooad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 30/10/2558.
 */
@Controller
public class ScheduleController {

    @RequestMapping(value = "/storePinup",method = RequestMethod.POST)
    public @ResponseBody String storePinup(
            @RequestParam(value = "accountID",defaultValue = "0")int accountID,
            @RequestParam(value = "date",defaultValue ="20150101" )String date,
            @RequestParam(value = "topicID",defaultValue = "23")int topicID,
            @RequestParam(value = "time",defaultValue = "090000")String time ){
        return new ScheduleHandler().storePin(accountID,topicID,date,time);
    }

    @RequestMapping(value = "/getPinOneDay",method = RequestMethod.POST)
    public @ResponseBody ArrayList<Topic> getPinOneDay(
            @RequestParam(value = "accountID",defaultValue = "0")int accountID,
            @RequestParam(value = "date",defaultValue ="20150101" )String date){
        String date2=date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
        ArrayList<Pin> array=new ScheduleHandler().getPinByAccountIDAndDate(accountID, date2);

        if (!array.isEmpty()){
           // System.out.println("Pin is not null");
            return searchTopic(array);
        }
        else {
           // System.out.println("Pin is null");
            return null;
        }

    }
    @RequestMapping(value = "/getPinOneDay",method = RequestMethod.GET)
    public @ResponseBody ArrayList<Topic> getPinOneDayGet(
            @RequestParam(value = "accountID",defaultValue = "0")int accountID,
            @RequestParam(value = "date",defaultValue ="20150101" )String date){
        String date2=date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
        ArrayList<Pin> array=new ScheduleHandler().getPinByAccountIDAndDate(accountID, date2);

        if (!array.isEmpty()){
            // System.out.println("Pin is not null");
            return searchTopic(array);
        }
        else {
            // System.out.println("Pin is null");
            return null;
        }

    }

    @RequestMapping(value = "/deletePin",method = RequestMethod.POST)
    public @ResponseBody String deletePin(
                @RequestParam(value = "accountID",defaultValue = "0")int accountID,
                @RequestParam(value = "topicID",defaultValue = "23")int topicID){
        return new ScheduleHandler().deletePin(accountID,topicID);
    }

    public ArrayList<Topic> searchTopic(ArrayList<Pin> arrayPin){
       // System.out.println("Start search Topic");
        ArrayList<Topic> array=new ArrayList<>();
        Iterator<Pin> itrp=arrayPin.iterator();
        while (itrp.hasNext()){
            Pin pin=itrp.next();
            Topic topic=new TopicHandler().getTopicByTopicID(pin.getTopicID());
            if (topic!=null){
              //  System.out.println("Topic is not null");
                array.add(topic);
            }
        }
        return array;
    }




}
