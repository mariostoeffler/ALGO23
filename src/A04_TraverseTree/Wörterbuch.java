package A04_TraverseTree;

import java.util.HashSet;
import java.util.Set;


public class W�rterbuch {

	/**
	 * Wurzel des Baums (Startknoten)
	 */
	private Wort root;
	
	public Wort getRoot() {
		return root;
	}

	/**
	 * Z�hlt alle W�rter des Teilbaums ab einem bestimmten Wort
	 * @param w Wort
	 * @return Zahl der W�rter (=Anzahl der Elemente)
	 */
	public int countWordsInSubTree(Wort w) {
		if	(w==null) {
			return 0;
		}
		return countWordsInSubTree(w.getLeft()) + 1 + countWordsInSubTree(w.getRight());
	}

	/**
	 * Liefert die Menge aller W�rter retour, die ein spezifisches Pr�fix haben.
	 * @param prefix W�rter m�ssen diesen Pr�fix haben
	 * @return Menge aller zutreffenden W�rter
	 */
	public Set<String> getWordsWithPrefix(String prefix) {
		Set<String> matchingWords = new HashSet<>();
		getWordsWithPrefix(root, prefix, matchingWords);
		return matchingWords;
	}

	private void getWordsWithPrefix(Wort current, String prefix, Set<String> matchingWords) {
		if (current == null) {
			return;
		}

		int compareResult = current.getWort().compareTo(prefix);

		if (compareResult >= 0) {
			// Das aktuelle Wort kommt nach dem Pr�fix oder ist gleich
			if (current.getWort().startsWith(prefix)) {
				matchingWords.add(current.getWort());
			}
			// Da die W�rter im Baum lexikographisch sortiert sind,
			// suchen Sie weiter im linken Teilbaum
			getWordsWithPrefix(current.getLeft(), prefix, matchingWords);
		}

		// Suchen Sie im rechten Teilbaum, wenn das aktuelle Wort lexikographisch kleiner als das Pr�fix ist
		if (compareResult <= 0) {
			getWordsWithPrefix(current.getRight(), prefix, matchingWords);
		}}


	/**
	 * Neues Wort hinzuf�gen
	 * @param wort Hinzuzuf�gendes Wort
	 */
	public void add(String wort) {
		Wort neu = new Wort(wort);
		if (root == null) {			// Fall 1: Baum ist leer
			root = neu;
			return;
		}
		Wort w = root;				// Fall 2: Baum ist nicht leer
		while (true) {
			int vgl = wort.compareTo(w.getWort());
			if (vgl < 0) {			// Neues Wort ist lexikographisch kleiner
				if (w.getLeft() == null) {
					w.setLeft(neu);
					neu.setParent(w);
					return;
				}
				w = w.getLeft();
			}
			else if (vgl > 0) {		// Neues Wort ist lexikographisch gr��er
				if (w.getRight() == null) {
					w.setRight(neu);
					neu.setParent(w);
					return;
				}
				w = w.getRight();
			}
			else {					// Neues Wort ist lexikographisch gleich
				return;
			}
		}
	}

	public Wort find(String s) {
		return find(root, s);
	}
	
	private Wort find(Wort current, String s) {
		if (current == null) {
			return null;
		}
		int vgl = s.compareTo(current.getWort());
		if (vgl == 0) {		// Gefunden
			return current;
		}
		else if (vgl < 0) {	// Links
			return find(current.getLeft(), s);
		}
		else {				// Rechts
			return find(current.getRight(), s);
		}
	}
	
}
