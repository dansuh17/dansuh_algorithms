import java.io.*;
import java.util.*;

/**
 * 백준 문제 2309번 '일곱 난쟁이'
 * https://www.acmicpc.net/problem/2309
 */
public class SnowWhite {
  public static int getSum(List<Integer> list, int i, int j) {
    int sum = 0;
    for (int n = 0; n < 9; n++) {
      if (n != i && n != j) {
        sum += list.get(n);
      }
    }
    return sum;
  }

  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      list.add(Integer.parseInt(bf.readLine()));
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      for (int j = i + 1; j < 9; j++) {
        if (getSum(list, i, j) == 100) {

          for (int k = 0; k < 9; k++) {
            if (k != i && k != j) {
              result.add(list.get(k));
            }
          }
          Integer[] toSort = result.toArray(new Integer[result.size()]);
          Arrays.sort(toSort);
          for (Integer aResult : toSort) {
            System.out.println(aResult);
          }
          return;
        }
      }
    }
  }
}
