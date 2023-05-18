import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quicksort {

	private static List<Integer> quickSort(List<Integer> array) {
		// base case
		if (array.size() < 2) {
			return array;
		}
		
		// recursive case
		int pivot = array.get(0);
		
		// sub-array of all elements smaller than the pivot
		List<Integer> smaller = array.stream()
										.skip(1)
										.filter(e -> e <= pivot)
										.collect(Collectors.toList());
		
		// sub-array of all elements bigger than the pivot
		List<Integer> bigger = array.stream()
				.skip(1)
				.filter(e -> e > pivot)
				.collect(Collectors.toList());
		
		return Stream.of(quickSort(smaller).stream(), Stream.of(pivot), quickSort(bigger).stream())
				.flatMap(Function.identity())
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(10, 5, 2, 3));
		System.out.println(quickSort(array)); // [2, 3, 5, 10]
	}

}
