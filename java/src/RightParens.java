import java.math.BigInteger;
import java.util.*;

/**
 * KAKAO practice challenge level 8
 * https://www.welcomekakao.com/learn/challenge_codes/73
 *
 * 올바른 괄호
 *
 * 올바른 괄호란 (())나 ()와 같이 올바르게 모두 닫힌 괄호를 의미합니다.
 * )(나 ())() 와 같은 괄호는 올바르지 않은 괄호가 됩니다.
 * 괄호를 이리저리 움직이며 올바른 괄호를 찾던 민호는 N개의 괄호쌍이 있을 때,
 * 올바른 괄호를 만들 수 있는 경우의 수가 궁금해졌습니다.
 *
 * 괄호 쌍의 개수 N개가 주어졌을 때, 경우의 수를 반환하는 parenthesisCase 함수를 완성해 보세요.
 *
 * 예를 들어
 * N = 1일 경우는 () 의 1가지만 존재하므로 1을 리턴하면 됩니다.
 * 3일 경우에는 ((())), (())(), ()(()), ()()(), (()()) 의 5가지가 존재하므로 5를 리턴하면 됩니다.
 */
class RightParens {
  public BigInteger parenthesisCase(int n) {
    List<ArrayList<BigInteger>> combs = new ArrayList<>();
    for (int i = 0; i < n + 1; i++) {
      combs.add(new ArrayList<>());
    }

    // this is basically an implementation of finding Catalan Number,
    // for finding path from (0, 0) to (n, n) where the path does not exceed the line y = x.
    // 해설 : http://phaskal.tistory.com/26
    for (int i = 0; i < n + 1; i++) {
      ArrayList<BigInteger> thisRow = combs.get(i);
      for (int j = 0; j < i; j++) {
        thisRow.add(BigInteger.ZERO);
      }

      for (int j = i; j < n + 1; j++) {
        if (i == 0) {
          thisRow.add(BigInteger.ONE);
          continue;
        }

        BigInteger result = combs.get(i - 1).get(j).add(combs.get(i).get(j - 1));
        thisRow.add(result);
      }
    }

    return combs.get(n).get(n);
  }

  // 실행을 위한 main입니다.
  public static void main(String[] args) {
    RightParens cp = new RightParens();
    if (cp.parenthesisCase(3).equals(new BigInteger("5"))) {
      System.out.println("parenthesisCase(3)이 정상 동작합니다. 제출을 눌러서 다른 경우에도 정답인지 확인해 보세요.");
    } else {
      System.out.println("parenthesisCase(3)이 정상 동작하지 않습니다.");
    }
  }
}
