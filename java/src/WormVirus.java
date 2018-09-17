import java.io.*;
import java.util.*;

/**
 * 백준 문제 2606번 '바이러스'
 * https://www.acmicpc.net/problem/2606
 */
public class WormVirus {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine().trim());  // number of computers
    int E = Integer.parseInt(bf.readLine().trim());  // number of edges

    Virus virus = new Virus(N);
    for (int e = 0; e < E; e++) {
      String[] strs = bf.readLine().split(" ");
      int from = Integer.parseInt(strs[0]);
      int to = Integer.parseInt(strs[1]);
      virus.addEdge(from, to);
    }

    System.out.println(infected(virus));
  }

  public static int infected(Virus virus) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(1);  // root
    virus.visited[1] = true;

    int infected = 0;

    // DFS
    while (!stack.isEmpty()) {
      int nowInfected = stack.pop();
      infected++;

      for (int nextTarget : virus.connections.get(nowInfected)) {
        if (!virus.visited[nextTarget]) {
          stack.push(nextTarget);
          virus.visited[nextTarget] = true;
        }
      }
    }

    return infected - 1;  // do not include 1번 컴퓨터
  }
}

class Virus {
  int N;
  List<ArrayList<Integer>> connections;
  boolean[] visited;

  Virus(int N) {
    this.N = N;
    this.visited = new boolean[N + 1];
    this.connections = new ArrayList<>(N + 1);  // computers indexed from 1

    for (int n = 0; n <= N; n++) {
      connections.add(new ArrayList<Integer>());
    }
  }

  void addEdge(int i, int j) {
    connections.get(i).add(j);
    connections.get(j).add(i);
  }
}
