import java.io.*;
import java.util.*;

/**
 * 백준 문제 10216번 'Count Circle Groups'
 * https://www.acmicpc.net/problem/10216
 *
 * Finding number of disjoint group.
 */
public class CountCircleGroups {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(bf.readLine().trim());
    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(bf.readLine().trim());
      Node_10216[] nodes = new Node_10216[N];

      for (int n = 0; n < N; n++) {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // make the map
        Node_10216 thisNode = new Node_10216(x, y, R);
        nodes[n] = thisNode;
      }

      // conduct bfs
      boolean[] visited = new boolean[N];
      int numGroups = 0;
      for (int n = 0; n < N; n++) {
        if (visited[n]) {
          continue;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);  // start from this root
        visited[n] = true;

        while (!queue.isEmpty()) {
          int thisNodeNum = queue.poll();
          Node_10216 thisNode = nodes[thisNodeNum];

          for (int i = 0; i < N; i++) {
            if (!visited[i] && thisNode.isClose(nodes[i])) {
              queue.add(i);
              visited[i] = true;
            }
          }
        }

        // if done, one group is formed
        numGroups++;
      }

      bw.write(numGroups + "\n");
    }

    bw.close();
  }
}

class Node_10216 {
  int x;
  int y;
  int R;
  Node_10216(int x, int y, int R) {
    this.x = x;
    this.y = y;
    this.R = R;
  }

  // the distance btwn centers should be smaller than sum of radius
  boolean isClose(Node_10216 other) {
    int xDiff = other.x - this.x;
    int yDiff = other.y - this.y;
    int sumR = other.R + this.R;
    return (xDiff * xDiff) + (yDiff * yDiff) <= (sumR * sumR);
  }
}