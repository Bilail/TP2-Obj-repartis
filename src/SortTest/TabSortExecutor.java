package SortTest;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TabSortExecutor {
    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();

        TabSort [] tab = new TabSort[Params.NB];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new TabSort(Params.TABSIZE);
        }

        long t1 = System.currentTimeMillis();

        for (TabSort t : tab) {
            executor.execute(t);
        }

        long t2 = System.currentTimeMillis();

        System.out.println ("TEMPS=" + (t2-t1));

        System.out.println(TabSort.check(tab));

    }
}
