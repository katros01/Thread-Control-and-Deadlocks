import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Task extends RecursiveTask<Long> {
    private final int[] array;
    private final int start, end;
    private static final int THRESHOLD = 10;

    public Task(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            Task leftTask = new Task(array, start, mid);
            Task rightTask = new Task(array, mid, end);
            leftTask.fork();
            return rightTask.compute() + leftTask.join();
        }
    }
}

public class ForkJoin  {
    private final int[] array = new int[100];

    public void demonstrateForkJoin() {

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        ForkJoinPool pool = new ForkJoinPool();
        Task task = new Task(array, 0, array.length);
        long sum = pool.invoke(task);
        System.out.println("Sum using Fork/Join: " + sum);
    }
}
