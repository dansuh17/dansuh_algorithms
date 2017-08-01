import java.io.*;
import java.util.*;

/**
 * 백준 문제 11004번 'k번째 수'
 * https://www.acmicpc.net/problem/11004
 */
public class KthNumber {
  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static int partition(int[] arr, int start, int end) {
    // partition the array by selecting a pivot
    Random rand = new Random();
    int mid = rand.nextInt(end - start + 1) + start;
    swap(arr, mid, start);
    int pivot = arr[start];

    int i = start;
    int j = end;

    while (i < j) {
      while (arr[i] <= pivot && i < end) {
        i++;
      }

      while (arr[j] > pivot && j > start) {
        j--;
      }

      if (i < j) {
        swap(arr, i, j);
      }
    }

    // at the end of the loop the number at position i == j will have value
    // greater than or equal to the pivot value
    swap(arr, j, start);
    return j;
  }

  /**
   * Find the kth number in an array through partitioning.
   * @param arr array
   * @param k kth number
   * @param start start index of the array
   * @param end end index of the array
   * @return kth number of the array
   */
  public static int kthNum(int[] arr, final int k, int start, int end) {
    if (start > end) return -1;  // can this even happen?

    int piv = partition(arr, start, end);

    if (piv == k) {
      return arr[piv];
    } else if (piv > k) {
      end = piv - 1;
    } else {
      start = piv + 1;
    }

    // tail call
    return kthNum(arr, k, start, end);
  }

  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String[] strs = bf.readLine().split(" ");
    int N = Integer.parseInt(strs[0]);
    int k = Integer.parseInt(strs[1]);

    // create the array
    int[] arr = new int[N];
    // String[] array = bf.readLine().split(" "); // discarded due to timeouts.
    // using StringTokenizer is a bit faster....although discouraged to use in production env.
    StringTokenizer st = new StringTokenizer(bf.readLine());
    for (int n = 0; n < N; n++) {
      arr[n] = Integer.parseInt(st.nextToken());
    }

    System.out.println(kthNum(arr, k - 1, 0, arr.length - 1));
  }
}
