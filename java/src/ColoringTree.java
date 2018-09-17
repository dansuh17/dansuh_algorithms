import java.io.*;
import java.util.*;


/**
 * 백준 문제 1693번 '트리 색칠하기'
 * https://www.acmicpc.net/problem/1693
 */
public class ColoringTree {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(bf.readLine().trim());
    ColoringTreeTree tree = new ColoringTreeTree(N);
    for (int n = 0; n < N - 1; n++) {
      String[] optStrs = bf.readLine().trim().split(" ");
      int from = Integer.parseInt(optStrs[0]);
      int to = Integer.parseInt(optStrs[1]);

      tree.addEdge(from, to);  // add edge to tree
    }

    int minCost = tree.color();

    bw.write(minCost + "\n");
    bw.close();
  }
}


class ColoringTreeTree {
  int V;
  List<ArrayList<Integer>> edges;

  ColoringTreeTree(int V) {
    this.V = V;
    this.edges = new ArrayList<>();
    for (int v = 0; v < V + 1; v++) {
      this.edges.add(new ArrayList<>());
    }
  }

  void addEdge(int from, int to) {
    this.edges.get(from).add(to);
    this.edges.get(to).add(from);
  }

  int color() {
    // the total number of colors required to find the minimum cost is log_2(num_nodes).
    // WHY??
    final int NUMCOLOR = 18;
    int[][] minColor = new int[NUMCOLOR][this.V + 1];
    for (int i = 0; i < NUMCOLOR; i++) {
      Arrays.fill(minColor[i], -1);
    }

    // dynamic programming : minColor[i][j] means the minimum cost required for
    // coloring the subtree taking node j as root, where j is colored with color i.
    // minColor[i][j] = i + sum( min(minColor[c != i][k]) ), where k are j's child nodes,
    // and c being a color different from i.
    int root = 1;
    int minCost = Integer.MAX_VALUE;
    for (int c = 0; c < NUMCOLOR; c++) {
      int colorMinCost = findMinimumColor(root, c, minColor, new boolean[this.V + 1], NUMCOLOR);
      if (minCost > colorMinCost) {
        minCost = colorMinCost;
      }
    }

    return minCost;
  }

  int findMinimumColor(int node, int color, int[][] colorMap, boolean[] visited, int numColors) {
    if (colorMap[color][node] != -1) {
      return colorMap[color][node];
    }

    visited[node] = true;  // mark visited
    int minCost = color + 1;
    ArrayList<Integer> connectedNodes = this.edges.get(node);

    for (int connectedNode : connectedNodes) {
      if (visited[connectedNode]) {  // ignore if visited (i.e. is parent)
        continue;
      }

      // find the minimum cost across colors where the color doesn't equal the current color
      int childMinCost = Integer.MAX_VALUE;
      for (int c = 0; c < numColors; c++) {
        if (c == color) {  // ignore equal color
          continue;
        }

        int childCostForColor = findMinimumColor(connectedNode, c, colorMap, visited, numColors);
        if (childMinCost > childCostForColor) {
          childMinCost = childCostForColor;
        }
      }

      minCost += childMinCost;
    }

    visited[node] = false;
    colorMap[color][node] = minCost;  // memoize
    return minCost;
  }
}
