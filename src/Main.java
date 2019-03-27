import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static class Load{
        public static Integer i;
        static {
            System.out.println("hello Load!");
        }
    }

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        System.out.println("go");
        lock.unlock();
    }
}
