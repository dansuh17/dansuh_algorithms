import java.io.*;
import java.util.*;

/**
 * 백준 문제 1967번 '트리의 지름'
 * https://www.acmicpc.net/problem/1967
 */
public class RadiusOfTree2 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(bf.readLine().trim());
    RadiusOfTree2Tree tree = new RadiusOfTree2Tree(N);

    // create the tree
    for (int n = 0; n < N - 1; n++) {
      String[] strOpts = bf.readLine().trim().split(" ");
      int from = Integer.parseInt(strOpts[0]);
      int to = Integer.parseInt(strOpts[1]);
      int weight = Integer.parseInt(strOpts[2]);
      tree.addEdge(from, to, weight);
    }

    int[] bfsResults = tree.bfs(1);
    int[] bfsResults2 = tree.bfs(bfsResults[0]);

    bw.write(bfsResults2[1] + "\n");
    bw.close();
  }
}

class RadiusOfTree2Tree {
  int V;
  List<RadiusOfTree2Node> nodes;
  int[][] weights;

  RadiusOfTree2Tree(int V) {
    this.V = V;
    this.nodes = new ArrayList<>();
    for (int v = 0; v < V + 1; v++) {
      this.nodes.add(new RadiusOfTree2Node(v));
    }
    this.weights = new int[V + 1][V + 1];  // stores the weight info
  }

  public void addEdge(int from, int to, int weight) {
    RadiusOfTree2Node fromNode = this.nodes.get(from);
    RadiusOfTree2Node toNode = this.nodes.get(to);

    fromNode.connected.add(toNode);
    toNode.connected.add(fromNode);

    weights[from][to] = weight;
    weights[to][from] = weight;
  }

  public int[] bfs(int startNode) {
    Queue<RadiusOfTree2Node> queue = new LinkedList<>();
    boolean[] visited = new boolean[this.V + 1];
    int[] distances = new int[this.V + 1];
    Arrays.fill(distances, -1);
    distances[startNode] = 0;
    int maxDistance = -1;
    int maxDistNode = 0;

    // add the starting point
    queue.add(this.nodes.get(startNode));

    while (!queue.isEmpty()) {
      RadiusOfTree2Node thisNode = queue.poll();
      int thisDist = distances[thisNode.name];

      // update max distance
      if (thisDist > maxDistance) {
        maxDistance = thisDist;
        maxDistNode = thisNode.name;
      }

      for (RadiusOfTree2Node connectedNode : thisNode.connected) {
        if (visited[connectedNode.name]) {
          continue;
        }

        visited[connectedNode.name] = true;
        distances[connectedNode.name] = thisDist + weights[thisNode.name][connectedNode.name];
        queue.add(connectedNode);
      }
    }

    return new int[] {maxDistNode, maxDistance};
  }
}

class RadiusOfTree2Node {
  int name;
  List<RadiusOfTree2Node> connected;

  RadiusOfTree2Node(int name) {
    this.name = name;
    this.connected = new ArrayList<>();
  }
}