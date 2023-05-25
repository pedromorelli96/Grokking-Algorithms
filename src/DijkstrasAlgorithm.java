import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class DijkstrasAlgorithm {

	// First we create the graph
	private static HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
	// The parents table
	private static HashMap<String, String> parents = new HashMap<>();
	// The costs table
	private static HashMap<String, Double> costs = new HashMap<>();
	// And the processed helper array
	private static List<String> processed = new ArrayList<>();

	private static String findLowestCostNode() {
		Double lowest_cost = Double.POSITIVE_INFINITY;
		String lowest_cost_node = null;

		// Go through each node
		for (Entry<String, Double> node : costs.entrySet()) {
			Double cost = node.getValue();
			// Check if it's the lowest cost so far AND hasn't been processed yet
			if (cost < lowest_cost && !processed.contains(node.getKey())) {
				// update the new lowest-cost node
				lowest_cost = cost;
				lowest_cost_node = node.getKey();
			}
		}

		return lowest_cost_node;
	}

	private static void dijkstras() {
		String node = findLowestCostNode();
		while (node != null) {
			Double cost = costs.get(node);

			// Go through all neighbors of the current node
			HashMap<String, Double> neighbors = graph.get(node);

			for (String n : neighbors.keySet()) {
				Double new_cost = cost + neighbors.get(n);

				// If it's cheaper to get to this neighbor through the current node
				if (new_cost < costs.get(n)) {
					// update the cost for this neighbor
					costs.put(n, new_cost);
					// and the current node becomes the parent of this neighbor
					parents.put(n, node);
				}
			}

			// Mark current node as processed
			processed.add(node);

			// Find the next node to process, and loop
			node = findLowestCostNode();
		}
	}

	// recursive
	private static String lowest_cost_path_r(String node) {
		// base case
		if (parents.get(node) == null) {
			return node;
		}

		// recursive case
		return lowest_cost_path_r(parents.get(node)) + " -> " + node;
	}
	
	// iterative
	private static List<String> lowest_cost_path_i(String node) {
		List<String> path = new ArrayList<>(Arrays.asList(node));
		String next_node = parents.get(node);
		while (next_node != null) {
			path.add(next_node);
			next_node = parents.get(next_node);
		}
		Collections.reverse(path);
		return path;
	}

	public static void main(String[] args) {
		// Fill the graph
		graph.put("start", new HashMap<>());
		graph.get("start").put("a", 6.0);
		graph.get("start").put("b", 2.0);

		graph.put("a", new HashMap<>());
		graph.get("a").put("fin", 1.0);

		graph.put("b", new HashMap<>());
		graph.get("b").put("a", 3.0);
		graph.get("b").put("fin", 5.0);

		graph.put("fin", new HashMap<>());

		// Fill the costs table
		costs.put("a", 6.0);
		costs.put("b", 2.0);
		costs.put("fin", Double.POSITIVE_INFINITY);

		// Fill the parents table
		parents.put("a", "start");
		parents.put("b", "start");
		parents.put("fin", null);

		// Execute Dijkstra's Algorithm
		dijkstras();

		// Print lowest cost path
		// recursive
		System.out.println(lowest_cost_path_r("fin")); // start -> b -> a -> fin
		
		// iterative
		System.out.println((lowest_cost_path_i("fin"))); // [start, b, a, fin]

	}

}
