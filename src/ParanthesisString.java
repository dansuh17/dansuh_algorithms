import java.io.*;
import java.util.*;

/**
 * 백준 문제 9012번 '괄호'
 * https://www.acmicpc.net/problem/9012
 */
public class ParanthesisString {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(bf.readLine());

    for (int n = 0; n < N; n ++) {
      // create the stack
      Stack<Character> stack = new Stack<Character>();
      Stack<Character> pendingStack = new Stack<Character>();
      String parenthSeq = bf.readLine().trim();
      for (char c : parenthSeq.toCharArray()) {
        stack.push(c);
      }

      boolean isVPS = true;
      while (!stack.isEmpty()) {
        if (stack.peek() == ')') {
          pendingStack.push(stack.pop());
        } else {  // '('
          if (!pendingStack.isEmpty() && (pendingStack.peek() == ')')) {
            pendingStack.pop();
            stack.pop();
          } else {
            // FALSE
            isVPS = false;
            break;
          }
        }
      }

      if (!pendingStack.isEmpty()) {
        isVPS = false;
      }

      String status = isVPS ? "YES" : "NO";
      System.out.println(status);
    }
  }
}
