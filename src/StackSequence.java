import java.io.*;
import java.util.*;

/**
 * 백준 문제 1874번 '스택 수열'
 * https://www.acmicpc.net/problem/1874
 */
public class StackSequence {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());

    Stack<Integer> stack = new Stack<Integer>();
    StringBuilder stringBuilder = new StringBuilder();

    int number = 1;
    for (int i = 0; i < N; i++) {
      // next target to pop
      int nextSequence = Integer.parseInt(bf.readLine());

      if (nextSequence >= number) {
        while (number <= nextSequence) {
          stack.push(number);
          number++;
          stringBuilder.append("+\n");
        }
        stack.pop();
        stringBuilder.append("-\n");
      } else {
        if (nextSequence == stack.peek()) {
          stack.pop();
          stringBuilder.append("-\n");
        } else {
          System.out.println("NO");
          return;
        }
      }
    }

    System.out.println(stringBuilder.toString());
  }
}
