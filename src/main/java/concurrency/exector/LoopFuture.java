package main.java.concurrency.exector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 不建议这么写,请使用 ExecutorCompletionService
 *
 * executor.invokeAll也能实现多个任务批量提交执行，但是其是任务全部完成后才返回结果，效果不如ExecutorCompletionService
 * executor.invokeAll支持超时返回，定义超时时间，超过该时间后，返回已完成的任务（按照场景进行使用）
 */
public class LoopFuture
{
    public static void main(String[] args)
    {
        int taskSize = 5;

        ExecutorService executor = Executors.newFixedThreadPool(taskSize);

        List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();

        for (int i = 1; i <= taskSize; i++)
        {
            int sleep = taskSize - i; // 睡眠时间

            int value = i; // 返回结果

            // 向线程池提交任务
            Future<Integer> future = executor.submit(new ReturnAfterSleepCallable(sleep, value));

            // 保留每个任务的Future
            futureList.add(future);
        }

        // 轮询,获取完成任务的返回结果
        while(taskSize > 0)
        {
            for (Future<Integer> future : futureList)
            {
                Integer result = null;

                try
                {
                    result = future.get(0, TimeUnit.SECONDS);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                } catch (ExecutionException e)
                {
                    e.printStackTrace();
                } catch (TimeoutException e)
                {
                    // 超时异常需要忽略,因为我们设置了等待时间为0,只要任务没有完成,就会报该异常
                }

                // 任务已经完成
                if(result != null)
                {
                    System.out.println("result=" + result);

                    // 从future列表中删除已经完成的任务
                    futureList.remove(future);
                    taskSize--;
                    //此处必须break，否则会抛出并发修改异常。（也可以通过将futureList声明为CopyOnWriteArrayList类型解决）
                    break; // 进行下一次while循环
                }
            }
        }

        // 所有任务已经完成,关闭线程池
        System.out.println("all over.");
        executor.shutdown();

    }
}
