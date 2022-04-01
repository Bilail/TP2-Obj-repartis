package SortTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TabSortExecutor {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        TabSort [] tab = new TabSort[Params.NB];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new TabSort(Params.TABSIZE);
        }

        long t1 = System.currentTimeMillis();

        for (TabSort t : tab) {
            executor.submit(t);
        }

        try {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
        }

        long t2 = System.currentTimeMillis();

        System.out.println ("TEMPS=" + (t2-t1));

        System.out.println(TabSort.check(tab));

    }
}
