package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description：高并发模拟器
 * date：2019/9/12
 * Author：tacbin
 **/
public class ConcurrentSimulation {
    private final static int NUMS_OF_CONCURRENt = 10000;// 并发数
    private final static CyclicBarrier barrier = new CyclicBarrier(NUMS_OF_CONCURRENt);
    private final static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        simulation(task());
    }

    /**
     * 模拟器
     */
    private static void simulation(Runnable runnable) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMS_OF_CONCURRENt);
        for (int i = 0; i < NUMS_OF_CONCURRENt; i++) {
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }

    private static Runnable task() {
        return () -> {
            try {
                barrier.await();
                System.out.println(count.addAndGet(1));
            } catch (InterruptedException e) {

                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
    }
}
