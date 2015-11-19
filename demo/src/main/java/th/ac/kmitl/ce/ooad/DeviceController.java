package th.ac.kmitl.ce.ooad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 16/11/2558.
 */
@Controller
public class DeviceController {
    @RequestMapping(value = "/storeDeviceID",method = RequestMethod.POST)
    public @ResponseBody String storeDevice(
            @RequestParam(value = "deviceID",defaultValue = "simple")String deviceID,
            @RequestParam(value = "fbID",defaultValue = "0")String fbID){
        return new DeviceHandler().storeDevice(deviceID,fbID);
    }

    @RequestMapping(value = "/deleteDevice",method = RequestMethod.POST)
    public @ResponseBody String deleteDevice(
            @RequestParam(value = "deviceID",defaultValue = "simple")String deviceID,
            @RequestParam(value = "fbID",defaultValue = "0")String fbID){
        return new DeviceHandler().deleteDevice(deviceID,fbID);
    }


}
