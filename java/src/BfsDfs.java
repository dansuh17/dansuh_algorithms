import java.io.*;
import java.util.*;

/**
 * 백준 문제 1260번 'DFS와 BFS'
 * https://www.acmicpc.net/problem/1260
 */
public class BfsDfs {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String[] inputs = bf.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]);
    int M = Integer.parseInt(inputs[1]);
    int V = Integer.parseInt(inputs[2]);

    int[][] edges = new int[N + 1][N + 1];

    // input edges
    for (int m = 0; m < M; m++) {
      String[] edgeStr = bf.readLine().split(" ");
      int from = Integer.parseInt(edgeStr[0]);
      int to = Integer.parseInt(edgeStr[1]);

      // bi-directional
      edges[from][to] = 1;
      edges[to][from] = 1;
    }

    dfs(N, edges, V);
    bfs(N, edges, V);
  }

  // conduct a DFS
  static void dfs(int N, int[][] edges, int start) {
    boolean[] visited = new boolean[N + 1];
    Stack<Integer> stack = new Stack<>();
    stack.push(start);

    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (visited[node]) continue;  // if already visited, ignore
      System.out.print(node + " ");  // print the result
      visited[node] = true;

      int[] edgesFromNode = edges[node];
      // push into stack larger first, since it should visit smaller numbered node fist
      for (int i = edgesFromNode.length - 1; i >= 0; i--) {
        if (edgesFromNode[i] == 1 && !visited[i]) {
          stack.push(i);
        }
      }
    }

    System.out.println();
  }

  // conduct a BFS
  static void bfs(int N, int[][] edges, int start) {
    boolean[] visited = new boolean[N + 1];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      int node = queue.poll();
      if (visited[node]) continue;  // if already visited, ignore
      System.out.print(node + " ");
      visited[node] = true;

      int[] edgeFromNode = edges[node];
      for (int i = 0; i < edgeFromNode.length; i++) {
        if (edgeFromNode[i] == 1 && !visited[i]) {
          queue.add(i);
        }
      }
    }

    System.out.println();
  }
}
