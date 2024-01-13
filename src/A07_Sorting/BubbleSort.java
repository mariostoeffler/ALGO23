package A07_Sorting;


public class BubbleSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {
		int n = personen.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1 ; j++) {
				if (personen[j].compareTo(personen[j+1]) > 0) {
					Person temp = personen[j];
					personen[j] = personen[j+1];
					personen[j+1] = temp;
				}

			}

		}

	}
	
}
