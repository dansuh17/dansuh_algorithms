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
    int mid = (start + end) / 2;
    swap(arr, mid, start);
    int pivot = arr[start];

    int i = start + 1;
    int j = end;

    while (i < j) {
      while (arr[i] <= pivot && i < j) {
        i++;
      }

      while (arr[j] > pivot && i < j) {
        j--;
      }

      if (i < j) {
        swap(arr, i, j);
      }
    }


    // at the end of the loop the number at position i == j will have value
    // greater than or equal to the pivot value
    swap(arr, i - 1, start);
    return i - 1;
  }

  /**
   * Find the kth number in an array through partitioning.
   * @param arr array
   * @param k kth number
   * @param start start index of the array
   * @param end end index of the array
   * @return kth number of the array
   */
  public static int kthNum(int[] arr, int k, int start, int end) {
    if (start > end) return -1;  // can this happen?

    int piv = partition(arr, start, end);

    if (piv + 1 == k) {
      return arr[piv];
    } else if (piv  + 1 > k) {
      return kthNum(arr, k, start, piv - 1);
    } else {
      return kthNum(arr, k, piv + 1, end);
    }
  }

  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String[] strs = bf.readLine().split(" ");
    int N = Integer.parseInt(strs[0]);
    int k = Integer.parseInt(strs[1]);

    // create the array
    int[] arr = new int[N];
    String[] arrayStrs = bf.readLine().split(" ");
    for (int n = 0; n < N; n++) {
      arr[n] = Integer.parseInt(arrayStrs[n]);
    }

    System.out.println(kthNum(arr, k, 0, arr.length - 1));
  }
}
