package concurrency.memoizer;

/**
 * Created by panny on 2018/2/26.
 */
public interface Computable<A, V> {
    V compute(final A arg) throws InterruptedException ;
}
