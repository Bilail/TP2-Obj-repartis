package SortTest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TabSortPool {

    public static void main(String[] args) throws InterruptedException {

        TabSort [] tab = new TabSort[Params.NB];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new TabSort(Params.TABSIZE);
        }

        ExecutorService executor = Executors.newFixedThreadPool(Params.NB);

        long t1 = System.currentTimeMillis();

        for (TabSort t : tab) {
            executor.execute(t);
        }

        executor.awaitTermination(500, TimeUnit.MILLISECONDS);
        
        executor.shutdown();

        long t2 = System.currentTimeMillis();

        System.out.println ("TEMPS=" + (t2-t1));

        System.out.println(TabSort.check(tab));

    }
}
