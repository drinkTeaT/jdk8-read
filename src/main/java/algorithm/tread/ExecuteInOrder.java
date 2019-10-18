package algorithm.tread;

/**
 * 在多线程环境里如何让方法顺序执行 == 在多线程环境里如何让方法顺序返回结果；
 */
class ExecuteInOrder {
    private volatile boolean isFirstDone = false;
    private volatile boolean isSecondDone = false;

    public ExecuteInOrder() {
    }

    public Runnable first() throws InterruptedException {
        return () -> {
            System.out.println("one");
            isFirstDone = true;
        };
    }

    public Runnable second() throws InterruptedException {
        return () -> {
            while (!isFirstDone) ;
            System.out.println("two");
            isSecondDone = true;
        };
    }

    public Runnable third() throws InterruptedException {
        return () -> {
            while (!isSecondDone) ;
            System.out.println("three");
        };
    }

    public static void main(String[] args) throws InterruptedException {
        ExecuteInOrder executeInOrder = new ExecuteInOrder();
        ConcurrentSimulation simulation = new ConcurrentSimulation(3);
        simulation.getTask(executeInOrder.second());
        simulation.getTask(executeInOrder.third());
        simulation.getTask(executeInOrder.first());
        simulation.stop();
    }
}
