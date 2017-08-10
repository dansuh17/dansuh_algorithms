import java.io.*;
import java.util.*;

/**
 * 백준 문제 2108번 '통계학'
 * https://www.acmicpc.net/problem/2108
 */
public class Statistics {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int[] numbers = new int[N];
    int[] counts = new int[8001];  // used for getting mode

    int sum = 0;
    int maxCount = 0;
    int min = 4001;
    int max = -4001;
    for (int n = 0; n < N; n++) {
      int num = Integer.parseInt(bf.readLine());
      numbers[n] = num;
      counts[num + 4000]++;
      if (counts[num + 4000] > maxCount) {
        maxCount = counts[num + 4000];
      }

      if (min > num) min = num;
      if (max < num) max = num;
      sum += num;
    }
    Arrays.sort(numbers);
    int median = numbers[N / 2];
    float averageFloat = (float)sum / (float)N;
    int average = Math.round(averageFloat);

    boolean oneFound = false;
    int mode = 0;
    for (int i = 0; i < counts.length; i++) {
      if (!oneFound && counts[i] == maxCount) {
        mode = i - 4000;
        oneFound = true;
        continue;
      }

      // second smallest element
      if (oneFound && counts[i] == maxCount) {
        mode = i - 4000;
        break;
      }
    }

    System.out.println(average);
    System.out.println(median);
    System.out.println(mode);
    System.out.println(max - min);
  }
}
