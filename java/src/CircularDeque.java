import java.io.*;
import java.util.*;

/**
 * 백준 문제 1021번 '회전하는 큐'
 * https://www.acmicpc.net/problem/1021
 */
public class CircularDeque {
  public static int popElem(LinkedList<Integer> deque, int target) {
    int size = deque.size();
    int offsetClock = deque.indexOf(target);  // clockwise offset
    int offsetCounter = size - offsetClock;  // counter clockwise offset

    int numOperations;
    if (offsetClock < offsetCounter) {
      numOperations = offsetClock;
      for (int i = 0; i < offsetClock; i++) {
        deque.addLast(deque.removeFirst());
      }
    } else {
      numOperations = offsetCounter;
      for (int i = 0; i < offsetCounter; i++) {
        deque.addFirst(deque.removeLast());
      }
    }
    deque.removeFirst();  // pop the target element

    return numOperations;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] nmStrs = bf.readLine().split(" ");
    int N = Integer.parseInt(nmStrs[0]);
    int M = Integer.parseInt(nmStrs[1]);

    // fill the deque
    LinkedList<Integer> deque = new LinkedList<>();
    for (int n = 0; n < N; n++) {
      deque.addLast(n + 1);
    }

    // i think this can be solved in a greedy manner...
    String[] targetElemsStrs = bf.readLine().split(" ");
    int totalOperations = 0;
    for (int m = 0; m < M; m++) {
      int targetElem = Integer.parseInt(targetElemsStrs[m]);
      totalOperations += popElem(deque, targetElem);
    }

    System.out.println(totalOperations);
  }
}
