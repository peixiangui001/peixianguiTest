import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BlockingQueue deque = new ArrayBlockingQueue(10);
        ExecutorService poolExecutor = new ThreadPoolExecutor(50,100,2,TimeUnit.DAYS,deque);

        for (int i = 0; i < 100; i++) {


                poolExecutor.execute(new ThreadTask());

        }



    }
}
class ThreadTask implements Runnable{

    public ThreadTask() {

    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}