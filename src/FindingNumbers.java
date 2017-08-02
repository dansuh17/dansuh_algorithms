import java.io.*;
import java.util.*;

/**
 * 백준 문제 1902번 '수 찾기'
 * https://www.acmicpc.net/problem/1902
 */
public class FindingNumbers {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int[] arr = new int[N];

    // fill the array
    String[] numbers = bf.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(numbers[i]);
    }

    // sort...quicksort + insertion sort provided by java library
    // sorting takes O(NlogN)
    Arrays.sort(arr);

    // number of queries
    int M = Integer.parseInt(bf.readLine());
    String[] queries = bf.readLine().split(" ");
    for (int m = 0; m < M; m++) {
      int query = Integer.parseInt(queries[m]);

      System.out.println(binarySearch(arr, query, 0, N - 1));
    }
  }

  // binary search - would take O(logN)
  static int binarySearch(int[] arr, int query, int start, int end) {
    if (start > end) {
      return 0;  // does not exist
    }

    int mid = (start + end) / 2;
    if (arr[mid] == query) {
      return 1;
    } else if (arr[mid] > query) {
      return binarySearch(arr, query, start, mid - 1);
    } else {
      return binarySearch(arr, query, mid + 1, end);
    }
  }
}
