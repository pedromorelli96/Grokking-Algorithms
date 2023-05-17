
public class BinarySearch {

	// needs to use Integer class so we can return null value
	private static Integer binarySearch(int[] array, int item) {
		int low = 0;
		int high = array.length - 1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			int guess = array[mid];
			
			if (guess == item) {
				return mid;
			}
			
			if (guess > item) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return null; // could be -1 
	}
	
	
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9};
		
		System.out.println(binarySearch(array, 3)); // 1
		System.out.println(binarySearch(array, -1)); // null
	}

}
