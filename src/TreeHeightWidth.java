import java.io.*;
import java.util.*;

/**
 * 백준 문제 2250번 '트리의 넓이와 지름'
 * https://www.acmicpc.net/problem/2250
 */
public class TreeHeightWidth {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(bf.readLine().trim());
    BinTree tree = new BinTree(N);

    for (int n = 0; n < N; n++) {
      String[] argOpts = bf.readLine().split(" ");
      int thisNode = Integer.parseInt(argOpts[0]);
      int leftNode = Integer.parseInt(argOpts[1]);
      int rightNode = Integer.parseInt(argOpts[2]);

      if (leftNode != -1) {
        tree.nodes[thisNode].leftNode = tree.nodes[leftNode];
        tree.nodes[leftNode].parentNode = tree.nodes[thisNode];
      }

      if (rightNode != -1) {
        tree.nodes[thisNode].rightNode = tree.nodes[rightNode];
        tree.nodes[rightNode].parentNode = tree.nodes[thisNode];
      }
    }

    tree.findRootNode();  // find the root node

    // contains position values per level
    List<ArrayList<Integer>> byLevel = tree.drawTree();

    // find the maximum level and its width
    int maxLevel = 0;
    int maxWidth = 0;
    for (int i = 1; i < byLevel.size(); i++) {
      ArrayList<Integer> levelNodePos = byLevel.get(i);
      Collections.sort(levelNodePos);

      // width == maxpos - minpos + 1
      int width = levelNodePos.get(levelNodePos.size() - 1) - levelNodePos.get(0) + 1;

      // update maximum
      if (width > maxWidth) {
        maxWidth = width;
        maxLevel = i;
      }
    }

    bw.write(maxLevel + " " + maxWidth);
    bw.close();
  }
}

class BinTree {
  int V;
  BinTreeNode[] nodes;
  BinTreeNode rootNode;
  int maxLevel;

  BinTree(int V) {
    this.V = V;
    this.nodes = new BinTreeNode[V + 1];

    for (int v = 1; v < V + 1; v++) {
      this.nodes[v] = new BinTreeNode(v);
    }
    this.maxLevel = 0;
  }

  public void findRootNode() {
    BinTreeNode randomNode = this.nodes[1];

    // traverse upwards until it hits the root
    while (randomNode.parentNode != null) {
      randomNode = randomNode.parentNode;
    }

    this.rootNode = randomNode;
    this.rootNode.level = 1;
  }

  public List<ArrayList<Integer>> drawTree() {
    // start traversing from the root
    Deque<BinTreeNode> deque = inOrderTraverse(this.rootNode);
    List<ArrayList<Integer>> byLevels = new ArrayList<>();
    for (int l = 0; l < maxLevel + 1; l++) {
      byLevels.add(new ArrayList<>());
    }

    // determine the position for each level
    int pos = 1;
    while (!deque.isEmpty()) {
      BinTreeNode node = deque.pollFirst();
      node.pos = pos;
      byLevels.get(node.level).add(pos);
      pos++;
    }

    return byLevels;
  }

  public Deque<BinTreeNode> inOrderTraverse(BinTreeNode node) {
    int thisLevel = node.level;
    // update maximum level
    if (maxLevel < thisLevel) maxLevel = thisLevel;
    Deque<BinTreeNode> deque = new LinkedList<>();

    if (node.leftNode != null) {
      node.leftNode.level = node.level + 1;  // update level
      Deque<BinTreeNode> leftDeque = inOrderTraverse(node.leftNode);
      deque.addAll(leftDeque);  // attach the left tree
    }

    // add current node
    deque.add(node);

    if (node.rightNode != null) {
      node.rightNode.level = node.level + 1;
      Deque<BinTreeNode> rightDeque = inOrderTraverse(node.rightNode);
      deque.addAll(rightDeque);  // attach the right tree
    }

    return deque;
  }
}

class BinTreeNode {
  int name;
  int level;
  int pos;
  BinTreeNode parentNode;
  BinTreeNode leftNode;
  BinTreeNode rightNode;

  BinTreeNode(int name) {
    this.name = name;
    this.level = 0;
    this.pos = 0;
    this.leftNode = null;
    this.rightNode = null;
    this.parentNode = null;
  }
}