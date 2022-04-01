package SortTest;

public class TestSansThread {

	public static void main(String[] args) {

		TabSort [] tab = new TabSort[Params.NB];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = new TabSort(Params.TABSIZE);
		}

		long t1 = System.currentTimeMillis();

		for (TabSort t : tab) {
			t.sort();
		}

		long t2 = System.currentTimeMillis();

		System.out.println ("TEMPS=" + (t2-t1));

		System.out.println(TabSort.check(tab));
	}

}
