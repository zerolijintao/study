package main.java.concurrency.exector;

import java.util.concurrent.Callable;

/**
 * Created by panny on 2018/2/27.
 */
public class ReturnAfterSleepCallable implements Callable<Integer> {

    private int sleep;
    private int value;

    public ReturnAfterSleepCallable(int sleep, int value) {
        this.sleep = sleep;
        this.value = value;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(sleep * 1000);
        return value;
    }
}
