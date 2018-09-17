import java.io.*;
import java.util.*;

/**
 * 백준 문제 1991번 '트리 순회'
 * https://www.acmicpc.net/problem/1991
 *
 * Work with three different traversal for trees -
 * pre-order traversal, in-order traversal, and post-order traversal
 */
public class TraverseTree {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(bf.readLine());
    Nodes nodes = new Nodes();

    // parse the strings and create a tree
    for (int i = 0; i < N; i++) {
      String nodeStrs = bf.readLine();
      char headNodeChar = nodeStrs.charAt(0);
      char leftChildChar = nodeStrs.charAt(2);
      char rightChildChar = nodeStrs.charAt(4);

      Node headNode = nodes.getNodeByChar(headNodeChar);
      Node leftNode = nodes.getNodeByChar(leftChildChar);
      Node rightNode = nodes.getNodeByChar(rightChildChar);

      headNode.setLeftChild(leftNode);
      headNode.setRightChild(rightNode);
    }

    Node root = nodes.getNodeByChar('A');

    List<Node> preOrderTraverseResult = root.preOrderTraversal(null);
    StringBuilder sb = new StringBuilder();
    for (Node node : preOrderTraverseResult) {
      sb.append(node.name);
    }
    bw.write(sb.toString() + "\n");


    List<Node> inOrderTraverseResult = root.inOrderTraversal(null);
    sb = new StringBuilder();
    for (Node node : inOrderTraverseResult) {
      sb.append(node.name);
    }
    bw.write(sb.toString() + "\n");

    List<Node> postOrderTraverseResult = root.postOrderTraversal(null);
    sb = new StringBuilder();
    for (Node node : postOrderTraverseResult) {
      sb.append(node.name);
    }
    bw.write(sb.toString() + "\n");

    bw.close();
  }
}

// manager class for all tree nodes
class Nodes {
  Node[] nodes;
  Nodes() {
    this.nodes = new Node[26];
    Arrays.fill(this.nodes, null);
  }

  Node getNodeByChar(char c) {
    if (c == '.') {
      return null;
    }

    int idx = c - 'A';
    Node node = this.nodes[idx];

    if (node == null) {
      node = new Node(c);
      this.nodes[idx] = node;
    }

    return node;
  }
}

// represents a single node
class Node {
  char name;
  Node rightChild = null;
  Node leftChild = null;
  Node(char name) {
    this.name = name;
  }

  void setRightChild(Node rightChild) {
    this.rightChild = rightChild;
  }

  void setLeftChild(Node leftChild) {
    this.leftChild = leftChild;
  }

  // pre order traversal ~= depth-first traversal
  List<Node> preOrderTraversal(List<Node> nodeLog) {
    if (nodeLog == null) nodeLog = new ArrayList<>();

    nodeLog.add(this);
    if (leftChild != null) {
      this.leftChild.preOrderTraversal(nodeLog);
    }

    if (rightChild != null) {
      this.rightChild.preOrderTraversal(nodeLog);
    }

    return nodeLog;
  }

  // in order traversal
  List<Node> inOrderTraversal(List<Node> nodeLog) {
    if (nodeLog == null) nodeLog = new ArrayList<>();

    if (leftChild != null) {
      this.leftChild.inOrderTraversal(nodeLog);
    }

    nodeLog.add(this);

    if (rightChild != null) {
      this.rightChild.inOrderTraversal(nodeLog);
    }

    return nodeLog;
  }

  // post-order traversal
  List<Node> postOrderTraversal(List<Node> nodeLog) {
    if (nodeLog == null) nodeLog = new ArrayList<>();

    if (leftChild != null) {
      this.leftChild.postOrderTraversal(nodeLog);
    }

    if (rightChild != null) {
      this.rightChild.postOrderTraversal(nodeLog);
    }

    nodeLog.add(this);

    return nodeLog;
  }
}