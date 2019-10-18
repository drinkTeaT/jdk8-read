package algorithm.tread;

import java.util.concurrent.*;

/**
 * 并发模拟器
 */
public class ConcurrentSimulation {
    private CyclicBarrier barrier;
    private ExecutorService executor;

    public ConcurrentSimulation(int threadCount) {
        barrier = new CyclicBarrier(threadCount);
        executor = Executors.newFixedThreadPool(threadCount);
    }

    /**
     * 接受任务并模拟同步执行
     */
    public void getTask(Runnable task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier.await();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void stop() {
        executor.shutdown();
    }
}
