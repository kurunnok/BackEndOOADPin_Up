package th.ac.kmitl.ce.ooad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by Administrator on 10/11/2558.
 */
@Controller
public class AccountController {

    @RequestMapping(value = "/getAccountByfbID",method = RequestMethod.GET)
    public @ResponseBody ArrayList<Account>
            getAccountByAccountID( @RequestParam(value = "fbID",defaultValue = "999")String fbID)
    {
        ArrayList<Account> arrayList=new ArrayList<>();
        arrayList.add(new AccountHandler().getAccountByfbID(fbID));
        return arrayList;
    }

    @RequestMapping(value = "/storeAccount",method = RequestMethod.GET)
    public @ResponseBody String
    storeAccount(
                  @RequestParam(value = "name",defaultValue = "default")String name,
                  @RequestParam(value = "fbID",defaultValue = "default")String fbID)
    {
        boolean check=checkAccount(name,fbID);
        if (check==true) return "has store";
        else {
            return new AccountHandler().storeAccount(name, fbID);
        }
    }


    @RequestMapping(value = "/deleteAccount",method = RequestMethod.GET)
    public @ResponseBody String
    deleteAccount( @RequestParam(value = "fbID",defaultValue = "999")String fbID)
    {
        return new AccountHandler().deleteAccount(fbID);
    }
    @RequestMapping(value = "/deleteAccount",method = RequestMethod.POST)
    public @ResponseBody String
    deleteAccountPost( @RequestParam(value = "fbID",defaultValue = "999")String fbID)
    {
        return new AccountHandler().deleteAccount(fbID);
    }

    @RequestMapping(value = "/storeAccount",method = RequestMethod.POST)
    public @ResponseBody String
    storeAccountPost(
                  @RequestParam(value = "name",defaultValue = "default")String name,
                  @RequestParam(value = "fbID",defaultValue = "default")String fbID)
    {
        boolean check=checkAccount(name,fbID);
        if (check==true) return "has store";
        else {
            return new AccountHandler().storeAccount(name, fbID);
        }
    }

    private boolean checkAccount(String name,String fbID){
        boolean check=false;
        Account account=new AccountHandler().getAccountByfbID(fbID);
        if (account==null) return false;
        if (account.getName().equals(name)) check=true;
        else check=false;
        return check;

    }
}
