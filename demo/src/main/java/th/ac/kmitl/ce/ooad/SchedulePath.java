package th.ac.kmitl.ce.ooad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 30/10/2558.
 */
@Controller
public class SchedulePath {
    @RequestMapping (value = "/getScheduleAll",method = RequestMethod.GET)
    public
    @ResponseBody
    List<List<Topic>> getScheduleAll(
            @RequestParam(value = "accountID",defaultValue = "1") int accountID)
    {
        ScheduleController sc=new ScheduleController();
        return sc.getAllSchedule(accountID);
    }

    @RequestMapping (value = "/storeSchedule",method = RequestMethod.GET)
    public
    @ResponseBody
    String storeSchedule(
            @RequestParam(value = "accountID",defaultValue = "0") int accountID,
            @RequestParam(value = "datetime",defaultValue = "20150101") String datetime,   ///datetime(startDate) UI have to insert for back-end ,for used to create Schedule and Pin
            @RequestParam(value = "topicID",defaultValue = "23") int topicID,
            @RequestParam(value = "time",defaultValue = "090000") String time) throws ParseException {
        ScheduleController sc=new ScheduleController();

        return sc.storePinup(accountID,datetime,topicID,time);
    }
}
