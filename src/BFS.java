import java.util.*;

public class BFS {

	private static HashMap<String, List<String>> graph = new HashMap<>();

	private static boolean search(String name) {
		// initialize the search queue with the first values
		Queue<String> search_queue = new ArrayDeque<>(graph.get(name));

		// initialize empty list to track people we have already checked
		List<String> searched = new ArrayList<>();

		while (!search_queue.isEmpty()) {
			// gets and removes first element from queue
			String person = search_queue.poll();

			// only search this person if you haven't already checked them
			if (!searched.contains(person)) {
				if (person_is_seller(person)) {
					System.out.println(person + " is a mango seller!");
					return true;
				} else {
					// add every connection to the queue
					search_queue.addAll(graph.get(person));

					// mark this person as searched
					searched.add(person);
				}
			}
		}
		return false;
	}

	private static boolean person_is_seller(String name) {
		return name.endsWith("m");
	}

	public static void main(String[] args) {
		graph.put("you", Arrays.asList("alice", "bob", "claire"));
		graph.put("bob", Arrays.asList("anuj", "peggy"));
		graph.put("alice", Arrays.asList("peggy"));
		graph.put("claire", Arrays.asList("thom", "jonny"));
		graph.put("anuj", Collections.emptyList());
		graph.put("peggy", Collections.emptyList());
		graph.put("thom", Collections.emptyList());
		graph.put("jonny", Collections.emptyList());

		search("you");
	}

}
