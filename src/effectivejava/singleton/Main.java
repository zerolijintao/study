package effectivejava.singleton;

public class Main {
    public static void main(String[] args) {
        SingletonWithPublicFinalField.Instance.doThings();
        SingletonWithStaticFactory.getInstance().doThings();
        SingletonEnum.INSTANCE.doThings();
    }
}
