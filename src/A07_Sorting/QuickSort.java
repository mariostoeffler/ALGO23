package A07_Sorting;


public class QuickSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */


	public void sort(Person[] personen) {
		sort(personen, 0, personen.length - 1);
	}

	private void sort(Person[] personen, int left, int right) {
		// TODO: Implementation

		if (left < right) {
			int pivotIndex = partition(personen, left, right);
			sort(personen, left, pivotIndex-1); //links vom Pivot
			sort(personen, pivotIndex + 1, right); //rechts vom Pivot
		}
	}

	private int partition(Person[] personen, int left, int right) {
		Person pivot = personen[right];
		int i = left - 1;

		for (int j = left; j < right; j++) {
			if (personen[j].compareTo(pivot) <= 0) {
				i++;
				swap(personen, i, j);
			}
		}

		swap(personen, i + 1, right);
		return i + 1;
	}

	private void swap(Person[] personen, int i, int j) {
		Person temp = personen[i];
		personen[i] = personen[j];
		personen[j] = temp;
	}
}