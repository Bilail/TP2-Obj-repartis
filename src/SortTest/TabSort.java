import java.util.Arrays;

public class TabSort {
	private Long[] tab;

	public TabSort(int size) {
		tab = new Long [size];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (long)(tab.length - i);
		}
	}

	public void sort () {
		Arrays.sort(tab);
	}

	public Long[] getTab() {
		return tab;
	}

	public boolean isSorted() {
		return isSorted(tab.length);
	}

	/*
	 * Attention � la pile si grand nombre d'�l�ments
	 */
	private boolean isSorted(int length) {
	    if (length < 2)
	        return true;
	    if (tab[length - 2] > tab[length - 1])
	        return false;
	    return isSorted(length - 1);
	}

	public boolean equals (TabSort other) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i].longValue() != other.tab[i].longValue())
					return false;
		}
		return true;
	}

	/*
	 * V�rifie que tous les tableaux ont le m�me contenu
	 */
	public static boolean check(TabSort [] tab) {
		for (int i = 1; i < tab.length; i++) {
			if (! tab[0].equals(tab[i]))
					return false;
		}
		return true;
	}
}
