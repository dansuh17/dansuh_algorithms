import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class QuickSort {
  public static void swap(List<Integer> arr, int i, int j) {
    int tmp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, tmp);
  }

  public static int partition(List<Integer> arr, int left, int right) {
    int mid = (left + right) / 2;
    int pivot = arr.get(mid);
    swap(arr, mid, left);  // save the pivot value somewhere

    int i = left;
    int j = right;
    while (i <= j) {
      if (arr.get(i) <= pivot && i <= j) {
        i++;
      }

      if (arr.get(j) > pivot && i <= j) {
        j--;
      }

      if (i <= j) {
        swap(arr, i, j);
      }
    }

    swap(arr, i - 1, left);
    return i - 1; // this is the position of the pivot
  }

  public static void sort(List<Integer> arr, int left, int right) {
    if (left > right) {
      return;
    }

    int part = partition(arr, left, right);
    sort(arr, left, part - 1);
    sort(arr, part + 1, right);
  }

  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));  // faster read
    int n = Integer.parseInt(bf.readLine());

    List<Integer> arr = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      arr.add(Integer.parseInt(bf.readLine()));
    }

    sort(arr, 0, arr.size() - 1);
    for (int j = 0; j < n; j++) {
      System.out.println(arr.get(j));
    }
  }
}
