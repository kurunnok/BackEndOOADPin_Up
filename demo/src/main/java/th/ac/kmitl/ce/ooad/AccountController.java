package th.ac.kmitl.ce.ooad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 10/11/2558.
 */
@Controller
public class AccountController {

    @RequestMapping(value = "/getAccountByAccountID",method = RequestMethod.GET)
    public @ResponseBody Account
            getAccountByAccountID( @RequestParam(value = "accountID",defaultValue = "999")int accountID)
    {
        return new AccountHandler().getAccountByAccountID(accountID);
    }

    @RequestMapping(value = "/storeAccount",method = RequestMethod.GET)
    public @ResponseBody String
    storeAccount( @RequestParam(value = "accountID",defaultValue = "999")int accountID,
                  @RequestParam(value = "name",defaultValue = "default")String name)
    {
        return new AccountHandler().storeAccount(accountID, name);
    }


    @RequestMapping(value = "/deleteAccount",method = RequestMethod.GET)
    public @ResponseBody String
    deleteAccount( @RequestParam(value = "accountID",defaultValue = "999")int accountID)
    {
        return new AccountHandler().deleteAccount(accountID);
    }

}
