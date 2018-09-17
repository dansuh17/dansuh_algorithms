import java.io.*;
import java.util.*;

/**
 * 백준 문제 1966번 '프린터 큐'
 * https://www.acmicpc.net/problem/1966
 */
public class PrinterQueue {
  public static void findPrintOrder(BufferedReader bf) throws java.io.IOException {
    String[] options = bf.readLine().split(" ");
    int N = Integer.parseInt(options[0]);
    int M = Integer.parseInt(options[1]);
    String[] priorities = bf.readLine().split(" ");
    Queue<Pair> queue = new LinkedList<>();
    List<Integer> priorityList = new ArrayList<>();

    for (int n = 0; n < N; n++) {
      int p = Integer.parseInt(priorities[n]);
      queue.add(new Pair(n, p));
      priorityList.add(p);
    }
    Collections.sort(priorityList);
    Stack<Integer> stack = new Stack<>();
    stack.addAll(priorityList);

    int printOrder = 0;
    while (!queue.isEmpty()) {
      int thisPriority = stack.pop();

      Pair pair = queue.poll();
      while (pair.priority != thisPriority) {
        queue.add(pair);
        pair = queue.poll();
      }

      printOrder++;
      if (pair.id == M) {
        System.out.println(printOrder);
        return;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int numTests = Integer.parseInt(bf.readLine());

    for (int t = 0; t < numTests; t++) {
      findPrintOrder(bf);
    }
  }
}

class Pair {
  int id;
  int priority;

  Pair(int id, int priority) {
    this.id = id;
    this.priority = priority;
  }
}
