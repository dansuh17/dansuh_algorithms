import java.util.*;


public class BFS {
  private int V;  // vertices
  private List<LinkedList<Integer>> adj;  // adjacency list

  BFS(int numVertex) {
    V = numVertex;
    adj = new ArrayList<LinkedList<Integer>>();
    for (int i = 0; i < numVertex; i++) {
      adj.add(new LinkedList<Integer>());
    }
  }

  void addEdge(int from, int to) {
    adj.get(from).add(to);
  }

  void search(int source) {
    boolean visited[] = new boolean[V];
    Queue<Integer> queue = new LinkedList<Integer>();

    visited[source] = true;
    queue.add(source);

    while(queue.size() != 0) {
      source = queue.poll();
      System.out.println("Poll " + source);

      Iterator<Integer> iterator = adj.get(source).listIterator();
      while(iterator.hasNext()) {
        int n = iterator.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }

  public static void main(String[] args) {
    BFS bfs = new BFS(4);
    bfs.addEdge(0, 1);
    bfs.addEdge(0, 2);
    bfs.addEdge(1, 2);
    bfs.addEdge(2, 0);
    bfs.addEdge(2, 3);
    bfs.addEdge(3, 3);

    bfs.search(2);
  }
}
