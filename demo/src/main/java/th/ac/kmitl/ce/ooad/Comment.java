package th.ac.kmitl.ce.ooad;

/**
 * Created by Administrator on 9/11/2558.
 */
public class Comment {

    private int commentID;
    private String description;
    //private Topic topic;
    private Account account;


    public Comment(int commentID,String desc,Account account){
        this.commentID=commentID;
        this.description=desc;
        this.account=account;
    }
    public Comment(String desc,Account account){
        this.commentID=-1;
        this.description=desc;
        this.account=account;
    }
    public Comment(String state){
        this.commentID=-1;
        this.description=state;
        this.account=null;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
