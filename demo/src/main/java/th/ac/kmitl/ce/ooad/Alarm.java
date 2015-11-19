package th.ac.kmitl.ce.ooad;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.TimerTask;

/**
 * Created by User on 3/11/2558.
 */
public class Alarm {
    Timer _timer;
    int i = 0;
    private final String USER_AGENT = "Mozilla/5.0";
    private String parameter = "{\n" +
            "    \"registration_ids\" :[\"e8ET3IhgoVw:APA91bE9Vdd4LUnOvK7xgV1H6aoIm6WeDtpZ4lwPyw3qaeXMy2CN9lW8oIkXbZB9aHak1oPHqWQy36lC4leP6eHAuW29Z7yMwurhxxPKsXmpWnPhwoFB2-PHuNTAOpI0qxDODE8ULJEX\"],\n" +
            " \n" +
            "   \"data\" : {\n" +
            "        \"message\": \"P arm\"\n" +
            "    }\n" +
            "}";

    public Alarm() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.SECOND, 0);

        Date alarmTime = calendar.getTime();

        _timer = new Timer();
        //  _timer.schedule(new AlarmTask(), alarmTime, 1 * 1000 * 3600);
        _timer.schedule(new AlarmTask(), alarmTime, 1 * 1000 * 30);
    }

    class AlarmTask extends TimerTask {
        /**
         * Called on a background thread by Timer
         */
        public void run() {
            try {
                ArrayList<Pin> array = new ScheduleHandler().getPinAll();
                ArrayList<Pin> alarmNow = new ArrayList<>();

                Iterator<Pin> itr = array.iterator();
                sendPost1();
                while (itr.hasNext()) {
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    Pin pin = itr.next();
                    Date now = new Date();
                    String nowS = dateFormat1.format(now);
                    String test = "2558-11-15 08:00";
                    String pinTime = dateFormat1.format(pin.getDate());

                    if (nowS.equals(pinTime)) {
                        Device device=new DeviceHandler().getDeviceByfbID(pin.getAccountID());
                        Topic topic=new TopicHandler().getTopicByTopicID(pin.getTopicID());
                        parameter="{\n" +
                                "    \"registration_ids\" :[\""+device.getDeviceID()+"\"],\n" +
                                " \n" +
                                "   \"data\" : {\n" +
                                "        \"message\": \""+topic.getNameTitle()+"\"\n" +
                                "    }\n" +
                                "}";
                        try{
                            sendPost1();
                        }
                        catch (Exception e){
                            System.out.println(e.toString());
                        }
                        System.out.println(nowS + "                     now");
                        System.out.println(pinTime + "                  pinTime");
                        System.out.println("Pin == ok");

                    }
                }
                Date now1 = new Date();
                System.out.println(now1.toString() + " " + i);
                i++;

            } catch (Exception e) {

            }
        }
    }

    public String sendPost1() throws Exception {

        String urlParameters = parameter;
        byte[] postData = urlParameters.getBytes("UTF-8");
        int postDataLength = postData.length;
        URL url;
        HttpURLConnection urlConn;
        DataOutputStream printout;
        DataInputStream input;
        url = new URL("https://gcm-http.googleapis.com/gcm/send");
        urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setDoInput(true);
        urlConn.setDoOutput(true);
        urlConn.setUseCaches(false);
        urlConn.setInstanceFollowRedirects(false);
        urlConn.setRequestMethod("POST");
        urlConn.setRequestProperty("charset", "utf-8");
        urlConn.setRequestProperty("Authorization", "key=AIzaSyCX2tyLXIrL0-eEtw0QL96WQtISw5y8C6E");
        urlConn.setRequestProperty("Content-Type", "application/json");
        urlConn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        urlConn.setRequestProperty("User-Agent", USER_AGENT);
        urlConn.connect();
        DataOutputStream wr = new DataOutputStream(urlConn.getOutputStream());
        wr.write(postData);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(urlConn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        urlConn.disconnect();
        return response.toString();


    }
}
