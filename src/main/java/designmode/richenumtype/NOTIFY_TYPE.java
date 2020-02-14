package designmode.richenumtype;

/**
 * @author lijintao
 * @date 2020/2/14
 */
public enum NOTIFY_TYPE {
    /**
     * 短信
     */
    sms("短信",NotifyMechanismInterface.bySms()),
    email("邮件",NotifyMechanismInterface.byEmail()),
    wechat("微信",NotifyMechanismInterface.byWechat());

    String memo;
    NotifyMechanismInterface notifyMechanism;

    private NOTIFY_TYPE(String memo,NotifyMechanismInterface notifyMechanism){//2、私有构造函数，用于初始化枚举值
        this.memo=memo;
        this.notifyMechanism=notifyMechanism;
    }

    public String getMemo() {
        return memo;
    }

    public NotifyMechanismInterface getNotifyMechanism() {
        return notifyMechanism;
    }
}
