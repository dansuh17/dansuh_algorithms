import java.io.*;
import java.util.*;

/**
 * 백준 문제 1167번 '트리의 지름'
 * https://www.acmicpc.net/problem/1167
 */
public class RadiusOfTree {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int V = Integer.parseInt(bf.readLine());
    Tree tree = new Tree(V);

    for (int v = 0; v < V; v++) {
      String[] optStrs = bf.readLine().split(" ");
      int numOpts = optStrs.length;
      int from = -1;
      int to = -1;

      for (int i = 0; i < numOpts - 1; i++) {
        if (i == 0) {
          from = Integer.parseInt(optStrs[0]) - 1;
        } else if (i % 2 == 1) {
          to = Integer.parseInt(optStrs[i]) - 1;
        } else {
          int length = Integer.parseInt(optStrs[i]);
          tree.addEdge(from, to, length);
        }
      }
    }

    // start from any node to find the one end of the radius,
    // then start another bfs from that end to find the other end of the radius.
    int[] oneEnd = bfs(tree,0);
    int[] otherEnd = bfs(tree, oneEnd[0]);

    // print the result
    bw.write(otherEnd[1] + "\n");
    bw.close();
  }

  /**
   * Starting from ROOT from TREE, find the node that gives maximum node and maximum length.
   * @param tree tree
   * @param root starting point
   * @return int[] {maxNode, maxLength}
   */
  public static int[] bfs(Tree tree, int root) {
    int maxLength = 0;
    int maxNode = root;
    Queue<Integer> queue = new LinkedList<>();
    int[] distance = new int[tree.V];
    boolean[] visited = new boolean[tree.V];
    distance[root] = 0;
    queue.add(root);

    // perform breadth first search
    while (!queue.isEmpty()) {
      int currNode = queue.poll();
      int currDist = distance[currNode];

      // check for maximum distance
      if (currDist > maxLength) {
        maxLength = currDist;
        maxNode = currNode;
      }

      visited[currNode] = true;  // mark visited

      // traverse through the children and update the lengths
      ArrayList<Edge> children = tree.dag.get(currNode);
      for (Edge edge : children) {
        int child = edge.to;
        if (!visited[child]) {
          queue.add(child);
          distance[child] = currDist + edge.length;
        }
      }
    }

    return new int[] {maxNode, maxLength};
  }
}

class Tree {
  int V;
  List<ArrayList<Edge>> dag;
  Tree(int V) {
    this.V = V;
    dag = new ArrayList<>();

    for (int v = 0; v < V; v++) {
      dag.add(new ArrayList<>());
    }
  }

  void addEdge(int from, int to, int length) {
    dag.get(from).add(new Edge(from, to, length));
  }
}

class Edge {
  int length;
  int from;
  int to;

  Edge(int from, int to, int length) {
    this.from = from;
    this.to = to;
    this.length = length;
  }
}