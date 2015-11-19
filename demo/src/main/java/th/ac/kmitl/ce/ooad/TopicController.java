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

    public ArrayList<Topic> searchByTag(String tag,String order){
        TopicHandler tpm = new TopicHandler();
        ArrayList<Topic> list=tpm.getTopicByTag(tag);
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
            if(topic.getNameTitle().toUpperCase().contains(keyword.toUpperCase())){
                check=true;
            }
            if(topic.getLocation().toUpperCase().contains(keyword.toUpperCase())){
                check=true;
            }
            if(topic.getTag().toUpperCase().contains(keyword.toUpperCase())){
                check=true;
            }
            if(topic.getType().toUpperCase().contains(keyword.toUpperCase())){
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


    public String updateRate(int topicID,double rate){
        TopicHandler th=new TopicHandler();
        Topic topic=th.getTopicByTopicID(topicID);

        double rate2=((topic.getRate()*topic.getPeople())+rate)/(topic.getPeople()+1);

        if(rate2>=5) rate2=5;
        return th.updateRate(topicID,rate2,topic.getPeople()+1);
    }

    public String deleteTopic(int accountID,int topicID){
        String check=null;
        TopicHandler th=new TopicHandler();
        AccountHandler ah=new AccountHandler();
        Account account=ah.getAccountByAccountID(accountID);
        if(account==null) return "fail account is null";
        else {
            Topic topic=th.getTopicByTopicID(topicID);
            if (topic.getAccount()==accountID){
                check=th.deleteTopic(topicID,accountID);
            }
            else return "Can't delete ,not your topic";
        }

        return check;
    }

    public ArrayList<Topic> getTopicDelete(int accountID){

        TopicHandler th=new TopicHandler();
        AccountHandler ah=new AccountHandler();
        Account account=ah.getAccountByAccountID(accountID);
        if(account==null) {
            System.out.println("fail account is null");
            return null;
        }
        else {
            if (account.getAccountID()==0) {
                ArrayList<Topic> topic=th.getTopicAllDelete();
                return topic;
            }
        }
        return null;
    }
}




