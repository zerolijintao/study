import java.util.concurrent.*;
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

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
            public Double call() {
                System.out.println("1");
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2");
                return 2d;
            }});
        System.out.println("3");
        try {
            Double result = future.get(60, TimeUnit.SECONDS);
        } catch (ExecutionException ee) {
// 计算抛出一个异常
        } catch (InterruptedException ie) {
// 当前线程在等待过程中被中断
        } catch (TimeoutException te) {
// 在Future对象完成之前超过已过期
        }
    }
}
