import java.io.*;
import java.util.*;

/**
 * 백준 문제 1463번 '1로 만들기'
 * https://www.acmicpc.net/problem/1463
 */
public class MakeOne {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());

    int[] nums = new int[N + 1];
    nums[0] = -1;
    nums[1] = 0;

    if (N > 1) {
      nums[2] = 1;
    }

    if (N > 2) {
      nums[3] = 1;
    }

    for (int i = 4; i <= N; i++) {
      List<Integer> candidates = new ArrayList<Integer>();
      if ((i % 2) == 0) {
        candidates.add(nums[i / 2]);
      }

      if ((i % 3) == 0) {
        candidates.add(nums[i / 3]);
      }

      candidates.add(nums[i - 1]);

      nums[i] = Collections.min(candidates) + 1;
    }

    System.out.println(nums[N]);
  }
}
