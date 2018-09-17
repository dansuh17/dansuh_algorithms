import java.io.*;
import java.util.*;

/**
 * 백준 문제 1325번 '효율적인 해킹'
 * https://www.acmicpc.net/problem/1325
 */
public class EffectiveHacking {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] strOpts = bf.readLine().trim().split(" ");
    int N = Integer.parseInt(strOpts[0]);
    int M = Integer.parseInt(strOpts[1]);

    List<ArrayList<Integer>> trust = new ArrayList<>();

    for (int n = 0; n < N + 1; n++) {
      trust.add(new ArrayList<>());
    }

    // draw the graph : trust FROM -> TO, but the graph must have opposite directions
    // to obtain the subgraph's size
    for (int m = 0; m < M; m++) {
      String[] trustRel = bf.readLine().trim().split(" ");
      int from = Integer.parseInt(trustRel[0]);
      int to = Integer.parseInt(trustRel[1]);

      trust.get(to).add(from);
    }

    int[] clusterSize = new int[N + 1];
    Arrays.fill(clusterSize, 1);

    // run BFS on all nodes
    for (int n = 1; n < N + 1; n++) {
      boolean[] visited = new boolean[N + 1];
      visited[n] = true;
      bfs(trust, visited, n, clusterSize, n);
    }

    // find the max cluster size
    int maxSize = 0;
    for (int n = 1; n < N + 1; n++) {
      int size = clusterSize[n];

      if (maxSize < size) {
        maxSize = size;
      }
    }

    // find nodes having max cluster size
    List<Integer> idxHavingMaxSize = new ArrayList<>();
    for (int n = 1; n < N + 1; n++) {
      if (clusterSize[n] == maxSize) {
        idxHavingMaxSize.add(n);
      }
    }

    // sort the indexes having maximum cluster size in order
    Collections.sort(idxHavingMaxSize);
    for (int n : idxHavingMaxSize) {
      bw.write(n + " ");
    }

    bw.write("\n");
    bw.close();
  }

  public static void bfs(List<ArrayList<Integer>> trust, boolean[] visited,
                        int startNode, int[] clusterSize, int nextNode) {
    ArrayList<Integer> children = trust.get(nextNode);
    for (int child : children) {
      if (!visited[child]) {
        clusterSize[startNode]++;
        visited[child] = true;
        bfs(trust, visited, startNode, clusterSize, child);
      }
    }
  }
}