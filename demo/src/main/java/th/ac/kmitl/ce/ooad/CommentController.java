package th.ac.kmitl.ce.ooad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by Administrator on 9/11/2558.
 */
@Controller
public class CommentController {

    @RequestMapping(value = "/getCommentByTopicID",method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Comment> getCommentByTopicID(@RequestParam(value = "topicID",defaultValue = "54")int topicID){

        CommentHandler ch=new CommentHandler();
        return ch.getCommentAllByTopicID(topicID);
    }


    @RequestMapping(value = "/storeComment",method = RequestMethod.GET)
    public @ResponseBody
    String storeComment(@RequestParam(value = "desc",defaultValue = "Hello")String desc,
                        @RequestParam(value = "accountID",defaultValue = "9999")int accountID,
                        @RequestParam(value = "topicID",defaultValue = "54")int topicID){

        CommentHandler ch=new CommentHandler();
        return ch.storeComment(desc, accountID, topicID);
    }
    @RequestMapping(value = "/storeComment",method = RequestMethod.POST)
    public @ResponseBody
    String storeCommentPost(@RequestParam(value = "desc",defaultValue = "Hello")String desc,
                        @RequestParam(value = "accountID",defaultValue = "9999")int accountID,
                        @RequestParam(value = "topicID",defaultValue = "54")int topicID){

        CommentHandler ch=new CommentHandler();
        return ch.storeComment(desc, accountID, topicID);
    }

    @RequestMapping(value = "/deleteComment",method = RequestMethod.GET)
    public @ResponseBody
    String deleteComment(@RequestParam(value = "accountID",defaultValue = "9999")int accountID,
                        @RequestParam(value = "commentID",defaultValue = "0")int commentID){

        CommentHandler ch=new CommentHandler();
        return ch.deleteComment(accountID, commentID);
    }

    @RequestMapping(value = "/deleteComment",method = RequestMethod.POST)
    public @ResponseBody
    String deleteCommentPost(@RequestParam(value = "accountID",defaultValue = "9999")int accountID,
                           @RequestParam(value = "commentID",defaultValue = "0")int commentID){

        CommentHandler ch=new CommentHandler();
        return ch.deleteComment(accountID, commentID);
    }


}
