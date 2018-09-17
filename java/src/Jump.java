import java.io.*;
import java.util.*;

/**
 * 백준 문제 1890번 '점프'
 * https://www.acmicpc.net/problem/1890
 *
 * BFS version - TIMEOUT
 * O(nm), n = number of nodes, m = number of connections
 * This implementation will only be effective if the graph is guaranteed to be sparse.
 * For dense graph, dynamic programming version will be better.
 */
public class Jump {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(bf.readLine().trim());

    // draw the map
    int[][] map = new int[N][N];
    for (int i = 0; i < N; i++) {
      String[] rowStr = bf.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(rowStr[j]);
      }
    }

    // conduct two BFS from both directions - this will find the available paths
    Node_1890[][] nodes = new Node_1890[N][N];
    nodes[0][0] = new Node_1890(0, 0, map[0][0]);

    // BFS from starting node to create the graph
    // no need to check VISITED because it is guaranteed
    // from the problem that no cycle exists
    Queue<Node_1890> queue = new LinkedList<>();
    queue.add(nodes[0][0]);
    while (!queue.isEmpty()) {
      Node_1890 thisNode = queue.poll();

      int reach = thisNode.reach;
      if (reach == 0) {
        continue;
      }

      // two possible moves
      for (int i = 0; i < 2; i++) {
        int x = thisNode.x;
        int y = thisNode.y;
        if (i == 0) {
          x += reach;
        } else {
          y += reach;
        }

        // within the map
        if (x < N && y < N) {
          Node_1890 nextNode;
          // create a new node if it has never been created
          if (nodes[x][y] == null) {
            nextNode = new Node_1890(x, y, map[x][y]);
            nodes[x][y] = nextNode;
          } else {
            nextNode = nodes[x][y];
          }

          nextNode.addParent(thisNode);
          queue.add(nextNode);
        }
      }
    }

    // reverse BFS to check for all reachable nodes
    nodes[0][0].numWays = 1;  // start node
    long res = numDifferentWays(nodes[N - 1][N - 1]);

    // print the number of possible ways
    bw.write(res + "\n");
    bw.close();
  }

  static long numDifferentWays(Node_1890 toNode) {
    if (toNode.numWays != -1) {
      return toNode.numWays;
    }

    long toNodeNumWays = 0;
    for (Node_1890 parent : toNode.parents) {
      toNodeNumWays += numDifferentWays(parent);
    }

    toNode.numWays = toNodeNumWays;
    return toNodeNumWays;
  }
}

class Node_1890 {
  int x;
  int y;
  int reach;
  long numWays;
  List<Node_1890> parents;

  Node_1890(int x, int y, int reach) {
    this.x = x;
    this.y = y;
    this.reach = reach;
    this.parents = new ArrayList<>();
    this.numWays = -1;
  }

  void addParent(Node_1890 parent) {
    parents.add(parent);
  }
}