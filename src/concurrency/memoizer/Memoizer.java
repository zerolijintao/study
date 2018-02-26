package concurrency.memoizer;

import java.util.concurrent.*;

/**
 * Created by panny on 2018/2/26.
 *
 * 采用了ConcurrentHashMap保证线程可见，并且实例化一次
 * 采用FutureTask保证了当一个线程实例化时，其他线程阻塞等待其实例化完成
 */
public class Memoizer <A, V> implements Computable<A, V> {
    private final ConcurrentMap<A, Future<V>> cache
            = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(final A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = new Callable<V>() {
                    public V call() throws InterruptedException {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<V>(eval);
                //巧妙的使用，多线程环境下也不会实例化多个map
                f = cache.putIfAbsent(arg, ft);
                if (f == null) {
                    f = ft;
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                cache.remove(arg, f);
            } catch (ExecutionException e) {
                System.out.println("这里可以抛出异常");
            }
        }
    }
}