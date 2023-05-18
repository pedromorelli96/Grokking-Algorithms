import java.util.ArrayList;
import java.util.Arrays;

public class RecursiveSum {

	private static int recursiveSum(ArrayList<Integer> array) {
		// base case
		if (array.size() == 0) {
			return 0;
		}
		
		// recursive case
		return array.remove(0) + recursiveSum(array); // we can count elements if we return 1 + recursion
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(2, 3, 5, 90));
		System.out.println(recursiveSum(array)); // 100
	}

}
