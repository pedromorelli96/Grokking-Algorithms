import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveMaxNum {

	private static int recursiveMaxNum(List<Integer> array) {
		// base case
		if (array.size() == 2) {
			if (array.get(0) > array.get(1)) {
				return array.get(0);
			} else {
				return array.get(1);
			}
		}
		
		// recursive case
		int subArrayMax = recursiveMaxNum(array.subList(1, array.size()));
		if (array.get(0) > subArrayMax) {
			return array.get(0);
		} else {
			return subArrayMax;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(7, 3, 13, 99, 5));
		System.out.println(recursiveMaxNum(array)); // 99
	}

}
