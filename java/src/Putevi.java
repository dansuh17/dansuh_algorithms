import java.util.*;
import java.io.*;

/**
 * 백준 문제 1289번 '트리의 가중치 (Putevi)'
 * https://www.acmicpc.net/problem/1289
 */
public class Putevi {
  static private final int MOD = 1000000007;
  static private long ans = 0;
  static boolean[] visited;
  static private Node[] node;

  public static void main(String args[]) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(bf.readLine());
    node = new Node[N + 1];

    for(int i = 0; i <= N; i++) {
      node[i] = new Node();
    }

    for (int i = 1; i < N; i++) {
      StringTokenizer st;
      st = new StringTokenizer(bf.readLine(), " ");
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      node[u].add(v, w);
      node[v].add(u, w);
    }

    visited = new boolean[N + 1];

    dfs(1);  // start from root == 1

    bw.write(ans + "");
    bw.close();
  }

  // The answer can be broken down into two parts: the paths that climbs up the tree
  // + the paths that go down again to another subtree

  // The output of this method == the sum of all weights of paths that ENDS at current node + 1.

  // The output can be calculated by taking the sum of : weight of edge that connects to the child *
  // the output value for that child.

  // However, the final answer should also include combinations of inter-tree paths.
  // By simply multiplying all the outputs of the child nodes, the sum of weights for
  // all combinations of inter-tree paths can be derived.
  static long dfs(int curr) {
    visited[curr] = true;
    long tp;
    long out = 1;  // magical!
    int nextNode;
    int weight;

    for (int i = 0; i < node[curr].size; i++) {
      nextNode = node[curr].next.get(i);

      if (visited[nextNode]) {
        continue;
      }

      // retrieve the weight to curr -> i (child)
      weight = node[curr].weights.get(i);

      tp = (dfs(nextNode) * weight) % MOD;
      // multiply the inter-sub-tree paths' weights
      ans = (ans + tp * out) % MOD;
      // output contains the sum of path weights that ENDS at current node
      out = (out + tp) % MOD;
    }

    return out;
  }

  // represents a tree node
  static class Node {
    int size;
    ArrayList<Integer> next;
    ArrayList<Integer> weights;

    Node() {
      size = 0;
      next = new ArrayList<>();
      weights = new ArrayList<>();
    }

    void add(int connection, int weight) {
      size++;
      next.add(connection);
      this.weights.add(weight);
    }
  }
}