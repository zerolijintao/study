package main.java.concurrency.memoizer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * Created by panny on 2018/2/25.
 */
public class BaseUtil {

    private static volatile Map<String, Integer> map = new HashMap<>();

    private static Map<String, FutureTask<Map<String, Integer>>> initMap = new ConcurrentHashMap<>();

    public static Integer getValue(String s) {
        if (map.size() == 0) {
            try {
                //多线程环境下，多个线程判断size都是0，同时init，如何让其只实例化一次？
                map = init2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map.get(s);

    }

    /**
     * 初始化map
     *
     * 采用了ConcurrentHashMap保证线程可见，并且实例化一次
     * 采用FutureTask保证了当一个线程实例化时，其他线程阻塞等待其实例化完成
     *
     * @return
     * @throws Exception
     */
    private static Map<String, Integer> init() throws Exception {
        FutureTask<Map<String, Integer>> f = initMap.get("initMap");
        if (f == null) {
            Callable<Map<String, Integer>> call = new Callable<Map<String, Integer>>() {
                @Override
                public Map<String, Integer> call() throws Exception {
                    //模拟调用远程接口
                    map.put("a", 1);
                    map.put("b", 2);
                    return map;
                }
            };
            FutureTask<Map<String, Integer>> task = new FutureTask<>(call);
            //巧妙的使用，多线程环境下也不会实例化多个map
            f = initMap.putIfAbsent("initMap", task);
            if (f == null) {
                f = task;
                task.run();
            }

        }
        return f.get();
    }

    private static Map<String, Integer> init2() throws Exception {
            if(map.size()==0){
                map.put("a", 1);
                map.put("b", 2);
            }
        return map;
    }
}
