package designmode.richenumtype;

/**
 * @author lijintao
 * @date 2020/2/14
 */
public class Main {
    public static void main(String[] args) {
        String type = "sms";
        NOTIFY_TYPE.valueOf(type).getNotifyMechanism().doNotify("这是一条消息体");
    }
}
