import java.io.*;
import java.util.*;

/**
 * 백준 문제 11866번 '조세퍼스 문제'
 * https://www.acmicpc.net/problem/11866
 */
public class Josephers0 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String[] nmStr = bf.readLine().split(" ");
    int N = Integer.parseInt(nmStr[0]);
    int M = Integer.parseInt(nmStr[1]);

    Queue<Integer> queue = new LinkedList<>();
    for (int n = 0; n < N; n++) {
      queue.add(n + 1);
    }

    List<Integer> josephersSequence = new ArrayList<>();

    int popAfter = M;
    while (!queue.isEmpty()) {
      int k = queue.poll();
      if (popAfter == 1) {
        josephersSequence.add(k);
        popAfter = M;
      } else {
        popAfter--;
        queue.add(k);
      }
    }

    printArray(josephersSequence);
  }

  static void printArray(List<Integer> arr) {
    System.out.print("<");
    for (int k = 0; k < arr.size(); k++) {
      System.out.print(arr.get(k));
      if (k != arr.size() - 1) {
        System.out.print(", ");
      }
    }
    System.out.print(">");
    System.out.println();
  }
}
