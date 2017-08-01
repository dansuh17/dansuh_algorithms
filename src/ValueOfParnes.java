import java.io.*;
import java.util.*;

/**
 * 백준 문제 2504번 '괄호의 값'
 * https://www.acmicpc.net/problem/2504
 *
 * Good practice for PDA and stacks.
 */
public class ValueOfParnes {
  static int popVals(Stack<Val> stack, int level) {
    if (stack.isEmpty() || stack.peek().level != level + 1) {
      return 1;
    }

    int lowerVals = 0;
    while (!stack.isEmpty() && stack.peek().level == level + 1) {
      lowerVals += stack.pop().val;
    }

    return lowerVals;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String parenStatement = bf.readLine().trim();
    Stack<Character> parenStack = new Stack<>();
    Stack<Character> storeStack = new Stack<>();
    Stack<Val> valStack = new Stack<>();  // keep the calculated values

    // get the input string and create a stack
    for (int i = 0; i < parenStatement.length(); i++) {
      char parenChar = parenStatement.charAt(i);
      parenStack.push(parenChar);
    }

    // keep track of the nested level, for calculating values that a set of parens is enclosing
    int nestDepth = 0;
    while (!parenStack.isEmpty()) {
      char topChar = parenStack.peek();
      if (topChar == ')' || topChar == ']') {
        nestDepth++;
        parenStack.pop();
        storeStack.push(topChar);
      } else {
        // if the store stack is empty with open parenthesis, it's WRONG
        if (storeStack.isEmpty()) {
          System.out.println(0);
          return;
        }

        // small parens closed
        if (topChar == '(' && storeStack.peek() == ')') {
          parenStack.pop();
          storeStack.pop();

          int lowerLevelVals = popVals(valStack, nestDepth);
          valStack.push(new Val(lowerLevelVals * 2, nestDepth));
          nestDepth--;
        } else if (topChar == '[' && storeStack.peek() == ']') {
          // brackets closed
          parenStack.pop();
          storeStack.pop();

          int lowerLevelVals = popVals(valStack, nestDepth);
          valStack.push(new Val(lowerLevelVals * 3, nestDepth));
          nestDepth--;
        } else {
          // cannot happen!! parens type mismatch
          System.out.println(0);
          return;
        }
      }
    }  // while end

    // all parallel values for level 0
    int totalVal = popVals(valStack, 0);

    // the store stack should be empty for perfect matches
    if (!storeStack.isEmpty()) {
      System.out.println(0);
    } else {
      System.out.println(totalVal);
    }
  }
}


class Val {
  int val;
  int level;

  Val(int val, int level) {
    this.val = val;
    this.level = level;
  }
}
