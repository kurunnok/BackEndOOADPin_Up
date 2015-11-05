package th.ac.kmitl.ce.ooad;

/**
 * Created by Administrator on 15/10/2558.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

@Controller
//@RequestMapping("/postTopic")
public class TopicPath {

    @RequestMapping(value = ("/getTopicAll"), method = RequestMethod.GET)
    public
    @ResponseBody
    ArrayList<Topic> returnTopicAll() {
        TopicHandler tpm = new TopicHandler();
        return tpm.getTopicAll();
    }

    @RequestMapping(value = ("/getTopicByID"), method = RequestMethod.GET)
    public
    @ResponseBody
    Topic returnTopicByID(
            @RequestParam(value = "id", defaultValue = "1") String id) {
        TopicHandler tpm = new TopicHandler();
        return tpm.getTopicByTopicID(Integer.parseInt(id));
    }

    @RequestMapping(value = ("/postTopic"), method = RequestMethod.GET)
    public
    @ResponseBody
    String createTopicMethodGet(
            @RequestParam(value = "title", defaultValue = "simple") String title,
            @RequestParam(value = "startDate", defaultValue = "20150101") String startDate,
            @RequestParam(value = "startTime", defaultValue = "090000") String startTime,
            @RequestParam(value = "endDate", defaultValue = "20150101") String endDate,
            @RequestParam(value = "endTime", defaultValue = "150000") String endTime,
            @RequestParam(value = "location", defaultValue = "Bangkok") String location,
            @RequestParam(value = "desc", defaultValue = "simple") String description,
            @RequestParam(value = "type", defaultValue = "public") String type,
            @RequestParam(value = "rate", defaultValue = "0.0") String rate,
            @RequestParam(value = "tag", defaultValue = "#") String tag,
            @RequestParam(value = "photo", defaultValue = "" ) String photo) {

        TopicHandler tpm = new TopicHandler();
        tpm.storeTopic(title, startDate, startTime, endDate, endTime, location, description, type, rate, tag,photo);
        return "success";
    }

    @RequestMapping(value = ("/postTopic"), method = RequestMethod.POST)
    public
    @ResponseBody
    String createTopicMethodPost(
            @RequestParam(value = "title", defaultValue = "simple") String title,
            @RequestParam(value = "startDate", defaultValue = "20150101") String startDate,
            @RequestParam(value = "startTime", defaultValue = "090000") String startTime,
            @RequestParam(value = "endDate", defaultValue = "20150101") String endDate,
            @RequestParam(value = "endTime", defaultValue = "150000") String endTime,
            @RequestParam(value = "location", defaultValue = "Bangkok") String location,
            @RequestParam(value = "desc", defaultValue = "simple") String description,
            @RequestParam(value = "type", defaultValue = "public") String type,
            @RequestParam(value = "rate", defaultValue = "0.0") String rate,
            @RequestParam(value = "tag", defaultValue = "#") String tag,
            @RequestParam(value = "photo", defaultValue = "" ) String photo) {

        TopicHandler tpm = new TopicHandler();
        tpm.storeTopic(title, startDate, startTime, endDate, endTime, location, description, type, rate, tag,photo);
        return "success";
    }

    @RequestMapping(value = ("/searchByType"), method = RequestMethod.GET)
    public  @ResponseBody
    ArrayList<Topic> searchByType(
            @RequestParam(value = "type", defaultValue = "public") String type,
            @RequestParam(value = "order", defaultValue = "timestamp") String order)
    {
        return new TopicController().searchByType(type,order);
    }

    @RequestMapping(value = ("/searchByKeyword"), method = RequestMethod.GET)
    public  @ResponseBody
    ArrayList<Topic> searchByKeyword(
            @RequestParam(value = "keyword", defaultValue = "public") String keyword,
            @RequestParam(value = "order", defaultValue = "timestamp") String order)
    {
        return new TopicController().searchByKeyword(keyword, order);
    }


}




