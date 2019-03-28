package redis;

public class Test {
    public static void main(String[] args) {
        Run r1 = new Run();
        Run r2 = new Run();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        long now = System.currentTimeMillis();
        t1.start();
        t2.start();
//        System.out.println(System.currentTimeMillis() - now);
    }

    public static class Run implements Runnable {

        @Override
        public void run() {
            System.out.println("a");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long now = System.currentTimeMillis();
            System.out.println(now);
        }
    }
}
