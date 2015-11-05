package th.ac.kmitl.ce.ooad;


import java.util.*;
/**
 * Created by Administrator on 15/10/2558.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class TopicController {

    public ArrayList<Topic> searchByType(String type,String order){
        TopicHandler tpm = new TopicHandler();
        ArrayList<Topic> list=tpm.getTopicByType(type);
       list=sort(list,order);
        return list;
    }

    public  ArrayList<Topic> searchByKeyword(String keyword,String order){
        TopicHandler tpm = new TopicHandler();
        ArrayList<Topic> list=tpm.getTopicAll();
        ArrayList<Topic> array=new ArrayList<>();
        Iterator<Topic> ite= list.iterator();
        while (ite.hasNext()){
            Topic topic=ite.next();
            boolean check=false;
            if(topic.getNameTitle().toUpperCase().equals(keyword.toUpperCase())){
                check=true;
            }
            if(topic.getLocation().toUpperCase().equals(keyword.toUpperCase())){
                check=true;
            }
            if(topic.getTag().toUpperCase().equals(keyword.toUpperCase())){
                check=true;
            }
            if(topic.getType().toUpperCase().equals(keyword.toUpperCase())){
                check=true;
            }
            if (check==true) {
                array.add(topic);
            }
        }
        array=sort(array,order);
        return array;
    }

    private ArrayList<Topic> orderByAlfabet(ArrayList<Topic> array){
        Collections.sort(array, Topic.TopicNameComparator);
        return array;
    }
    private ArrayList<Topic> orderByStartDate(ArrayList<Topic> array){
        Collections.sort(array, Topic.StartDateComparator);
        return array;
    }
    private ArrayList<Topic> orderByRate(ArrayList<Topic> array){
        Collections.sort(array, Topic.RateComparator);
        return array;
    }

    private ArrayList sort(ArrayList array,String order){
        if (order.equals("alfabet")){
            array=orderByAlfabet(array);
        }
        else if (order.equals("startDate")){
            array=orderByStartDate(array);
        }
        else if(order.equals("rate")){
            array=orderByRate(array);
        }
        return array;
    }
}




