import java.util.*;
public class everyPath {
        private static void findPaths(Map<String, List<String>> graph, String u, String w, List<String> path, int length) {
            //add current path to the vertex
            path.add(u);
            length++;

            if (u.equals(w) && length == 5) {
                System.out.println(path);
                return;
            }
            //if length takes longer than 5, stop looking
            if (length > 5) {
                return;
            }

            //find paths to neighbors
            for (String neighbor : graph.getOrDefault(u, new ArrayList<>())) {
                if (!path.contains(neighbor)) {
                    findPaths(graph, neighbor, w, new ArrayList<>(path), length);
                }
            }
        }
        public static void main(String[] args) {
            Map<String, List<String>> graph = new HashMap<>();
            graph.put("A", List.of("B", "C"));
            graph.put("B", List.of("C", "D"));
            graph.put("C", List.of("D"));
            graph.put("D", List.of("E"));
            graph.put("E", new ArrayList<>());

            //vertices u and w
            String u = "A";
            String w = "E";

            System.out.println("paths from " + u + " to " + w);
            findPaths(graph, u, w, new ArrayList<>(), 0);
        }
    }

