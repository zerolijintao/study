package designmode.richenumtype;

/**
 * @author lijintao
 * @date 2020/2/14
 */
public interface NotifyMechanismInterface {
    public boolean doNotify(String msg);

    public static NotifyMechanismInterface byEmail(){//3.1 返回一个定义了邮件通知机制的策的实现——一个匿名内部类实例
        return new NotifyMechanismInterface(){
            @Override
            public boolean doNotify(String msg){
                System.out.println("邮件消息：" + msg);
                return true;
            }
        };
    }
    public static NotifyMechanismInterface bySms(){//3.2 定义短信通知机制的实现策略
        return new NotifyMechanismInterface(){
            @Override
            public boolean doNotify(String msg){
                System.out.println("短信消息：" + msg);
                return true;
            }
        };
    }
    public static NotifyMechanismInterface byWechat(){//3.3 定义微信通知机制的实现策略
        return new NotifyMechanismInterface(){
            @Override
            public boolean doNotify(String msg){
                System.out.println("微信消息：" + msg);
                return true;
            }
        };
    }
}
