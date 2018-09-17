import java.io.*;
import java.util.*;

/**
 * 백준 문제 10216번 'Count Circle Groups'
 * https://www.acmicpc.net/problem/10216
 *
 * Finding number of disjoint group.
 * This implementation uses Union-Find data structure.
 * For implementation using BFS, refer to CountCircleGroups.java.
 *
 * Nice explanation about UnionFind data structure is here:
 * http://bowbowbow.tistory.com/26#recentComments
 *
 * About 1/2 time taken compared to BFS.
 */
public class CountCircleGroups2 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(bf.readLine().trim());
    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(bf.readLine().trim());

      CCGUnionFind unionFind = new CCGUnionFind(N);
      CCGNode[] nodes = new CCGNode[N];

      for (int n = 0; n < N; n++) {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        nodes[n] = new CCGNode(x, y, R);
      }

      for (int n = 0; n < N; n++) {
        CCGNode thisNode = nodes[n];
        for (int k = n + 1; k < N; k++) {
          CCGNode thatNode = nodes[k];
          if (thisNode.isConnected(thatNode)) {
            unionFind.union(n, k);  // simply UNION the sets
          }
        }
      }

      bw.write(unionFind.numSets + "\n");
    }

    bw.close();
  }
}

class CCGNode {
  int x;
  int y;
  int R;

  CCGNode(int x, int y, int R) {
    this.x = x;
    this.y = y;
    this.R = R;
  }

  boolean isConnected(CCGNode otherNode) {
    int xDiff = otherNode.x - this.x;
    int yDiff = otherNode.y - this.y;
    int rSum = otherNode.R + this.R;
    return (xDiff * xDiff) + (yDiff * yDiff) <= (rSum * rSum);
  }
}

class CCGUnionFind {
  List<Integer> parent;
  List<Integer> rank;
  int numSets;

  CCGUnionFind(int n) {
    this.parent = new ArrayList<>();
    this.rank = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      this.parent.add(i);
      this.rank.add(1);
    }


    this.numSets = n;
  }

  // find operation finds the root of the set represented as a tree
  int find(int v) {
    if (parent.get(v) == v) {
      return v;
    }

    return find(parent.get(v));
  }

  // union operation makes a union set of two trees by simply setting the root node's parent
  // to other tree's root
  void union(int u, int v) {
    u = find(u);
    v = find(v);

    if (u == v) {
      return;
    }

    if (rank.get(u) < rank.get(v)) {
      this.parent.set(u, v);
      this.rank.set(v, rank.get(u) + rank.get(v));
    } else {
      this.parent.set(v, u);
      this.rank.set(u, rank.get(v) + rank.get(u));
    }

    this.numSets--;
  }
}