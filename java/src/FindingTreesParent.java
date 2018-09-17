import java.io.*;
import java.util.*;

/**
 * 백준 문제 11725번 '트리의 부모 찾기'
 * https://www.acmicpc.net/problem/11725
 */
public class FindingTreesParent {
  public static void main(String[] args) throws IOException, NullPointerException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(bf.readLine());
    List<Node2> tree = new ArrayList<>(N);

    for (int n = 0; n < N; n++) {
      tree.add(new Node2(n + 1));
    }

    for (int n = 0; n < N - 1; n++) {
      String[] relationStrs = bf.readLine().split(" ");
      int n1 = Integer.parseInt(relationStrs[0]);
      int n2 = Integer.parseInt(relationStrs[1]);

      Node2 node1 = tree.get(n1 - 1);
      Node2 node2 = tree.get(n2 - 1);

      node1.connected.add(node2);
      node2.connected.add(node1);
    }

    // define the root
    Node2 currRoot = tree.get(0);
    currRoot.parent = new Node2(0);  // dummy node to indicate root

    // start traversing the tree and complete the tree
    preOrderTraverseOrganize(currRoot);

    // print the results
    for (int i = 1; i < N; i++) {
      bw.write(tree.get(i).parent.name + "\n");
    }

    bw.close();
  }

  /**
   * Traverse the tree using pre-order traversal. Organize the parent-child relationship.
   * @param currNode node to start the traversal
   */
  public static void preOrderTraverseOrganize(Node2 currNode) {
    currNode.organizeChild();

    for (Node2 child : currNode.children) {
      preOrderTraverseOrganize(child);
    }
  }
}

class Node2 {
  int name;
  int index;
  List<Node2> connected;
  Node2 parent;
  List<Node2> children;

  Node2(int name) {
    this.name = name;
    this.index = name - 1;
    this.connected = new ArrayList<>();
    this.children = new ArrayList<>();
    this.parent = null;
  }

  public void organizeChild() {
    if (parent == null) {
      throw new NullPointerException("Cannot organize child when parent is null");
    }

    for (Node2 connectedNode : connected) {
      if (connectedNode.name != parent.name) {
        connectedNode.parent = this;
        children.add(connectedNode);
      }
    }
  }
}