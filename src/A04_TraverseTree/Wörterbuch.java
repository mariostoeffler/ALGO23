package A04_TraverseTree;

import java.util.HashSet;
import java.util.Set;


public class Wörterbuch {

	/**
	 * Wurzel des Baums (Startknoten)
	 */
	private Wort root;
	
	public Wort getRoot() {
		return root;
	}

	/**
	 * Zählt alle Wörter des Teilbaums ab einem bestimmten Wort
	 * @param w Wort
	 * @return Zahl der Wörter (=Anzahl der Elemente)
	 */
	public int countWordsInSubTree(Wort w) {
		if	(w==null) {
			return 0;
		}
		return countWordsInSubTree(w.getLeft()) + 1 + countWordsInSubTree(w.getRight());
	}

	/**
	 * Liefert die Menge aller Wörter retour, die ein spezifisches Präfix haben.
	 * @param prefix Wörter müssen diesen Präfix haben
	 * @return Menge aller zutreffenden Wörter
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
			// Das aktuelle Wort kommt nach dem Präfix oder ist gleich
			if (current.getWort().startsWith(prefix)) {
				matchingWords.add(current.getWort());
			}
			// Da die Wörter im Baum lexikographisch sortiert sind,
			// suchen Sie weiter im linken Teilbaum
			getWordsWithPrefix(current.getLeft(), prefix, matchingWords);
		}

		// Suchen Sie im rechten Teilbaum, wenn das aktuelle Wort lexikographisch kleiner als das Präfix ist
		if (compareResult <= 0) {
			getWordsWithPrefix(current.getRight(), prefix, matchingWords);
		}}


	/**
	 * Neues Wort hinzufügen
	 * @param wort Hinzuzufügendes Wort
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
			else if (vgl > 0) {		// Neues Wort ist lexikographisch größer
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
