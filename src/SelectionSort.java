import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {

	private static int findSmallest(ArrayList<Integer> array) {
		int smallest = array.get(0);
		int smallestIdx = 0;
		
		for (int i = 1; i < array.size(); i++) {
			if (array.get(i) < smallest) {
				smallest = array.get(i);
				smallestIdx = i;
			}
		}
		return smallestIdx;
	}
	
	private static ArrayList<Integer> selectionSort(ArrayList<Integer> array) {
		ArrayList<Integer> newArray = new ArrayList<>();
		
		// size needs to be set outside of for loop
		// because we are removing elements from the array
		int size = array.size(); 
		for (int i = 0; i < size; i++) {
			int smallest = findSmallest(array);
			newArray.add(array.remove(smallest));
		}
		
		return newArray;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
		System.out.println(selectionSort(array)); // [2, 3, 5, 6, 10]
	}

}
