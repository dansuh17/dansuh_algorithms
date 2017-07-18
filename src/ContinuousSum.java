import java.io.*;
import java.util.*;

/**
 * 백준 문제 1912번 '연속합'
 * https://www.acmicpc.net/problem/1912
 */
public class ContinuousSum {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int[] nums = new int[N];
    int[] tmp = new int[N];

    // fill in the array
    String[] strs = bf.readLine().split(" ");
    int result = Integer.parseInt(strs[0]);
    tmp[0] = result;

    for (int i = 1; i < N; i++) {
      int currVal = Integer.parseInt(strs[i]);
      nums[i] = currVal;

      int maxSum = (tmp[i - 1] + currVal) < currVal ? currVal : tmp[i - 1] + currVal;
      result = result < maxSum ? maxSum : result;
      tmp[i] = maxSum;
    }

    System.out.println(result);
  }
}
