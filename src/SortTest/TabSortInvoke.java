package SortTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TabSortInvoke {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<Boolean>> callables = new ArrayList<>(Params.NB);

        TabSort [] tab = new TabSort[Params.NB];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new TabSort(Params.TABSIZE);
            int finalI = i;

            callables.add(() -> {
                tab[finalI].sort();
                return tab[finalI].isSorted();
            });
        }

        long t1 = System.currentTimeMillis();

        executor.invokeAll(callables);

        long t2 = System.currentTimeMillis();

        System.out.println ("TEMPS=" + (t2-t1));

        System.out.println(TabSort.check(tab));
    }
}
