public class LinkedListNode {
  private LinkedListNode nextNode;
  private int data;

  public LinkedListNode(LinkedListNode nextNode, int data) {
    this.nextNode = nextNode;
    this.data = data;
  }

  public LinkedListNode(int data) {
    this(null, data);
  }

  // getter
  public int getData() {
    return data;
  }

  // setter
  public void setData(int newdata) {
    this.data = newdata;
  }

  // getter
  public LinkedListNode getNextNode() {
    return nextNode;
  }

  // setter
  public void setNextNode(LinkedListNode nextNode) {
    this.nextNode = nextNode;
  }

  public void append(int data) {
    LinkedListNode currNode = this;
    while (currNode.getNextNode() != null) {
      currNode = currNode.getNextNode();
    }
    currNode.setNextNode(new LinkedListNode(data));
  }

  public static void main(String[] args) {
    // LinkedListNode node3 = new LinkedListNode(3);
    // LinkedListNode node2 = new LinkedListNode(node3, 2);
    // LinkedListNode node1 = new LinkedListNode(node2, 1);

    // LinkedListNode node1 = new LinkedListNode(1);
    // LinkedListNode node2 = new LinkedListNode(2);
    // node1.setNextNode(node2);
    // LinkedListNode node3 = new LinkedListNode(3);
    // node2.setNextNode(node3);

    LinkedListNode myList = new LinkedListNode(1);
    myList.append(2);
    myList.append(3);
    myList.append(4);
    myList.append(5);
    myList.append(6);
    myList.append(7);

    myList.printList();
  }

  // recursion
  public void printList() {
    StringBuffer sb = new StringBuffer();
    sb.append(data);
    sb.append(" -> ");

    LinkedListNode currNode = this;
    while (currNode.getNextNode() != null) {
      currNode = currNode.getNextNode();
      sb.append(currNode.getData());
      sb.append(" -> ");
    }
    sb.append("null");
    System.out.println(sb.toString());
  }
}
