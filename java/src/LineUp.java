import java.io.*;
import java.util.*;

/**
 * 백준 문제 2252번 '줄 세우기'
 * https://www.acmicpc.net/problem/2252
 *
 * Topological Sorting using Graph class (practice implementation)
 */
public class LineUp {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] inputStrs = bf.readLine().split(" ");
    int N = Integer.parseInt(inputStrs[0]);
    int M = Integer.parseInt(inputStrs[1]);

    Graph dag = new Graph(N);

    // receive relationships
    for (int m = 0; m < M; m++) {
      String[] compareStrs = bf.readLine().split(" ");
      int beforeStudent = Integer.parseInt(compareStrs[0]) - 1;
      int affterStudent = Integer.parseInt(compareStrs[1]) - 1;

      dag.addEdge(beforeStudent, affterStudent);
    }

    // topological sort
    Stack<StudentNode> linedUp = dag.lineUp();

    // print the results
    while(!linedUp.isEmpty()) {
      StudentNode frontStudent = linedUp.pop();
      bw.write((frontStudent.id + 1) + " ");
    }
    bw.write("\n");
    bw.close();
  }
}

class Graph {
  int V;
  StudentNode[] nodes;
  Graph (int V) {
    this.V = V;
    this.nodes = new StudentNode[V];

    for (int v = 0; v < V; v++) {
      this.nodes[v] = new StudentNode(v);
    }
  }

  void addEdge(int before, int after) {
    StudentNode beforeNode = this.nodes[before];
    StudentNode afterNode = this.nodes[after];

    beforeNode.addAfter(afterNode);
    afterNode.addBefore(beforeNode);
  }

  Stack<StudentNode> lineUp() {
    Stack<StudentNode> stack = new Stack<>();
    boolean[] visited = new boolean[V];

    for (int v = 0; v < V; v++) {
      boolean leafFound = false;
      for (int m = 0; m < V; m++) {
        if (this.nodes[m].outDegree == 0 && !visited[m]) {
          StudentNode leaf = this.nodes[m];
          leaf.removeMyselfAsLeaf();
          stack.push(leaf);

          visited[m] = true; // mark visited
          leafFound = true;
        }
      }

      if (!leafFound) {
        // impossible - cycle exists
        break;
      }
    }

    return stack;
  }
}

class StudentNode {
  int id;
  int inDegree;
  int outDegree;
  List<StudentNode> to;
  List<StudentNode> from;

  StudentNode(int id) {
    this.id = id;
    this.inDegree = 0;
    this.to = new LinkedList<>();
    this.from = new LinkedList<>();
  }

  void addBefore(StudentNode beforeNode) {
    from.add(beforeNode);
    inDegree++;
  }

  void addAfter(StudentNode afterNode) {
    to.add(afterNode);
    outDegree++;
  }

  // very bad way of managing nodes.........
  void removeAfterNode(int afterNodeId) {
    for (StudentNode child : to) {
      if (child.id == afterNodeId) {
        to.remove(child);
        outDegree--;
        break;
      }
    }
  }

  void removeMyselfAsLeaf() {
    for (StudentNode parent : from) {
      parent.removeAfterNode(id);
    }
  }
}